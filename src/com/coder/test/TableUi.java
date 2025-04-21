/*
 * Created by JFormDesigner on Sun Apr 20 22:32:40 CST 2025
 */

package com.coder.test;

import com.coder.hotel.util.UiUtil;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class TableUi extends JFrame {
    public TableUi() {
        initComponents();
    }

    public static void main(String[] args) {
        UiUtil.indent(null,new TableUi());
    }
    class CustomModel extends DefaultTableModel {
        public CustomModel(Object[][]date ,Object[]columnNames){
            super(date,columnNames);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(70, 80, 550, 235);

        contentPane.setPreferredSize(new Dimension(695, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
