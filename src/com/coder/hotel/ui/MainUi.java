/*
 * Created by JFormDesigner on Mon Apr 14 23:21:50 CST 2025
 */

package com.coder.hotel.ui;

import com.coder.hotel.ui.memberlevel.MemberLevelUi;
import com.coder.hotel.ui.roomInfo.RoomInfoUi;
import com.coder.hotel.ui.roomType.RoomTypeUi;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
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

    public static void main(String[] args) {
        UiUtil.indent(null,UI);
    }

    private void linkRoomTypeUi(ActionEvent e) {
        UiUtil.indent(UI, RoomTypeUi.getInstance());
    }

    private void goRoomInfo(ActionEvent e){
        UiUtil.indent(UI, RoomInfoUi.getInstance());
    }
    private void goMemberLevel(ActionEvent e){
        UiUtil.indent(UI, MemberLevelUi.getInstance());
    }


    private void initComponents() {
        setResizable(false);
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
        button1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button1.setText("\u623f\u578b\u7ba1\u7406");
        button1.setIcon(new ImageIcon(getClass().getResource("/img/\u7c7b\u578b (2).png")));
        button1.addActionListener(e -> linkRoomTypeUi(e));
        contentPane.add(button1);
        button1.setBounds(55, 230, 115, 115);

        //---- button2 ----
        button2.setText("\u623f\u95f4\u7ba1\u7406");
        button2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button2.setIcon(new ImageIcon(getClass().getResource("/img/\u623f\u95f4\u7ba1\u7406.png")));
        contentPane.add(button2);
        button2.setBounds(170, 230, 115, 115);
        button2.addActionListener(this::goRoomInfo);

        //---- button3 ----
        button3.setText("\u7528\u6237\u7ba1\u7406");
        button3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button3.setIcon(new ImageIcon(getClass().getResource("/img/\u7528\u6237\u7ba1\u7406.png")));
        contentPane.add(button3);
        button3.setBounds(630, 115, 115, 115);

        //---- button4 ----
        button4.setText("\u4f1a\u5458\u7b49\u7ea7");
        button4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button4.setIcon(new ImageIcon(getClass().getResource("/img/\u4f1a\u5458\u7b49\u7ea7.png")));
        contentPane.add(button4);
        button4.setBounds(285, 230, 115, 115);
        button4.addActionListener(this::goMemberLevel);

        //---- button5 ----
        button5.setText("\u4f1a\u5458\u4fe1\u606f");
        button5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button5.setIcon(new ImageIcon(getClass().getResource("/img/\u4f1a\u5458\u4fe1\u606f.png")));
        contentPane.add(button5);
        button5.setBounds(400, 230, 115, 115);

        //---- button6 ----
        button6.setText("\u8ba2\u623f\u7ba1\u7406");
        button6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button6.setIcon(new ImageIcon(getClass().getResource("/img/\u8ba2\u5355\u7ba1\u7406.png")));
        contentPane.add(button6);
        button6.setBounds(55, 115, 115, 115);

        //---- button7 ----
        button7.setText("\u623f\u95f4\u6253\u626b");
        button7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button7.setIcon(new ImageIcon(getClass().getResource("/img/\u623f\u95f4\u6253\u626b.png")));
        contentPane.add(button7);
        button7.setBounds(400, 115, 115, 115);

        //---- button8 ----
        button8.setText("\u5546\u54c1\u7ba1\u7406");
        button8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button8.setIcon(new ImageIcon(getClass().getResource("/img/\u5546\u54c1\u7ba1\u7406.png")));
        contentPane.add(button8);
        button8.setBounds(630, 230, 115, 115);

        //---- button9 ----
        button9.setText("\u5546\u54c1\u8ba2\u5355");
        button9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button9.setIcon(new ImageIcon(getClass().getResource("/img/\u5546\u54c1\u8ba2\u5355.png")));
        contentPane.add(button9);
        button9.setBounds(285, 115, 115, 115);

        //---- button10 ----
        button10.setText("\u9000\u623f\u7ba1\u7406");
        button10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button10.setIcon(new ImageIcon(getClass().getResource("/img/\u9000\u623f\u7ba1\u7406.png")));
        contentPane.add(button10);
        button10.setBounds(170, 115, 115, 115);

        //---- button11 ----
        button11.setText("\u8d22\u52a1\u7ba1\u7406");
        button11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button11.setIcon(new ImageIcon(getClass().getResource("/img/\u8d22\u52a1\u7ba1\u7406.png")));
        contentPane.add(button11);
        button11.setBounds(515, 115, 115, 115);

        //---- button12 ----
        button12.setText("\u4f4f\u5bbf\u7c7b\u578b");
        button12.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
        button12.setIcon(new ImageIcon(getClass().getResource("/img/\u5206\u671f\uff0d\u4f4f\u5bbf\u7c7b\u578b.png")));
        contentPane.add(button12);
        button12.setBounds(515, 230, 115, 115);

        //---- label2 ----
        label2.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
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
