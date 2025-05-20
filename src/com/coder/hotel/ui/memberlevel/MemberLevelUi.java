/*
 * Created by JFormDesigner on Sun May 18 22:35:24 CST 2025
 */

package com.coder.hotel.ui.memberlevel;

import com.coder.hotel.entity.MemberLevel;
import com.coder.hotel.service.MemberLevelService;
import com.coder.hotel.service.RoomTypeService;
import com.coder.hotel.ui.MainUi;
import com.coder.hotel.util.StringUtil;
import com.coder.hotel.util.TableStyle;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class MemberLevelUi extends JFrame {
    private  MemberLevelUi() {
        initComponents();
    }
    private static MemberLevelUi UI=new MemberLevelUi();
    public static MemberLevelUi getInstance(){
        return UI;
    }
    class CustomModel extends DefaultTableModel{
        public CustomModel(Object[][]data,Object[] column){super(data,column);}
        //禁止jtable可编辑
        @Override
        public boolean isCellEditable(int row,int column){return false;}
    }

    private void query(ActionEvent e) {
        // TODO add your code here
        String level=levelVal.getText();
        String low= StringUtil.isEmpty(lowVal.getText())?"0":lowVal.getText();
        String high=StringUtil.isEmpty(highVal.getText())?"0":highVal.getText();
        MemberLevel memberLevel=new MemberLevel();
        memberLevel.setLevel(level);
        memberLevel.setLow(Integer.valueOf(low));
        memberLevel.setHigh(Integer.valueOf(high));
    }

    private void clear(ActionEvent e) {
        // TODO add your code here
    }

    private void add(ActionEvent e) {
        // TODO add your code here
    }

    private void update(ActionEvent e) {
        // TODO add your code here
    }

    private void delete(ActionEvent e) {
        // TODO add your code here
        //获取用户选择的表的行数
        int rowCount=table1.getSelectedRowCount();
        //判断用户是否选择了表格中的数据
        if(rowCount==0){
            JOptionPane.showMessageDialog(table1,"请至少选择一行");
        }else{
            int y=JOptionPane.showConfirmDialog(table1,"确定要删除数据吗？","提示信息",JOptionPane.YES_NO_OPTION);
            //y==0表示用户点击了确定
            if(y==0){
                int [] selectedRows=table1.getSelectedRows();
                //删除数据库表中的数据
                for (int selectedRow : selectedRows) {
                    Object id=model.getValueAt(selectedRow,0);
                    //按id查询房间，如果没有查到，就说明这个房型下面没有房间，可以直接删除
                    //否则不能删除，可以给用户一个提示
                    service.deleteId(id);
                }
                //清除表格中的数据
                for(int i=selectedRows.length-1;i>=0;i--){
                    int x=table1.getSelectedRow();
                    model.removeRow(x);
                }
            }

        }
        table1.updateUI();//刷新界面
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
        levelVal = new JTextField();
        label3 = new JLabel();
        lowVal = new JFormattedTextField();
        label4 = new JLabel();
        highVal = new JFormattedTextField();
        queryBtn = new JButton();
        clearBtn = new JButton();
        addBtn = new JButton();
        updateBtn = new JButton();
        deleteBtn = new JButton();
        scrollPane1 = new JScrollPane();

        column=new String[] {"id","会员等级","最低金额","最高金额","折扣"};
        service=new MemberLevelService();
        objects=service.selectList();
        model=new CustomModel(objects,column);

        table1 = new JTable(model);
        TableStyle.setStyle(table1);
        returnBtn = new JButton();
        label10 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u4f1a\u5458\u7b49\u7ea7");
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
            label2.setText("\u7b49\u7ea7\u540d\u79f0");
            panel1.add(label2);
            label2.setBounds(5, 10, 60, 30);
            panel1.add(levelVal);
            levelVal.setBounds(60, 10, 140, 30);

            //---- label3 ----
            label3.setText("\u4f4e\u503c");
            panel1.add(label3);
            label3.setBounds(205, 10, label3.getPreferredSize().width, 30);
            panel1.add(lowVal);
            lowVal.setBounds(235, 10, 140, 30);

            //---- label4 ----
            label4.setText("\u9ad8\u503c");
            panel1.add(label4);
            label4.setBounds(385, 10, label4.getPreferredSize().width, 30);
            panel1.add(highVal);
            highVal.setBounds(415, 10, 140, 30);

            //---- queryBtn ----
            queryBtn.setText("\u67e5\u9605");
            queryBtn.addActionListener(e -> query(e));
            panel1.add(queryBtn);
            queryBtn.setBounds(555, 5, 95, 40);

            //---- clearBtn ----
            clearBtn.setText("\u6e05\u7a7a");
            clearBtn.addActionListener(e -> clear(e));
            panel1.add(clearBtn);
            clearBtn.setBounds(650, 5, 95, 40);
        }
        contentPane.add(panel1);
        panel1.setBounds(25, 60, 750, 50);

        //---- addBtn ----
        addBtn.setText("\u65b0\u589e");
        addBtn.addActionListener(e -> add(e));
        contentPane.add(addBtn);
        addBtn.setBounds(25, 115, 105, 50);

        //---- updateBtn ----
        updateBtn.setText("\u4fee\u6539");
        updateBtn.addActionListener(e -> update(e));
        contentPane.add(updateBtn);
        updateBtn.setBounds(135, 115, 105, 50);

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664");
        deleteBtn.addActionListener(e -> delete(e));
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(245, 115, 105, 50);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 170, 750, 285);

        //---- returnBtn ----
        returnBtn.setText("\u8fd4\u56de");
        returnBtn.addActionListener(e -> goBack(e));
        contentPane.add(returnBtn);
        returnBtn.setBounds(680, 455, 95, 45);

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
    private JTextField levelVal;
    private JLabel label3;
    private JFormattedTextField lowVal;
    private JLabel label4;
    private JFormattedTextField highVal;
    private JButton queryBtn;
    private JButton clearBtn;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton returnBtn;
    private JLabel label10;
    private String[] column;
    private MemberLevelService service;
    private Object[][] objects;
    private CustomModel model;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
