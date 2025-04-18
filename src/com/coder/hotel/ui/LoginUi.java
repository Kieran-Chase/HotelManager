/*
 * Created by JFormDesigner on Mon Apr 14 23:20:26 CST 2025
 */

package com.coder.hotel.ui;

import java.awt.event.*;

import com.coder.hotel.dao.AdminDao;
import com.coder.hotel.dao.impl.AdminDaoImpl;
import com.coder.hotel.entity.Admin;
import com.coder.hotel.util.StringUtil;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import javax.swing.*;

/**
 * @author bulang
 */
public class LoginUi extends JFrame {
    private LoginUi() {
        initComponents();
    }
    private static final LoginUi UI=new LoginUi();
    public static JFrame getFrame(){
        return UI;
    }

    public static void main(String[] args) {
       UiUtil.indent(null,UI);
    }

    //点击刷新验证码
    private void changeCode(MouseEvent e) {
        cv=StringUtil.getCode();
        codeLabel.setText(cv);
    }

    //登陆操作
    private void login(ActionEvent e) {
        String nameValue=name.getText();
        String pwdValue=new String(pwd.getPassword());
        String codeValue=code.getText();

        if(cv != null && cv.equals(codeValue)) {
            AdminDao dao=new AdminDaoImpl();
            Admin admin =dao.login(nameValue,pwdValue);
            if(admin!=null){
                UiUtil.indent(UI,MainUi.getFrame());
                /*JOptionPane.showMessageDialog(this,"登陆成功",
                        "系统提示",JOptionPane.ERROR_MESSAGE);*/
            }else{
                JOptionPane.showMessageDialog(this,"用户名或密码错误",
                        "系统提示",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this,"验证码错误",
                    "系统提示",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        name = new JTextField();
        pwd = new JPasswordField();
        code = new JTextField();
        codeLabel = new JTextField();
        button1 = new JButton();
        label8 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setForeground(Color.white);
        contentPane.add(label1);
        label1.setBounds(0, 0, 800, 75);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u8d26\u53f7");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label2);
            label2.setBounds(70, 50, 80, 20);

            //---- label3 ----
            label3.setText("\u5bc6\u7801");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label3);
            label3.setBounds(70, 100, 80, 20);

            //---- label4 ----
            label4.setText("\u9a8c\u8bc1\u7801");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            label4.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label4);
            label4.setBounds(70, 150, 80, 20);
            panel1.add(name);
            name.setBounds(160, 45, 265, 30);
            panel1.add(pwd);
            pwd.setBounds(160, 95, 265, 30);
            panel1.add(code);
            code.setBounds(160, 145, 185, 30);

            //---- codeLabel ----
            codeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            codeLabel.setFont(new Font("Segoe Print", Font.PLAIN, 16));
            codeLabel.setToolTipText("\u70b9\u51fb\u5237\u65b0");
            codeLabel.setText("1234");
            codeLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    changeCode(e);
                }
            });
            panel1.add(codeLabel);
            codeLabel.setBounds(355, 145, 70, 30);

            //---- button1 ----
            button1.setText("\u767b\u5f55");
            button1.setBackground(new Color(0x9999ff));
            button1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
            button1.setForeground(Color.white);
            button1.addActionListener(e -> login(e));
            panel1.add(button1);
            button1.setBounds(110, 195, 320, 40);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(155, 105, 500, 255);

        //---- label8 ----
        label8.setIcon(new ImageIcon(getClass().getResource("/img/bg.png")));
        contentPane.add(label8);
        label8.setBounds(0, 0, 800, 490);

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
    private JTextField name;
    private JPasswordField pwd;
    private JTextField code;
    private JTextField codeLabel;
    private JButton button1;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
