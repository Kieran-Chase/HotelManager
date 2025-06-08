/*
 * Created by JFormDesigner on Sat Jun 07 17:10:31 CST 2025
 */

package com.coder.hotel.ui.goodstype;

import com.coder.hotel.entity.GoodsType;
import com.coder.hotel.service.GoodsTypeService;
import com.coder.hotel.ui.MainUi;
import com.coder.hotel.util.CustomModel;
import com.coder.hotel.util.TableStyle;
import com.coder.hotel.util.TableUtil;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class GoodsTypeUi extends JFrame {
    private GoodsTypeUi() {
        initComponents();
    }
    private static final GoodsTypeUi UI=new GoodsTypeUi();
    public static GoodsTypeUi getInstance(){
        return UI;
    }

    private void query(ActionEvent e) {
        // TODO add your code here
        String typeName=typeNameVal.getText();
        Object[][] objects = service.selectByType(typeName);
        model.setDataVector(objects,column);
        table1.updateUI();
        typeNameVal.setText("");
    }

    private void clear(ActionEvent e) {
        // TODO add your code here
        objects = service.selectList();
        model.setDataVector(objects,column);
        table1.updateUI();
    }

    private void save(ActionEvent e) {
        // TODO add your code here
        GoodsTypeAddUi addUi=GoodsTypeAddUi.getInstance();
        addUi.setTable(table1);
        UiUtil.indent(UI,addUi);
    }

    private void delete(ActionEvent e) {
        TableUtil.delete(table1,model,service);
    }

    private void update(ActionEvent e) {
        // TODO add your code here
        //用户选择的行数
        int rowCount = table1.getSelectedRowCount();
        if (rowCount==0){
            JOptionPane.showMessageDialog(table1, "请至少选择一行",
                    "提示信息", JOptionPane.WARNING_MESSAGE);
        }else if (rowCount>1){
            JOptionPane.showMessageDialog(table1, "只能修改一行数据",
                    "提示信息", JOptionPane.WARNING_MESSAGE);
        }else {
            int row = table1.getSelectedRow();
            Object id = table1.getValueAt(row, 0);
            GoodsTypeService service=new GoodsTypeService();
            GoodsType goodsType = service.selectId(id);
            GoodsTypeUpdateUi typeUpdateUi = GoodsTypeUpdateUi.getInstance();
            typeUpdateUi.setGoodsType(goodsType);
            typeUpdateUi.setTable(table1);
            UiUtil.indent(UI, typeUpdateUi);
        }

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
        typeNameVal = new JTextField();
        queryBtn = new JButton();
        clearBtn = new JButton();
        saveBtn = new JButton();
        deleteBtn = new JButton();
        updateBtn = new JButton();
        scrollPane1 = new JScrollPane();
        //获取表格数据
        column= new String []{"id","商品类别"};
        service=new GoodsTypeService();
        objects=service.selectList();
        model=new CustomModel(objects,column);

        table1 = new JTable(model);
        TableStyle.setStyle(table1);
        backBtn = new JButton();
        label10 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
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
            label2.setBounds(90, 25, 65, label2.getPreferredSize().height);
            panel1.add(typeNameVal);
            typeNameVal.setBounds(155, 13, 245, 40);

            //---- queryBtn ----
            queryBtn.setText("\u67e5\u8be2");
            queryBtn.addActionListener(e -> query(e));
            panel1.add(queryBtn);
            queryBtn.setBounds(420, 13, 100, 40);

            //---- clearBtn ----
            clearBtn.setText("\u6e05\u7a7a");
            clearBtn.addActionListener(e -> clear(e));
            panel1.add(clearBtn);
            clearBtn.setBounds(530, 13, 100, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(30, 60, 735, 60);

        //---- saveBtn ----
        saveBtn.setText("\u65b0\u589e");
        saveBtn.addActionListener(e -> save(e));
        contentPane.add(saveBtn);
        saveBtn.setBounds(30, 120, 80, 40);

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664");
        deleteBtn.addActionListener(e -> delete(e));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(110, 120, 80, 40);

        //---- updateBtn ----
        updateBtn.setText("\u4fee\u6539");
        updateBtn.addActionListener(e -> update(e));
        contentPane.add(updateBtn);
        updateBtn.setBounds(190, 120, 80, 40);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 160, 735, 270);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addActionListener(e -> goBack(e));
        contentPane.add(backBtn);
        backBtn.setBounds(680, 440, 80, 40);

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
    private JButton queryBtn;
    private JButton clearBtn;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton backBtn;
    private JLabel label10;
    private String[] column;
    private GoodsTypeService service;
    private Object[][] objects;
    private CustomModel model;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
