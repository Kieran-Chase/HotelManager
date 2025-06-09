/*
 * Created by JFormDesigner on Mon Jun 09 18:07:01 CST 2025
 */

package com.coder.hotel.ui.goodsInfo;

import com.coder.hotel.entity.GoodsInfo;
import com.coder.hotel.entity.GoodsInfoQuery;
import com.coder.hotel.entity.GoodsType;
import com.coder.hotel.service.GoodsInfoService;
import com.coder.hotel.service.GoodsTypeService;
import com.coder.hotel.util.Page;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class GoodsInfoAddUi extends JFrame {
    private GoodsInfoAddUi() {
        initComponents();
    }
    private static final GoodsInfoAddUi UI=new GoodsInfoAddUi();
    public static GoodsInfoAddUi getInstance(){
        return UI;
    }

    private void submit(ActionEvent e) {
        // TODO add your code here
        String name=nameVal.getText();
        String type=typeVal.getSelectedItem().toString();
        String num=numVal.getText();
        String price=priceVal.getText();
        GoodsInfo info=new GoodsInfo();
        info.setName(name);
        info.setNum(Integer.valueOf(num));
        info.setPrice(Integer.valueOf(price));
        info.setType(type);
        GoodsTypeService typeService=new GoodsTypeService();
        Integer tid=typeService.getIdByType(type);
        info.setTid(tid);
        service=new GoodsInfoService();
        int i = service.save(info);
        if (i>0){
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            //重新查询一下数据库
            GoodsInfoQuery infoQuery=new GoodsInfoQuery();
            infoQuery.setName("");
            infoQuery.setType("请选择");
            infoQuery.setLowPrice(0);
            infoQuery.setHighPrice(0);
            Object[][] objects = service.selectExample(infoQuery,1);
            String[] column=new String[]{"id","品名","单价","数量","类别id","类别名称"};
            model.setDataVector(objects,column);

            Page pageInfo=service.getPage(infoQuery,1);
            total.setText(pageInfo.getTotal().toString());
            //当前页
            pages.setText(pageInfo.getPages().toString());
            table.updateUI();
            JOptionPane.showMessageDialog(this, "保存成功");
            goBack(e);
        }

    }

    private void reset(ActionEvent e) {
        // TODO add your code here
    }

    private void goBack(ActionEvent e) {
        // TODO add your code here
        UiUtil.indent(UI,GoodsInfoUi.getInstance());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label13 = new JLabel();
        nameVal = new JTextField();
        GoodsTypeService typeService=new GoodsTypeService();
        java.util.List<GoodsType> list = typeService.getList();
        List<String> types = list.stream().map(GoodsType::getTypeName).collect(Collectors.toList());
        types.add(0,"请选择");
        Object[] objects =types.toArray();
        typeVal = new JComboBox(objects);
        priceVal = new JTextField();
        numVal = new JTextField();
        okBtn = new JButton();
        resetBtn = new JButton();
        backBtn = new JButton();
        label1 = new JLabel();
        label15 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label8 ----
            label8.setText("\u5546\u54c1\u540d\u79f0");
            label8.setHorizontalAlignment(SwingConstants.RIGHT);
            label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label8);
            label8.setBounds(60, 30, 95, 35);

            //---- label9 ----
            label9.setText("\u5546\u54c1\u5355\u4ef7");
            label9.setHorizontalAlignment(SwingConstants.RIGHT);
            label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label9);
            label9.setBounds(60, 130, 95, 35);

            //---- label10 ----
            label10.setText("\u5546\u54c1\u6570\u91cf");
            label10.setHorizontalAlignment(SwingConstants.RIGHT);
            label10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label10);
            label10.setBounds(60, 180, 95, 35);

            //---- label13 ----
            label13.setText("\u5546\u54c1\u7c7b\u522b");
            label13.setHorizontalAlignment(SwingConstants.RIGHT);
            label13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label13);
            label13.setBounds(60, 80, 95, 35);
            panel1.add(nameVal);
            nameVal.setBounds(170, 27, 405, 40);
            panel1.add(typeVal);
            typeVal.setBounds(170, 77, 405, 40);
            panel1.add(priceVal);
            priceVal.setBounds(170, 127, 405, 40);
            panel1.add(numVal);
            numVal.setBounds(170, 177, 405, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(65, 105, 680, 270);

        //---- okBtn ----
        okBtn.setText("\u786e\u5b9a");
        okBtn.addActionListener(e -> submit(e));
        contentPane.add(okBtn);
        okBtn.setBounds(440, 405, 90, 40);

        //---- resetBtn ----
        resetBtn.setText("\u91cd\u7f6e");
        resetBtn.addActionListener(e -> reset(e));
        contentPane.add(resetBtn);
        resetBtn.setBounds(550, 405, 90, 40);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addActionListener(e -> goBack(e));
        contentPane.add(backBtn);
        backBtn.setBounds(655, 405, 90, 40);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u5546\u54c1\u4fe1\u606f");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(0, 0, 800, 50);

        //---- label15 ----
        label15.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label15);
        label15.setBounds(0, -5, label15.getPreferredSize().width, 500);

        contentPane.setPreferredSize(new Dimension(800, 525));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label13;
    private JTextField nameVal;
    private JComboBox typeVal;
    private JTextField priceVal;
    private JTextField numVal;
    private JButton okBtn;
    private JButton resetBtn;
    private JButton backBtn;
    private JLabel label1;
    private JLabel label15;
    private JTable table;
    private JLabel total;
    private JLabel pages;
    private GoodsInfoService service;

    public JTable getTable() {
    return table;
}public void setTable(JTable table) {
    this.table = table;
}public JLabel getTotal() {
    return total;
}public void setTotal(JLabel total) {
    this.total = total;
}public JLabel getPages() {
    return pages;
}public void setPages(JLabel pages) {
    this.pages = pages;
}

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
