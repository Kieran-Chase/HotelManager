/*
 * Created by JFormDesigner on Mon Apr 21 14:54:01 CST 2025
 */

package com.coder.hotel.ui;

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

    class CustomModel extends DefaultTableModel {
        public CustomModel(Object [][] data,Object[]column){
            super(data,column);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button9 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
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
        button6.setIcon(new ImageIcon(getClass().getResource("/img/\u65b0\u589e.png")));
        contentPane.add(button6);
        button6.setBounds(25, 130, 90, 50);

        //---- button7 ----
        button7.setText("\u5220\u9664");
        button7.setIcon(new ImageIcon(getClass().getResource("/img/\u5220 \u9664 .png")));
        contentPane.add(button7);
        button7.setBounds(115, 130, 85, 50);

        //---- button8 ----
        button8.setText("\u4fee\u6539");
        button8.setIcon(new ImageIcon(getClass().getResource("/img/\u4fee\u6539.png")));
        contentPane.add(button8);
        button8.setBounds(200, 130, 85, 50);

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
            button9.setIcon(new ImageIcon(getClass().getResource("/img/\u67e5\u8be2.png")));
            panel1.add(button9);
            button9.setBounds(410, 10, 80, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(25, 75, 750, 55);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 180, 750, 265);

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
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
