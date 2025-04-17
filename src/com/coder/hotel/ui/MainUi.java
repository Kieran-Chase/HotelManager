/*
 * Created by JFormDesigner on Mon Apr 14 23:21:50 CST 2025
 */

package com.coder.hotel.ui;

import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

/**
 * @author bulang
 */
public class MainUi extends JFrame {
    private MainUi() {

        initComponents();
    }
    private static final MainUi UI=new MainUi();
    public static JFrame getFrame(){
        return UI;
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u623f\u95f4\u7c7b\u578b\u7ba1\u7406");
        contentPane.add(button1);
        button1.setBounds(100, 115, 100, 100);

        //---- button2 ----
        button2.setText("\u623f\u95f4\u7ba1\u7406");
        contentPane.add(button2);
        button2.setBounds(195, 115, 100, 100);

        //---- button3 ----
        button3.setText("\u7528\u6237\u7ba1\u7406");
        contentPane.add(button3);
        button3.setBounds(290, 115, 100, 100);

        //---- button4 ----
        button4.setText("\u4f1a\u5458\u7b49\u7ea7");
        contentPane.add(button4);
        button4.setBounds(385, 115, 100, 100);

        //---- button5 ----
        button5.setText("\u4f1a\u5458\u4fe1\u606f");
        contentPane.add(button5);
        button5.setBounds(480, 115, 100, 100);

        //---- button6 ----
        button6.setText("\u8ba2\u5355\u7ba1\u7406");
        contentPane.add(button6);
        button6.setBounds(100, 285, 100, 100);

        //---- button7 ----
        button7.setText("\u623f\u95f4\u6253\u626b");
        contentPane.add(button7);
        button7.setBounds(195, 285, 100, 100);

        //---- button8 ----
        button8.setText("\u5546\u54c1\u7ba1\u7406");
        contentPane.add(button8);
        button8.setBounds(480, 285, 100, 100);

        //---- button9 ----
        button9.setText("\u5546\u54c1\u8ba2\u5355");
        contentPane.add(button9);
        button9.setBounds(575, 285, 100, 100);

        //---- button10 ----
        button10.setText("\u9000\u623f\u7ba1\u7406");
        contentPane.add(button10);
        button10.setBounds(575, 115, 100, 100);

        //---- button11 ----
        button11.setText("\u8d22\u52a1\u7ba1\u7406");
        contentPane.add(button11);
        button11.setBounds(385, 285, 100, 100);

        //---- button12 ----
        button12.setText("\u4f4f\u5bbf\u7c7b\u578b");
        contentPane.add(button12);
        button12.setBounds(290, 285, 100, 100);

        //---- label2 ----
        label2.setText("\u8bf7\u9009\u62e9\u83dc\u5355");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label2.setForeground(Color.white);
        contentPane.add(label2);
        label2.setBounds(255, 45, 265, 45);

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/img/bg.png")));
        contentPane.add(label3);
        label3.setBounds(0, 0, 800, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
