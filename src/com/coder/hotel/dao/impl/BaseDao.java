package com.coder.hotel.dao.impl;

import com.coder.hotel.util.*;

import java.lang.invoke.VarHandle;
import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @author teacher_shi
 */
public class BaseDao<T> {
    private Class<T> persistentClass;

    public BaseDao() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            persistentClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        }
    }

    public int save(T entity) {
        //获取当前对象的字节码
        Class<?> aClass = entity.getClass();
        //循环遍历所有的字段
        Field[] declaredFields = aClass.getDeclaredFields();

        //获取当前实体类对象的主键生成方式
        IdType idType = null;
        for (Field field : declaredFields) {
            TableId annotation = field.getAnnotation(TableId.class);
            if (annotation != null) {
                idType = annotation.value();
                break;
            }
        }
        //哪些字段是有TableField(exist=false) 判断在数据库中是否存在
        List<Field> notExists=new ArrayList<>();//要存储并不存在的字段
        for(Field field:declaredFields){
            TableField tableField=field.getAnnotation(TableField.class);
            if(tableField!=null){
                boolean exists=tableField.exists();
                if(!exists){
                    notExists.add(field);
                }
            }
        }
        Object[] values = new Object[declaredFields.length-notExists.size()];

        //拼接sql
        //insert into 表名 (字段列表) values(?,?,?);
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(aClass.getSimpleName().toLowerCase(Locale.ROOT)).append("(");
        int index = 0;
        for (Field field : declaredFields) {
            if(!notExists.contains(field)) {
                sql.append(field.getName()).append(",");
                field.setAccessible(true);
                try {
                    values[index++] = field.get(entity);//将所有字段的值都存在一个Object数组中
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        sql.setCharAt(sql.length() - 1, ')');
        sql.append(" values (");
        for (int i = 0; i < values.length; i++) {
            sql.append("?,");
        }

        if (idType == IdType.UUID) {
            values[0] = UUID.randomUUID().toString().replace("-", "");
        } else if (idType == IdType.AUTO_INCREMENT) {
            //insert into 表名 (字段列表) values(default,?,?);
            int x = sql.indexOf("?");
            sql.replace(x, x + 1, "default");
            //原数组：[0, 陆游, 西安, 30, 西安市燕塔区]
            //最终:  [陆游, 西安, 30, 西安市燕塔区,西安市燕塔区]
            System.arraycopy(values, 1, values, 0, values.length - 1);
            values = Arrays.copyOf(values, values.length - 1);
        }
        //System.out.println(Arrays.toString(values));
        sql.setCharAt(sql.length() - 1, ')');
        //System.out.println(sql);
        return DBUtil.executeUpdatePrepared(sql.toString(), values);
        //return -1;
    }

    public int delete(Object id) {
        //把当前要删除的类，所有的属性取出，循环判断，其中是否包含有id 或Id的字样，如果是的话
        // 就是要删除的where 条件
        try {
            T entity = persistentClass.getDeclaredConstructor().newInstance();
            String name = persistentClass.getSimpleName();//获取当前操作类的名字
            Field[] fields = entity.getClass().getDeclaredFields();
            String idFieldName = null;
            for (Field field : fields) {
                if (field.getName().contains("id") || field.getName().contains("Id")) {
                    idFieldName = field.getName();
                    break;
                }
            }
            String sql = "delete from " + name.toLowerCase(Locale.ROOT) + " where " + idFieldName + "=?";
            //System.out.println(sql);
            return DBUtil.executeUpdatePrepared(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(T entity) {
        // String sql="update 表名 set 字段1=?，字段2=?... where id字段=?";
        Class<?> aClass = entity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        List<Field> notExists=new ArrayList<>();//要存储不存在的字段
        for(Field field:fields){
            TableField tableField=field.getAnnotation(TableField.class);
            if(tableField!=null){
                boolean exists=tableField.exists();
                if(!exists){
                    notExists.add(field);
                }
            }
        }

        Object[] values = new Object[fields.length-notExists.size()];
        StringBuilder sql = new StringBuilder("update ");
        sql.append(aClass.getSimpleName().toLowerCase(Locale.ROOT)).append(" set ");
        String id = null;
        int index = 0;
        for (Field field : fields) {
            if(!notExists.contains(field)) {
                String fieldName = field.getName();//id name  getId getName
                //将首字母取出，转成大写方式
                String firstLetter = String.valueOf(fieldName.charAt(0)).toUpperCase(Locale.ROOT);
                //获取Method方法，getXXX的方法
                Method method = null;
                try {
                    //针对boolean类型，会生成isXXX的方法，进行判断
                    if (field.getType().getSimpleName().equals("boolean"))
                        method = aClass.getDeclaredMethod("is" + firstLetter + fieldName.substring(1));
                    else
                        method = aClass.getDeclaredMethod("get" + firstLetter + fieldName.substring(1));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                //获取主键的字段名
                if (fieldName.contains("id") || fieldName.contains("Id")) {
                    id = fieldName;
                } else {
                    sql.append(field.getName()).append("=?,");
                }
                try {
                    //通过字段调用get方法取值
                    //field.setAccessible(true);
                    //values[index++]=field.get(entity);
                    //通过调用getXXX的方法获取值
                    values[index++] = method.invoke(entity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        //将id元素放在数组的最后一位
        Object t = values[0];
        System.arraycopy(values, 1, values, 0, values.length - 1);
        values[values.length - 1] = t;
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append("where ").append(id).append("=?");
        return DBUtil.executeUpdatePrepared(sql.toString(), values);
    }

    public T selectId(Object id) {
        //String sql="select id,name,gender... from 表名 where 主键=?";
        StringBuilder sql = new StringBuilder("select ");
        T entity = null;
        Class<?> aClass = null;
        try {
            entity = persistentClass.getDeclaredConstructor().newInstance();
            aClass = entity.getClass();
            Field[] fields = aClass.getDeclaredFields();
            List<Field> notExists=new ArrayList<>();//要存储不存在的字段
            for(Field field:fields){
                TableField tableField=field.getAnnotation(TableField.class);
                if(tableField!=null){
                    boolean exists=tableField.exists();
                    if(!exists){
                        notExists.add(field);
                    }
                }
            }
            String idFieldName = null;
            for (Field field : fields) {
                if(!notExists.contains(field)) {
                    String name = field.getName();
                    sql.append(name).append(",");
                }
            }
            for (Field field : fields) {
                String name = field.getName();
                if (name.contains("id") || name.contains("Id")) {
                    idFieldName = name;
                    break;
                }
            }
            sql.setCharAt(sql.length() - 1, ' ');
            sql.append("from " + aClass.getSimpleName().toLowerCase(Locale.ROOT))
                    .append(" where ").append(idFieldName).append("=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBObject dbObject = DBUtil.executeQueryPrepared(sql.toString(), id);
        ResultSet resultSet = dbObject.getResultSet();
        ResultSetMetaData metaData = null;
        try {
            metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();
            if (resultSet.next()) {
                for (int i = 0; i < count; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String colName = metaData.getColumnLabel(i + 1);
                    Field field = aClass.getDeclaredField(colName);
                    field.setAccessible(true);
                    field.set(entity, value);
                }
                DBUtil.close(dbObject);
                return entity;
            }
        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> selectList() {
        //String sql="select 字段1,字段2...from 表名";
        T entity = null;
        StringBuilder sql = new StringBuilder("select ");
        try {
            entity = persistentClass.getDeclaredConstructor().newInstance();
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                sql.append(field.getName()).append(",");
            }
            sql.setCharAt(sql.length() - 1, ' ');
            sql.append("from ").append(entity.getClass().getSimpleName().toLowerCase(Locale.ROOT));

        } catch (Exception e) {
            e.printStackTrace();
        }
        DBObject dbObject = DBUtil.executeQueryPrepared(sql.toString());
        ResultSet resultSet = dbObject.getResultSet();
        List<T> list = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();
            while (resultSet.next()) {
                T t = persistentClass.getDeclaredConstructor().newInstance();
                for (int i = 0; i < count; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String colName = metaData.getColumnLabel(i + 1);
                    Field field = t.getClass().getDeclaredField(colName);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
            DBUtil.close(dbObject);
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Object[][] listToArray(List<T>list) {
        Object[][] data =null;
        try {
            T entity = persistentClass.getDeclaredConstructor().newInstance();
            Class<?> aClass = entity.getClass();
            Field[] fields=aClass.getDeclaredFields();
            data=new Object[list.size()][fields.length];
            Object[] objects=list.toArray();
            for (int i = 0; i < objects.length; i++) {
                //每次从集合中取出一个对象objects[i];
                for (int j = 0; j < fields.length; j++) {
                    //每次从对象中取出一个属性
                    String name=fields[j].getName();//id  type
                    String first= name.substring(0,1).toUpperCase(Locale.ROOT);
                    String suffix=name.substring(1);
                    Method method=aClass.getDeclaredMethod("get"+first+suffix);
                    data[i][j]=method.invoke(objects[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}