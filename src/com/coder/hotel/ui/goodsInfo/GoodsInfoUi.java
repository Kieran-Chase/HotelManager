/*
 * Created by JFormDesigner on Mon Jun 09 13:13:22 CST 2025
 */

package com.coder.hotel.ui.goodsInfo;

import com.coder.hotel.entity.GoodsInfo;
import com.coder.hotel.ui.MainUi;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author bulang
 */
public class GoodsInfoUi extends JFrame {
    private GoodsInfoUi() {
        initComponents();
    }
    private static final GoodsInfoUi UI=new GoodsInfoUi();
    public static GoodsInfoUi getInstance(){
        return UI;
    }

    private void goBack(ActionEvent e) {
        // TODO add your code here
        UiUtil.indent(UI, MainUi.getFrame());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        queryBtn = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        comboBox1 = new JComboBox();
        label6 = new JLabel();
        textField1 = new JTextField();
        button5 = new JButton();
        addBtn = new JButton();
        deleteBtn = new JButton();
        updateBtn = new JButton();
        label8 = new JLabel();
        total = new JLabel();
        label10 = new JLabel();
        page = new JLabel();
        label12 = new JLabel();
        pages = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        backBtn = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label7 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u5546\u54c1\u7ba1\u7406");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(10, 0, 800, 50);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u5546\u54c1\u7c7b\u578b");
            panel1.add(label2);
            label2.setBounds(15, 15, label2.getPreferredSize().width, 34);

            //---- queryBtn ----
            queryBtn.setText("\u67e5\u8be2");
            queryBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u8be2.png")));
            panel1.add(queryBtn);
            queryBtn.setBounds(575, 10, 80, 40);

            //---- label4 ----
            label4.setText("\u623f\u95f4\u7c7b\u578b");
            panel1.add(label4);
            label4.setBounds(0, 55, 48, 34);

            //---- label5 ----
            label5.setText("\u5546\u54c1\u540d\u79f0");
            panel1.add(label5);
            label5.setBounds(175, 15, 48, 34);

            //---- label3 ----
            label3.setText("\u5546\u54c1\u4ef7\u683c");
            panel1.add(label3);
            label3.setBounds(325, 15, 48, 34);
            panel1.add(textField2);
            textField2.setBounds(225, 10, 80, 40);
            panel1.add(textField3);
            textField3.setBounds(375, 10, 80, 40);
            panel1.add(comboBox1);
            comboBox1.setBounds(65, 10, 105, 40);

            //---- label6 ----
            label6.setText("\u2014\u2014");
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(460, 19), label6.getPreferredSize()));
            panel1.add(textField1);
            textField1.setBounds(490, 10, 80, 40);

            //---- button5 ----
            button5.setText("\u6e05\u7a7a");
            panel1.add(button5);
            button5.setBounds(660, 10, 80, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(25, 60, 750, 55);

        //---- addBtn ----
        addBtn.setText("\u65b0\u589e");
        addBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u65b0\u589e.png")));
        contentPane.add(addBtn);
        addBtn.setBounds(25, 115, 90, 50);

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664");
        deleteBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u5220 \u9664 .png")));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(115, 115, 85, 50);

        //---- updateBtn ----
        updateBtn.setText("\u4fee\u6539");
        updateBtn.setIcon(new ImageIcon(getClass().getResource("/img/\u4fee\u6539.png")));
        contentPane.add(updateBtn);
        updateBtn.setBounds(200, 115, 85, 50);

        //---- label8 ----
        label8.setText("\u603b\u8bb0\u5f55\uff1a");
        label8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label8.setForeground(Color.white);
        contentPane.add(label8);
        label8.setBounds(35, 430, 48, 17);

        //---- total ----
        total.setText("100");
        total.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        total.setForeground(Color.white);
        contentPane.add(total);
        total.setBounds(90, 430, 23, 17);

        //---- label10 ----
        label10.setText("\u5f53\u524d\u9875\uff1a");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label10.setForeground(Color.white);
        contentPane.add(label10);
        label10.setBounds(120, 430, 48, 17);

        //---- page ----
        page.setText("1");
        page.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        page.setForeground(Color.white);
        contentPane.add(page);
        page.setBounds(175, 430, 8, 17);

        //---- label12 ----
        label12.setText("\u603b\u9875\u6570\uff1a");
        label12.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        label12.setForeground(Color.white);
        contentPane.add(label12);
        label12.setBounds(195, 430, 48, 17);

        //---- pages ----
        pages.setText("20");
        pages.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        pages.setForeground(Color.white);
        contentPane.add(pages);
        pages.setBounds(250, 430, 15, 17);

        //---- button1 ----
        button1.setText("\u9996\u9875");
        contentPane.add(button1);
        button1.setBounds(330, 420, 90, 40);

        //---- button2 ----
        button2.setText("\u4e0a\u4e00\u9875");
        contentPane.add(button2);
        button2.setBounds(420, 420, 90, 40);

        //---- button3 ----
        button3.setText("\u4e0b\u4e00\u9875");
        contentPane.add(button3);
        button3.setBounds(510, 420, 90, 40);

        //---- button4 ----
        button4.setText("\u5c3e\u9875");
        contentPane.add(button4);
        button4.setBounds(600, 420, 90, 40);

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
        backBtn.setBounds(690, 420, 90, 40);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 165, 750, 245);

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label7);
        label7.setBounds(0, 0, label7.getPreferredSize().width, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JButton queryBtn;
    private JLabel label4;
    private JLabel label5;
    private JLabel label3;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JLabel label6;
    private JTextField textField1;
    private JButton button5;
    private JButton addBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JLabel label8;
    private JLabel total;
    private JLabel label10;
    private JLabel page;
    private JLabel label12;
    private JLabel pages;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton backBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
