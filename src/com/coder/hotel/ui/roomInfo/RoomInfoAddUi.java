  /*
 * Created by JFormDesigner on Fri May 02 15:49:22 CST 2025
 */

package com.coder.hotel.ui.roomInfo;

import com.coder.hotel.service.RoomTypeService;

import java.awt.*;
import javax.swing.*;

/**
 * @author bulang
 */
public class RoomInfoAddUi extends JFrame {
    private RoomInfoAddUi() {
        initComponents();
    }
    private static final RoomInfoAddUi UI=new RoomInfoAddUi();
    public static RoomInfoAddUi getInstance(){
        return UI;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        level = new JFormattedTextField();
        label3 = new JLabel();
        //查询房间类型的数据，将数据放到type下拉列表中
        typeService =new RoomTypeService();
        Object[] types=typeService.getTypes();
        type = new JComboBox(types);


        label4 = new JLabel();
        roomnum = new JTextField();
        label5 = new JLabel();
        price = new JFormattedTextField();
        label6 = new JLabel();
        deposit = new JFormattedTextField();
        label7 = new JLabel();
        tel = new JTextField();
        label8 = new JLabel();
        s1 = new JRadioButton();
        s2 = new JRadioButton();
        s3 = new JRadioButton();
        scrollPane1 = new JScrollPane();
        remark = new JTextArea();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label10 = new JLabel();

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
        label1.setBounds(0, 0, 800, 50);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u6240\u5728\u697c\u5c42");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(125, 13), label2.getPreferredSize()));
            panel1.add(level);
            level.setBounds(185, 5, 275, 34);

            //---- label3 ----
            label3.setText("\u623f\u95f4\u7c7b\u578b");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(125, 53), label3.getPreferredSize()));
            panel1.add(type);
            type.setBounds(185, 45, 275, 34);

            //---- label4 ----
            label4.setText("\u623f\u95f4\u53f7\u7801");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(125, 98), label4.getPreferredSize()));
            panel1.add(roomnum);
            roomnum.setBounds(185, 90, 275, 34);

            //---- label5 ----
            label5.setText("\u623f\u95f4\u4ef7\u683c");
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(125, 143), label5.getPreferredSize()));
            panel1.add(price);
            price.setBounds(185, 135, 275, 34);

            //---- label6 ----
            label6.setText("\u623f\u95f4\u62bc\u91d1");
            label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(125, 188), label6.getPreferredSize()));
            panel1.add(deposit);
            deposit.setBounds(185, 180, 275, 34);

            //---- label7 ----
            label7.setText("\u623f\u95f4\u7535\u8bdd");
            label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label7);
            label7.setBounds(new Rectangle(new Point(125, 233), label7.getPreferredSize()));
            panel1.add(tel);
            tel.setBounds(185, 225, 275, 35);

            //---- label8 ----
            label8.setText("\u623f\u95f4\u72b6\u6001");
            label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label8);
            label8.setBounds(new Rectangle(new Point(125, 273), label8.getPreferredSize()));

            //---- s1 ----
            s1.setText("\u7a7a");
            panel1.add(s1);
            s1.setBounds(185, 270, 65, s1.getPreferredSize().height);

            //---- s2 ----
            s2.setText("\u6709\u5ba2");
            panel1.add(s2);
            s2.setBounds(285, 270, 65, 25);

            //---- s3 ----
            s3.setText("\u7a7a\u810f");
            panel1.add(s3);
            s3.setBounds(395, 270, 65, 25);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(remark);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(185, 305, 275, 60);

            //---- label9 ----
            label9.setText("\u5907\u6ce8");
            label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label9);
            label9.setBounds(125, 315, 30, label9.getPreferredSize().height);

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(185, 375), button1.getPreferredSize()));

            //---- button2 ----
            button2.setText("\u91cd\u7f6e");
            panel1.add(button2);
            button2.setBounds(new Rectangle(new Point(285, 375), button2.getPreferredSize()));

            //---- button3 ----
            button3.setText("\u8fd4\u56de");
            panel1.add(button3);
            button3.setBounds(new Rectangle(new Point(382, 375), button3.getPreferredSize()));
        }
        contentPane.add(panel1);
        panel1.setBounds(85, 60, 640, 435);

        //---- label10 ----
        label10.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label10);
        label10.setBounds(0, 0, label10.getPreferredSize().width, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JFormattedTextField level;
    private JLabel label3;
    private JComboBox type;
    private JLabel label4;
    private JTextField roomnum;
    private JLabel label5;
    private JFormattedTextField price;
    private JLabel label6;
    private JFormattedTextField deposit;
    private JLabel label7;
    private JTextField tel;
    private JLabel label8;
    private JRadioButton s1;
    private JRadioButton s2;
    private JRadioButton s3;
    private JScrollPane scrollPane1;
    private JTextArea remark;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label10;

    private RoomTypeService typeService;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
