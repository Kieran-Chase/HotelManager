/*
 * Created by JFormDesigner on Sun Jun 08 22:14:37 CST 2025
 */

package com.coder.hotel.ui.goodstype;

import com.coder.hotel.entity.GoodsType;
import com.coder.hotel.service.GoodsTypeService;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class GoodsTypeAddUi extends JFrame {
    private GoodsTypeAddUi() {
        initComponents();
    }
    private static final GoodsTypeAddUi UI=new GoodsTypeAddUi();
    public static GoodsTypeAddUi getInstance(){
        return UI;
    }
    private void save(ActionEvent e) {
        String typeName=typeNameVal.getText();
        GoodsType goodsType=new GoodsType();
        goodsType.setTypeName(typeName);
        GoodsTypeService service=new GoodsTypeService();
        int i = service.save(goodsType);
        if (i>0){
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            //重新查询一下数据库
            Object[][] objects = service.selectList();
            model.setDataVector(objects,new String[]{"id", "商品类别"});
            table.updateUI();
            JOptionPane.showMessageDialog(this,"保存成功",
                    "提示消息",JOptionPane.INFORMATION_MESSAGE);
            goBack(e);
        }

    }
    private void reset(ActionEvent e) {
        typeNameVal.setText("");
    }
    private void goBack(ActionEvent e) {
        reset(e);
        UiUtil.indent(UI,GoodsTypeUi.getInstance());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        typeNameVal = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label10 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u5546\u54c1\u7c7b\u522b");
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
            label2.setText("\u7c7b\u522b\u540d\u79f0");
            panel1.add(label2);
            label2.setBounds(140, 100, 70, 40);
            panel1.add(typeNameVal);
            typeNameVal.setBounds(200, 100, 255, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(105, 110, 565, 235);

        //---- button3 ----
        button3.setText("\u786e\u5b9a");
        contentPane.add(button3);
        button3.setBounds(310, 365, 120, 50);
        button3.addActionListener(this::save);

        //---- button4 ----
        button4.setText("\u91cd\u7f6e");
        contentPane.add(button4);
        button4.setBounds(430, 365, 120, 50);
        button4.addActionListener(this::reset);


        //---- button5 ----
        button5.setText("\u8fd4\u56de");
        contentPane.add(button5);
        button5.setBounds(550, 365, 120, 50);
        button5.addActionListener(this::goBack);

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
    private JTextField typeNameVal;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label10;
    private JTable table;public JTable getTable() {
        return table;
    }public void setTable(JTable table) {
        this.table = table;
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
