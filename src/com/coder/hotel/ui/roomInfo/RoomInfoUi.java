/*
 * Created by JFormDesigner on Tue Apr 29 20:22:57 CST 2025
 */

package com.coder.hotel.ui.roomInfo;

import com.coder.hotel.entity.RoomInfo;
import com.coder.hotel.entity.RoomType;
import com.coder.hotel.service.RoomInfoService;
import com.coder.hotel.service.RoomTypeService;
import com.coder.hotel.ui.MainUi;
import com.coder.hotel.ui.roomType.RoomTypeUpdateUi;
import com.coder.hotel.util.Page;
import com.coder.hotel.util.StringUtil;
import com.coder.hotel.util.TableStyle;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class RoomInfoUi extends JFrame {
    private RoomInfoUi() {
        initComponents();
    }
    private static final RoomInfoUi UI=new RoomInfoUi();
    public static RoomInfoUi getInstance(){
        return UI;
    }

    class CustomModel extends DefaultTableModel {
        public CustomModel(Object [][] data,Object[]column){
            super(data,column);
        }
        //禁止jtable可编辑
        @Override
        public boolean isCellEditable(int row,int column){
            return false;
        }
    }

    //下面四个方法可封装()
    //下面四个方法可封装()
    //下面四个方法可封装()


    //处理分页按钮事件
    private void first(ActionEvent e){
        Page pageInfo=service.getPage(1);
        column =new String[]{"id","楼层","房型id","房间类型","房间号","单价","押金","电话","状态","备注"};
        data=service.selectList(1);
        model.setDataVector(data,column);
        //设置一下当前页
        page.setText(pageInfo.getPage().toString());
        table1.updateUI();
        doHide();
    }
    private void previous(ActionEvent e) {
        Page pageInfo = service.getPage(1); // 获取分页信息（总页数等）
        String c = page.getText(); // 当前页码文本
        Long currentPage = Long.parseLong(c); // 当前页码数字

        if (currentPage > 1) {
            pageInfo.setPage(currentPage - 1); // 设置上一页页码

            column = new String[]{"id", "楼层", "房型id", "房间类型", "房间号", "单价", "押金", "电话", "状态", "备注"};
            long p = pageInfo.getPage();
            data = service.selectList((int) p); // 查询上一页数据

            model.setDataVector(data, column); // 更新表格
            page.setText(pageInfo.getPage().toString()); // 更新当前页文本
            table1.updateUI();
        }
        doHide();
    }
    /*private void previous(ActionEvent e){
        Page pageInfo=service.getPage(1);
        String c=page.getText();//获取当前页码
        if(!equals("1")){
            pageInfo.setPage(Long.parseLong(c)-1);
            column =new String[]{"id","楼层","房型id","房间类型","房间号","单价","押金","电话","状态","备注"};
            long p=pageInfo.getPage();
            data=service.selectList((int)p);
            model.setDataVector(data,column);
            //设置一下当前页
            page.setText(pageInfo.getPage().toString());
            table1.updateUI();
        }
    }*/
    private void next(ActionEvent e){
        Page pageInfo=service.getPage(1);
        //获取最后一页
        Long lastPage=pageInfo.getPages();
        //获取当前页码
        String c=page.getText();
        Long currentPage=Long.parseLong(page.getText());
        if(currentPage<lastPage){
            pageInfo.setPage(currentPage+1);
            column =new String[]{"id","楼层","房型id","房间类型","房间号","单价","押金","电话","状态","备注"};
            long p=pageInfo.getPage();
            data=service.selectList((int)p);
            model.setDataVector(data,column);
            //设置一下当前页
            page.setText(pageInfo.getPage().toString());
            table1.updateUI();
        }
        doHide();
    }
    private void last(ActionEvent e){
        Page pageInfo=service.getPage(1);
        pageInfo.setPage(pageInfo.getPages());//设置当前页是最后一页
        column =new String[]{"id","楼层","房型id","房间类型","房间号","单价","押金","电话","状态","备注"};
        long p=pageInfo.getPage();
        data=service.selectList((int)p);
        model.setDataVector(data,column);
        //设置一下当前页
        page.setText(pageInfo.getPage().toString());
        table1.updateUI();
        doHide();
    }
    private void doHide(){
        table1.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        table1.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        table1.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(0);
    }




    public void delete(ActionEvent e) {
        //获取用户选择的表的行数
        int rowCount=table1.getSelectedRowCount();
        //判断用户是否选择了表格中的数据
        if(rowCount==0){
            JOptionPane.showMessageDialog(table1,"请至少选择一行");
        }else{
            int y=JOptionPane.showConfirmDialog(table1,"确定要删除数据吗？","提示信息",JOptionPane.YES_NO_OPTION);
            //y==0表示用户点击了确定
            if(y==0){
                int [] selectedRows=table1.getSelectedRows();
                //删除数据库表中的数据
                for (int selectedRow : selectedRows) {
                    Object id=model.getValueAt(selectedRow,0);
                    service.deleteId(id);
                }
                //清除表格中的数据
                for(int i=selectedRows.length-1;i>=0;i--){
                    int x=table1.getSelectedRow();
                    model.removeRow(x);
                }
            }

        }
        //table1.updateUI();//刷新界面
        Page pageInfo=service.getPage(1);
        total.setText(pageInfo.getTotal().toString());
        first(e);
    }

    public void add(ActionEvent actionEvent) {
        //页面跳转
        RoomInfoAddUi infoAddUi = RoomInfoAddUi.getInstance();
        infoAddUi.setTable(table1);
        infoAddUi.setTotal(total);
        infoAddUi.setPages(page);
        UiUtil.indent(UI,infoAddUi);

    }
    private void update(ActionEvent e){
        //获取用户选择的表的行数
        int rowCount=table1.getSelectedRowCount();
        if(rowCount==0){
            JOptionPane.showMessageDialog(table1,"请至少选择一行","提示信息",JOptionPane.WARNING_MESSAGE);
        }else if(rowCount>1){
            JOptionPane.showMessageDialog(table1,"只能修改一行数据","提示信息",JOptionPane.WARNING_MESSAGE);
        }else{
            int row=table1.getSelectedRow();
            Object id = table1.getValueAt(row, 0);
            RoomInfoService service =new RoomInfoService();
            RoomInfo info=service.selectId(id);
            System.out.println(info);
            RoomInfoUpdateUi infoUpdateUi = RoomInfoUpdateUi.getInstance();
            infoUpdateUi.setInfo(info);
            infoUpdateUi.setTable(table1);
            UiUtil.indent(UI,infoUpdateUi);

        }


    }

    private void goBack(ActionEvent e) {
        // TODO add your code here
        first(e);
        UiUtil.indent(UI, MainUi.getFrame());

    }

    private void query(ActionEvent e){
        String type=textField1.getText();
        String level= StringUtil.isEmpty(textField2.getText())?"0":textField2.getText();
        String roomnum=textField3.getText();
        //将数据封装成一个Room Info对象，传给service层，去做查询处理
        RoomInfo info=new RoomInfo();
        info.setType(type);
        info.setLevel(Integer.valueOf(level));
        info.setRoomnum(roomnum);
        Page pageInfo=service.getPage(1);
        column =new String[]{"id","楼层","房型id","房间类型","房间号","单价","押金","电话","状态","备注"};
        data=service.selectExample(info,1);
        model.setDataVector(data,column);
        page.setText(pageInfo.getPage().toString());
        table1.updateUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        queryBtn = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        addBtn = new JButton();
        deleteBtn = new JButton();
        updateBtn = new JButton();
        backBtn = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label8 = new JLabel();
        total = new JLabel();
        label10 = new JLabel();
        page = new JLabel();
        label12 = new JLabel();
        pages = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u623f\u95f4\u7ba1\u7406");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u623f\u95f4\u7ba1\u7406");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(0, 20, 800, 50);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u623f\u95f4\u7c7b\u578b");
            panel1.add(label2);
            label2.setBounds(40, 10, label2.getPreferredSize().width, 34);
            panel1.add(textField1);
            textField1.setBounds(105, 10, 120, 40);

            //---- queryBtn ----
            queryBtn.setText("\u67e5\u8be2");
            queryBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u8be2.png")));
            panel1.add(queryBtn);
            queryBtn.setBounds(640, 10, 80, 40);

            //---- label4 ----
            label4.setText("\u623f\u95f4\u7c7b\u578b");
            panel1.add(label4);
            label4.setBounds(0, 55, 48, 34);

            //---- label5 ----
            label5.setText("\u623f\u95f4\u697c\u5c42");
            panel1.add(label5);
            label5.setBounds(240, 10, 48, 34);

            //---- label3 ----
            label3.setText("\u623f\u95f4\u53f7\u7801");
            panel1.add(label3);
            label3.setBounds(440, 10, 48, 34);
            panel1.add(textField2);
            textField2.setBounds(300, 10, 120, 40);
            panel1.add(textField3);
            textField3.setBounds(505, 10, 120, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(25, 80, 750, 55);

        //---- addBtn ----
        addBtn.setText("\u65b0\u589e");
        addBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u65b0\u589e.png")));
        contentPane.add(addBtn);
        addBtn.setBounds(25, 135, 90, 50);

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664");
        deleteBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u5220 \u9664 .png")));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(115, 135, 85, 50);

        //---- updateBtn ----
        updateBtn.setText("\u4fee\u6539");
        updateBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u4fee\u6539.png")));
        contentPane.add(updateBtn);
        updateBtn.setBounds(200, 135, 85, 50);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addActionListener(e -> {
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
			goBack(e);
		});
        contentPane.add(backBtn);
        backBtn.setBounds(690, 440, 90, 40);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 185, 750, 180);

        //---- button1 ----
        button1.setText("\u9996\u9875");
        contentPane.add(button1);
        button1.setBounds(330, 440, 90, 40);

        //---- button2 ----
        button2.setText("\u4e0a\u4e00\u9875");
        contentPane.add(button2);
        button2.setBounds(420, 440, 90, 40);

        //---- button3 ----
        button3.setText("\u4e0b\u4e00\u9875");
        contentPane.add(button3);
        button3.setBounds(510, 440, 90, 40);

        //---- button4 ----
        button4.setText("\u5c3e\u9875");
        contentPane.add(button4);
        button4.setBounds(600, 440, 90, 40);

        //---- label8 ----
        label8.setText("\u603b\u8bb0\u5f55\uff1a");
        label8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label8.setForeground(Color.white);
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(35, 450), label8.getPreferredSize()));

        //---- total ----
        total.setText("100");
        total.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        total.setForeground(Color.white);
        contentPane.add(total);
        total.setBounds(new Rectangle(new Point(90, 450), total.getPreferredSize()));

        //---- label10 ----
        label10.setText("\u5f53\u524d\u9875\uff1a");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label10.setForeground(Color.white);
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(120, 450), label10.getPreferredSize()));

        //---- page ----
        page.setText("1");
        page.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        page.setForeground(Color.white);
        contentPane.add(page);
        page.setBounds(new Rectangle(new Point(175, 450), page.getPreferredSize()));

        //---- label12 ----
        label12.setText("\u603b\u9875\u6570\uff1a");
        label12.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label12.setForeground(Color.white);
        contentPane.add(label12);
        label12.setBounds(new Rectangle(new Point(195, 450), label12.getPreferredSize()));

        //---- pages ----
        pages.setText("20");
        pages.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        pages.setForeground(Color.white);
        contentPane.add(pages);
        pages.setBounds(new Rectangle(new Point(250, 450), pages.getPreferredSize()));

        //---- label6 ----
        label6.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label6);
        label6.setBounds(0, 0, label6.getPreferredSize().width, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JTextField textField1;
    private JButton queryBtn;
    private JLabel label4;
    private JLabel label5;
    private JLabel label3;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton backBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label8;
    private JLabel total;
    private JLabel label10;
    private JLabel page;
    private JLabel label12;
    private JLabel pages;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
