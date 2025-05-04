/*
 * Created by JFormDesigner on Mon Apr 14 12:39:19 CST 2025
 */

package com.coder.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author bulang
 */
public class MainUi extends JFrame {
    public MainUi() {
        initComponents();
    }

    public static void main(String[] args) {
        MainUi mainUi=new MainUi();
        mainUi.setVisible(true);//设置可显示
    }

    //点击登录操作
    private void login(ActionEvent e) {
        System.out.println("hello,点击了按钮！");
    }

    //重置按钮操作
    private void doReset(ActionEvent e) {
        name.setText("");
        pwd.setText("");
    }

    private void nameFocusLost(FocusEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        label1 = new JLabel();
        name = new JTextField();
        label2 = new JLabel();
        pwd = new JPasswordField();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        menuItem2 = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7528\u6237\u7ba1\u7406");

                //---- menuItem1 ----
                menuItem1.setText("\u7528\u6237\u589e\u52a0");
                menu1.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("\u7528\u6237\u5220\u9664");
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setToolTipText("\u63d0\u793a");
        contentPane.add(label1);
        label1.setBounds(290, 35, 190, 45);

        //---- name ----
        name.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                nameFocusLost(e);
                nameFocusLost(e);
            }
        });
        contentPane.add(name);
        name.setBounds(280, 105, 255, 35);

        //---- label2 ----
        label2.setText("\u8d26\u53f7");
        contentPane.add(label2);
        label2.setBounds(245, 110, 50, 20);
        contentPane.add(pwd);
        pwd.setBounds(280, 145, 255, 35);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(245, 155, 40, 25);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(e -> login(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(295, 230), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> doReset(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(395, 230), button2.getPreferredSize()));

        //---- menuItem2 ----
        menuItem2.setText("text");
        contentPane.add(menuItem2);
        menuItem2.setBounds(new Rectangle(new Point(25, -25), menuItem2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(785, 660));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JLabel label1;
    private JTextField name;
    private JLabel label2;
    private JPasswordField pwd;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
