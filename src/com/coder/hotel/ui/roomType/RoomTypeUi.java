/*
 * Created by JFormDesigner on Mon Apr 21 14:54:01 CST 2025
 */

package com.coder.hotel.ui.roomType;

import java.awt.event.*;
import com.coder.hotel.entity.RoomType;
import com.coder.hotel.service.RoomTypeService;
import com.coder.hotel.ui.MainUi;
import com.coder.hotel.util.CustomModel;
import com.coder.hotel.util.TableStyle;
import com.coder.hotel.util.TableUtil;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class RoomTypeUi extends JFrame {
    private RoomTypeUi() {
        initComponents();
    }
    private static final RoomTypeUi UI =new RoomTypeUi();
    public static RoomTypeUi getInstance(){
        return UI;
    }

    private void goBack(ActionEvent e) {
        UiUtil.indent(UI, MainUi.getFrame());
    }

    /*class CustomModel extends DefaultTableModel {
        public CustomModel(Object [][] data,Object[]column){
            super(data,column);
        }
        //禁止jtable可编辑
        @Override
        public boolean isCellEditable(int row,int column){
            return false;
        }
    }*/
    //修改操作
    public void update (ActionEvent e){
        //获取用户选择的表的行数
        int rowCount=table1.getSelectedRowCount();
        if(rowCount==0){
            JOptionPane.showMessageDialog(table1,"请至少选择一行","提示信息",JOptionPane.WARNING_MESSAGE);
        }else if(rowCount>1){
            JOptionPane.showMessageDialog(table1,"只能修改一行数据","提示信息",JOptionPane.WARNING_MESSAGE);
        }else{
            int row=table1.getSelectedRow();
            Object id = table1.getValueAt(row, 0);
            RoomTypeService service =new RoomTypeService();
            RoomType roomtype =service.selectId(id);
            RoomTypeUpdateUi typeUpdateUi = RoomTypeUpdateUi.getInstance();
            typeUpdateUi.setRoomType(roomtype);
            typeUpdateUi.setTable(table1);
            UiUtil.indent(UI,typeUpdateUi);
        }
    }
    //跳转到增加界面
    private void goAdd(ActionEvent e){
        RoomTypeAddUi typeAddUi = RoomTypeAddUi.getInstance();
        typeAddUi.setTable(table1);
        UiUtil.indent(UI,typeAddUi);
    }

    //执行查询处理
    public void query(ActionEvent e){
        String text=textField1.getText();
        if(text.equals("")){
            //查询全部数据
            objects = service.selectList();
        }else{
            //按给定的值查询
            objects=service.selectByType(text);
        }
        //将查询的结果重新放回到model中
        model.setDataVector(objects,column);
        //表格更新
        table1.updateUI();
        textField1.setText("");
    }

    //执行删除处理
    public void delete(ActionEvent e) {
        TableUtil.delete(table1,model,service);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        setResizable(false);
        label1 = new JLabel();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button9 = new JButton();
        scrollPane1 = new JScrollPane();
        //先从数据库中提取数据
        service =new RoomTypeService();
        objects = service.selectList();
        //将数据转成Object[][]
        /*Object[][]values=new Object[roomTypes.size()][6];
        int index=0;
        for (RoomType roomType : roomTypes) {
            values[index][0]=roomType.getId();
            values[index][1]=roomType.getType();
            values[index][2]=roomType.getPrice();
            values[index][3]=roomType.getDeposit();
            values[index][4]=roomType.getBednum();
            values[index][5]=roomType.getRemark();
            index++;
        }*/
        //获取表格数据
        column= new String []{"id","类型","价格","押金","床位数","备注"};
        //放入model中
        model=new CustomModel(objects,column);

        table1 = new JTable(model);
        TableStyle.setStyle(table1);
        button1 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u623f\u578b\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u623f\u578b\u7ba1\u7406");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(30, 15, 750, 50);

        //---- button6 ----
        button6.setText("\u65b0\u589e");
        button6.setIcon(new ImageIcon(getClass().getResource("/img/新增.png")));
        contentPane.add(button6);
        button6.setBounds(25, 130, 90, 50);
        button6.addActionListener(this::goAdd);

        //---- button7 ----
        button7.setText("\u5220\u9664");
        button7.setIcon(new ImageIcon(getClass().getResource("/img/删 除 .png")));
        contentPane.add(button7);
        button7.setBounds(115, 130, 85, 50);
        button7.addActionListener(this::delete);

        //---- button8 ----
        button8.setText("\u4fee\u6539");
        button8.setIcon(new ImageIcon(getClass().getResource("/img/修改.png")));
        contentPane.add(button8);
        button8.setBounds(200, 130, 85, 50);
        button8.addActionListener(this::update);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u623f\u95f4\u7c7b\u578b");
            panel1.add(label2);
            label2.setBounds(40, 10, label2.getPreferredSize().width, 34);
            panel1.add(textField1);
            textField1.setBounds(90, 10, 320, 40);

            //---- button9 ----
            button9.setText("\u67e5\u8be2");
            button9.setIcon(new ImageIcon(getClass().getResource("/img/查询.png")));
            panel1.add(button9);
            button9.setBounds(410, 10, 80, 40);
            button9.addActionListener(this::query);
        }
        contentPane.add(panel1);
        panel1.setBounds(25, 75, 750, 55);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 180, 750, 265);

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        button1.addActionListener(e -> {
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
		});
        contentPane.add(button1);
        button1.setBounds(630, 450, 100, 45);

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label3);
        label3.setBounds(0, 0, 800, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JPanel panel1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button9;
    private JScrollPane scrollPane1;
    private JTable table1;
    private CustomModel model;
    private JButton button1;
    private JLabel label3;
    private Object[][] objects;
    private RoomTypeService service;
    private String[] column;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
