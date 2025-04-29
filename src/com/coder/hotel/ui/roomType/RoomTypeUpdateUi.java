/*
 * Created by JFormDesigner on Mon Apr 28 14:16:53 CST 2025
 */

package com.coder.hotel.ui.roomType;

import com.coder.hotel.entity.RoomType;
import com.coder.hotel.service.RoomTypeService;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class RoomTypeUpdateUi extends JFrame {
    private RoomTypeUpdateUi() {
        initComponents();
    }
    private static final RoomTypeUpdateUi UI=new RoomTypeUpdateUi();
    public static RoomTypeUpdateUi getInstance(){
        return UI;
    }

    private void update(ActionEvent e) {
        // TODO add your code here
        String typeValue=type.getText();
        if(typeValue.equals("")){
            JOptionPane.showMessageDialog(this,"请填写房型！");
            return;
        }
        String priceValue=price.getText();
        if(priceValue.equals("")){
            JOptionPane.showMessageDialog(this,"请填写单价！");
            return;
        }
        String depositValue=deposit.getText();
        if(depositValue.equals("")){
            JOptionPane.showMessageDialog(this,"请填写押金！");
            return;
        }
        String bednumValue=bednum.getText();
        if(bednumValue.equals("")){
            JOptionPane.showMessageDialog(this,"请填写床位数！");
            return;
        }
        String remarkValue=remark.getText();
        roomType.setType(typeValue);
        roomType.setPrice(Integer.parseInt(priceValue));
        roomType.setDeposit(Integer.parseInt(depositValue));
        roomType.setBednum(Integer.parseInt(bednumValue));
        roomType.setRemark(remarkValue);
        RoomTypeService service =new RoomTypeService();
        int i=service.update(roomType);
        if(i>0){
            //将RoomTypeUi传过来的JTable进行刷新
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            //重新查询一下数据库
            Object[][] objects=service.selectList();
            model.setDataVector(objects,new String []{"id","类型","价格","押金","床位数","备注"});
            table.updateUI();
            JOptionPane.showMessageDialog(this,"更新成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
            goBack(e);
        }
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        init();
    }
    private void init(){
        type.setText(roomType.getType());
        price.setText(roomType.getPrice().toString());
        deposit.setText(roomType.getDeposit().toString());
        bednum.setText(roomType.getBednum().toString());
        remark.setText(roomType.getRemark());
    }

    private void goBack(ActionEvent e) {
        // TODO add your code here
        UiUtil.indent(UI,RoomTypeUi.getInstance());
    }

    private void initComponents() {
        setResizable(false);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        type = new JTextField();
        price = new JFormattedTextField();
        bednum = new JFormattedTextField();
        deposit = new JFormattedTextField();
        okBtn = new JButton();
        resetBtn = new JButton();
        backBtn = new JButton();
        scrollPane1 = new JScrollPane();
        remark = new JTextArea();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label7 = new JLabel();


        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406_\u623f\u578b\u7ba1\u7406_\u66f4\u65b0");
        setFocusTraversalPolicyProvider(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u623f\u578b\u7ba1\u7406");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(20, 35, 750, 50);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            panel1.setForeground(Color.red);
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u623f\u578b");
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label2);
            label2.setBounds(20, 20, 60, 25);

            //---- label3 ----
            label3.setText("\u5355\u4ef7");
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label3);
            label3.setBounds(20, 60, 60, 25);

            //---- label4 ----
            label4.setText("\u5e8a\u4f4d\u6570");
            label4.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label4);
            label4.setBounds(20, 140, 60, 25);

            //---- label5 ----
            label5.setText("\u62bc\u91d1");
            label5.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label5);
            label5.setBounds(20, 100, 60, 25);

            //---- label6 ----
            label6.setText("\u5907\u6ce8");
            label6.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label6);
            label6.setBounds(20, 180, 60, 25);
            panel1.add(type);
            type.setBounds(90, 15, 280, 35);
            panel1.add(price);
            price.setBounds(90, 55, 280, 35);
            panel1.add(bednum);
            bednum.setBounds(90, 135, 280, 35);
            panel1.add(deposit);
            deposit.setBounds(90, 95, 280, 35);

            //---- okBtn ----
            okBtn.setText("\u786e\u5b9a");
            okBtn.addActionListener(e -> update(e));
            panel1.add(okBtn);
            okBtn.setBounds(90, 280, 78, 34);

            //---- resetBtn ----
            resetBtn.setText("\u91cd\u7f6e");
            resetBtn.addActionListener(e -> reset(e));
            panel1.add(resetBtn);
            resetBtn.setBounds(190, 280, 78, 34);

            //---- backBtn ----
            backBtn.setText("\u8fd4\u56de");
            backBtn.addActionListener(e -> goBack(e));
            panel1.add(backBtn);
            backBtn.setBounds(292, 280, 78, 34);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(remark);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(90, 185, 280, 85);

            //---- label8 ----
            label8.setText("*");
            label8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            label8.setForeground(Color.red);
            panel1.add(label8);
            label8.setBounds(375, 25, 7, 19);

            //---- label9 ----
            label9.setText("*");
            label9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            label9.setForeground(Color.red);
            panel1.add(label9);
            label9.setBounds(new Rectangle(new Point(375, 65), label9.getPreferredSize()));

            //---- label10 ----
            label10.setText("*");
            label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            label10.setForeground(Color.red);
            panel1.add(label10);
            label10.setBounds(375, 105, 7, 19);

            //---- label11 ----
            label11.setText("*");
            label11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            label11.setForeground(Color.red);
            panel1.add(label11);
            label11.setBounds(375, 145, 7, 19);
        }
        contentPane.add(panel1);
        panel1.setBounds(180, 115, 450, 335);

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label7);
        label7.setBounds(0, 0, 800, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField type;
    private JFormattedTextField price;
    private JFormattedTextField bednum;
    private JFormattedTextField deposit;
    private JButton okBtn;
    private JButton resetBtn;
    private JButton backBtn;
    private JScrollPane scrollPane1;
    private JTextArea remark;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label7;
    private JTable table;
    public JTable getTable() {
        return table;
    }
    public void setTable(JTable table) {
        this.table = table;
    }

    private RoomType roomType;
    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
        init();
    }


    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
