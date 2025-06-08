package com.coder.hotel.util;

import com.coder.hotel.service.BaseService;

import javax.swing.*;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/8
 */
public class TableUtil {
    public static void delete(JTable table1, CustomModel model, BaseService service){
        int rowCount = table1.getSelectedRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(table1, "请至少选择一行",
                    "提示信息", JOptionPane.WARNING_MESSAGE);
        } else {
            int y = JOptionPane.showConfirmDialog(table1, "确定要删除数据吗?", "提示信息",
                    JOptionPane.OK_CANCEL_OPTION);
            if (y == 0) {
                int[] selectedRows = table1.getSelectedRows();
                for (int selectedRow : selectedRows) {
                    Object id = model.getValueAt(selectedRow, 0);
                    service.deleteId(id);
                }
                for (int i = selectedRows.length; i > 0; i--) {
                    int x = table1.getSelectedRow();
                    model.removeRow(x);
                }
            }
        }
        table1.updateUI();//刷新界面
    }

}

