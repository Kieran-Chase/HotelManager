/*
 * Created by JFormDesigner on Thu May 22 15:42:13 CST 2025
 */

package com.coder.hotel.ui.memberlevel;

import com.coder.hotel.entity.MemberLevel;
import com.coder.hotel.service.MemberLevelService;
import com.coder.hotel.util.StringUtil;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class MemberLevelAddUi extends JFrame {
    private MemberLevelAddUi() {
        initComponents();
    }
    private static final MemberLevelAddUi UI=new MemberLevelAddUi();
    public static MemberLevelAddUi getInstance(){
        return UI;
    }

    private void submit(ActionEvent e) {
        // TODO add your code here
        String level=levelVal.getText();
        if(StringUtil.isEmpty(level)){
            JOptionPane.showMessageDialog(this,"等级名称不能为空！");
            return;
        }
        String low =lowVal.getText();
        if(StringUtil.isEmpty(low)){
            JOptionPane.showMessageDialog(this,"低值不能为空！");
            return;
        }
        String high=highVal.getText();
        if(StringUtil.isEmpty(high)){
            JOptionPane.showMessageDialog(this,"高值不能为空！");
            return;
        }
        String discount=discountVal.getText();
        if(StringUtil.isEmpty(discount)){
            JOptionPane.showMessageDialog(this,"折扣不能为空！");
            return;
        }
        MemberLevel memberLevel=new MemberLevel();
        memberLevel.setLevel(level);
        memberLevel.setLow(Integer.valueOf(low));
        memberLevel.setHigh(Integer.valueOf(high));
        memberLevel.setDiscount(Double.valueOf(discount));
        MemberLevelService service=new MemberLevelService();
        int i=service.save(memberLevel);
        if(i>0){
            DefaultTableModel model= (DefaultTableModel) table.getModel();
            Object[][] objects=service.selectList();
            model.setDataVector(objects,new String[] {"id","会员等级","最低金额","最高金额","折扣"});
            JOptionPane.showMessageDialog(this,"保存成功！");
            goBack(e);
        }else{
            JOptionPane.showMessageDialog(this,"保存失败！");
        }

    }

    private void reset(ActionEvent e) {
        levelVal.setText("");
        lowVal.setText("");
        highVal.setText("");
        discountVal.setText("");
        // TODO add your code here
    }

    private void goBack(ActionEvent e) {
        // TODO add your code here
        reset(e);
        UiUtil.indent(UI,MemberLevelUi.getInstance());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        levelVal = new JTextField();
        lowVal = new JFormattedTextField();
        highVal = new JFormattedTextField();
        discountVal = new JFormattedTextField();
        okBtn = new JButton();
        resetBtn = new JButton();
        backBtn = new JButton();
        label10 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u4f1a\u5458\u7b49\u7ea7");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(0, 5, 800, 50);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("\u7b49\u7ea7\u540d\u79f0");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(50, 48), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u6d88\u8d39\u4f4e\u503c");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(50, 110), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u6d88\u8d39\u9ad8\u503c");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(50, 170), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u4eab\u53d7\u6298\u6263");
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(50, 235), label5.getPreferredSize()));
            panel1.add(levelVal);
            levelVal.setBounds(135, 40, 440, 38);
            panel1.add(lowVal);
            lowVal.setBounds(135, 102, 440, 38);
            panel1.add(highVal);
            highVal.setBounds(135, 162, 440, 38);
            panel1.add(discountVal);
            discountVal.setBounds(135, 227, 440, 38);

            //---- okBtn ----
            okBtn.setText("\u786e\u5b9a");
            okBtn.addActionListener(e -> submit(e));
            panel1.add(okBtn);
            okBtn.setBounds(new Rectangle(new Point(310, 285), okBtn.getPreferredSize()));

            //---- resetBtn ----
            resetBtn.setText("\u91cd\u7f6e");
            resetBtn.addActionListener(e -> reset(e));
            panel1.add(resetBtn);
            resetBtn.setBounds(new Rectangle(new Point(405, 285), resetBtn.getPreferredSize()));

            //---- backBtn ----
            backBtn.setText("\u8fd4\u56de");
            backBtn.addActionListener(e -> goBack(e));
            panel1.add(backBtn);
            backBtn.setBounds(new Rectangle(new Point(495, 285), backBtn.getPreferredSize()));
        }
        contentPane.add(panel1);
        panel1.setBounds(75, 85, 660, 355);

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
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField levelVal;
    private JFormattedTextField lowVal;
    private JFormattedTextField highVal;
    private JFormattedTextField discountVal;
    private JButton okBtn;
    private JButton resetBtn;
    private JButton backBtn;
    private JLabel label10;
    private JTable table;

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
