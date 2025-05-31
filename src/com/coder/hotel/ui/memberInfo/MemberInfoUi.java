/*
 * Created by JFormDesigner on Sun May 25 23:40:48 CST 2025
 */

package com.coder.hotel.ui.memberInfo;

import com.coder.hotel.entity.MemberInfo;
import com.coder.hotel.entity.MemberInfoQuery;
import com.coder.hotel.entity.MemberLevel;
import com.coder.hotel.entity.RoomInfo;
import com.coder.hotel.service.MemberInfoService;
import com.coder.hotel.service.MemberLevelService;
import com.coder.hotel.service.RoomInfoService;
import com.coder.hotel.ui.MainUi;
import com.coder.hotel.ui.roomInfo.RoomInfoUi;
import com.coder.hotel.util.Page;
import com.coder.hotel.util.StringUtil;
import com.coder.hotel.util.TableStyle;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class MemberInfoUi extends JFrame {
    private  MemberInfoUi() {
        initComponents();
    }
    private static final MemberInfoUi UI=new MemberInfoUi();
    public static MemberInfoUi getInstance(){
        return UI;
    }


    private void query(ActionEvent e) {
        info =new MemberInfoQuery();
        info.setName(nameVal.getText());
        info.setGender(genderVal.getSelectedItem().toString());
        String lowAgeText=lowAge.getText();
        info.setLowAge(Integer.valueOf(StringUtil.isEmpty(lowAgeText)?"0":lowAgeText));
        String highAgeText=highAge.getText();
        info.setHighAge(Integer.valueOf(StringUtil.isEmpty(highAgeText)?"0":highAgeText));
        info.setLevel(levelVal.getSelectedItem().toString());

        Page pageInfo=service.getPage(info,1);
        page(pageInfo,1,info);
        total.setText(pageInfo.getTotal().toString());
        pages.setText(pageInfo.getPages().toString());
    }

    private void clear(ActionEvent e) {
        init();
        table1.updateUI();
        nameVal.setText("");
        genderVal.setSelectedIndex(0);
        lowAge.setText("");
        highAge.setText("");
        levelVal.setSelectedIndex(0);
    }

    private void save(ActionEvent e) {
        // TODO add your code here
    }

    private void delete(ActionEvent e) {
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
                    service.deleteId(id);
                }
                //清除表格中的数据
                for(int i=selectedRows.length-1;i>=0;i--){
                    int x=table1.getSelectedRow();
                    model.removeRow(x);
                }
            }

        }
        //table1.updateUI();//刷新界面
        Page pageInfo=service.getPage(info,1);
        total.setText(pageInfo.getTotal().toString());
        pages.setText(pageInfo.getPages().toString());
        first(e);
    }

    private void update(ActionEvent e) {
        // TODO add your code here
    }
    private void page(Page pageInfo, int page, MemberInfoQuery info){
        data=service.selectExample(info,page);
        model.setDataVector(data,column);
        currentPage.setText(pageInfo.getPage().toString());
        table1.updateUI();
    }

    private void first(ActionEvent e) {
        Page pageInfo = service.getPage(info,1);
        page(pageInfo, 1, info);
    }

    private void previous(ActionEvent e) {
        Page pageInfo = service.getPage(info,1);
        String c = currentPage.getText();//获取当前页码
        if (!c.equals("1")) {
            pageInfo.setPage(Long.parseLong(c) - 1);
            long p = pageInfo.getPage();
            page(pageInfo, (int) p, info);
        }    }

    private void next(ActionEvent e) {
        Page pageInfo = service.getPage(info,1);
        //获取最后一页
        Long lastPage = pageInfo.getPages();
        String c = currentPage.getText();//获取当前页码
        Long currentPage = Long.parseLong(c);
        if (currentPage < lastPage) {
            pageInfo.setPage(currentPage + 1);
            long p = pageInfo.getPage();
            page(pageInfo, (int) p, info);
        }
    }

    private void last(ActionEvent e) {
        Page pageInfo = service.getPage(info,1);
        pageInfo.setPage(pageInfo.getPages());
        long p = pageInfo.getPage();
        page(pageInfo, (int) p, info);
    }

    private void back(ActionEvent e) {
        // TODO add your code here
        first(e);
        UiUtil.indent(UI,MainUi.getFrame());
    }

    class CustomModel extends DefaultTableModel {
        public CustomModel(Object [][] data,Object[]column){
            super(data,column);
        }
        //禁止jtable可编辑
        @Override
        public boolean isCellEditable(int row,int column){
            return false;
        }
    }

    private void init(){
        //初始化jtable数据
        column =new String[]{"id","姓名","身份证号","出生日期","年龄","性别","电话","等级id","等级"};
        service=new MemberInfoService();
        info=new MemberInfoQuery();
        info.setName("");
        info.setGender("请选择");
        info.setLowAge(0);
        info.setHighAge(0);
        info.setLevel("请选择");
        data=service.selectExample(info,1);
        /*for (Object[] datum : data) {
            for (Object o : datum) {
                System.out.print(o+",");
            }
            System.out.println();
        }*/
        model=new CustomModel(data,column);
        table1.setModel(model);
        TableStyle.setStyle(table1);

        //获取页码相关信息
        Page pageInfo=service.getPage(info,1);
        total.setText(pageInfo.getTotal().toString());
        //当前页
        currentPage.setText(pageInfo.getPage().toString());
        pages.setText(pageInfo.getPages().toString());

        table1.updateUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        nameVal = new JTextField();
        genderVal = new JComboBox(new String []{"请选择","男","女"});

        lowAge = new JFormattedTextField();
        highAge = new JFormattedTextField();
        label6 = new JLabel();
        //查询会员等级数据
        MemberLevelService levelService=new MemberLevelService();
        List<MemberLevel> list = levelService.getList();
        List<String> memberLevels = list.stream().map(MemberLevel::getLevel).collect(Collectors.toList());
        memberLevels.add(0,"请选择");
        Object[] objects = memberLevels.toArray();
        levelVal = new JComboBox(objects);
        queryBtn = new JButton();
        clearBtn = new JButton();
        toolBar1 = new JToolBar();
        saveBtn = new JButton();
        deleteBtn = new JButton();
        updateBtn = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label7 = new JLabel();
        total = new JLabel();
        label9 = new JLabel();
        currentPage = new JLabel();
        label11 = new JLabel();
        pages = new JLabel();
        firstBtn = new JButton();
        previousBtn = new JButton();
        nextBtn = new JButton();
        lastBtn = new JButton();
        backBtn = new JButton();
        label10 = new JLabel();

        init();

        //======== this ========
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf_\u4f1a\u5458\u4fe1\u606f");
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
            label2.setText("\u4f1a\u5458\u59d3\u540d");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(10, 40), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u4f1a\u5458\u6027\u522b");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(145, 40), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u4f1a\u5458\u5e74\u9f84");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(295, 40), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("\u4f1a\u5458\u7b49\u7ea7");
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(470, 40), label5.getPreferredSize()));
            panel1.add(nameVal);
            nameVal.setBounds(60, 31, 80, 39);
            panel1.add(genderVal);
            genderVal.setBounds(200, 30, 80, 39);
            panel1.add(lowAge);
            lowAge.setBounds(345, 30, 45, 39);
            panel1.add(highAge);
            highAge.setBounds(410, 30, 45, 39);

            //---- label6 ----
            label6.setText("\u2014");
            panel1.add(label6);
            label6.setBounds(395, 40, 20, label6.getPreferredSize().height);
            panel1.add(levelVal);
            levelVal.setBounds(520, 30, 80, 39);

            //---- queryBtn ----
            queryBtn.setText("\u67e5\u8be2");
            queryBtn.addActionListener(e -> query(e));
            panel1.add(queryBtn);
            queryBtn.setBounds(610, 30, 80, 39);

            //---- clearBtn ----
            clearBtn.setText("\u6e05\u7a7a");
            clearBtn.addActionListener(e -> clear(e));
            panel1.add(clearBtn);
            clearBtn.setBounds(695, 30, 80, 39);
        }
        contentPane.add(panel1);
        panel1.setBounds(5, 65, 780, 100);

        //======== toolBar1 ========
        {
            toolBar1.setFloatable(false);

            //---- saveBtn ----
            saveBtn.setText("\u65b0\u589e");
            saveBtn.addActionListener(e -> save(e));
            toolBar1.add(saveBtn);

            //---- deleteBtn ----
            deleteBtn.setText("\u5220\u9664");
            deleteBtn.addActionListener(e -> delete(e));
            toolBar1.add(deleteBtn);

            //---- updateBtn ----
            updateBtn.setText("\u4fee\u6539");
            updateBtn.addActionListener(e -> update(e));
            toolBar1.add(updateBtn);
        }
        contentPane.add(toolBar1);
        toolBar1.setBounds(new Rectangle(new Point(5, 175), toolBar1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 220, 780, 225);

        //---- label7 ----
        label7.setText("\u603b\u8bb0\u5f55\u6570");
        label7.setForeground(Color.white);
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(10, 465), label7.getPreferredSize()));

        //---- total ----
        total.setForeground(Color.white);
        //total.setText("10");
        contentPane.add(total);
        total.setBounds(65, 465, 30, total.getPreferredSize().height);

        //---- label9 ----
        label9.setText("\u5f53\u524d\u9875");
        label9.setForeground(Color.white);
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(95, 465), label9.getPreferredSize()));

        //---- currentPage ----
        currentPage.setForeground(Color.white);
        //currentPage.setText("1");
        contentPane.add(currentPage);
        currentPage.setBounds(140, 465, 30, currentPage.getPreferredSize().height);

        //---- label11 ----
        label11.setText("\u603b\u9875\u6570");
        label11.setForeground(Color.white);
        contentPane.add(label11);
        label11.setBounds(new Rectangle(new Point(170, 465), label11.getPreferredSize()));

        //---- pages ----
        pages.setForeground(Color.white);
        //pages.setText("1");
        contentPane.add(pages);
        pages.setBounds(215, 465, 30, pages.getPreferredSize().height);

        //---- firstBtn ----
        firstBtn.setText("\u9996\u9875");
        firstBtn.addActionListener(e -> first(e));
        contentPane.add(firstBtn);
        firstBtn.setBounds(390, 450, 80, 40);

        //---- previousBtn ----
        previousBtn.setText("\u4e0a\u4e00\u9875");
        previousBtn.addActionListener(e -> previous(e));
        contentPane.add(previousBtn);
        previousBtn.setBounds(470, 450, 80, 40);

        //---- nextBtn ----
        nextBtn.setText("\u4e0b\u4e00\u9875");
        nextBtn.addActionListener(e -> next(e));
        contentPane.add(nextBtn);
        nextBtn.setBounds(550, 450, 80, 40);

        //---- lastBtn ----
        lastBtn.setText("\u5c3e\u9875");
        lastBtn.addActionListener(e -> last(e));
        contentPane.add(lastBtn);
        lastBtn.setBounds(630, 450, 80, 40);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addActionListener(e -> back(e));
        contentPane.add(backBtn);
        backBtn.setBounds(710, 450, 80, 40);

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
    private JTextField nameVal;
    private JComboBox genderVal;
    private JFormattedTextField lowAge;
    private JFormattedTextField highAge;
    private JLabel label6;
    private JComboBox levelVal;
    private JButton queryBtn;
    private JButton clearBtn;
    private JToolBar toolBar1;
    private JButton saveBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label7;
    private JLabel total;
    private JLabel label9;
    private JLabel currentPage;
    private JLabel label11;
    private JLabel pages;
    private JButton firstBtn;
    private JButton previousBtn;
    private JButton nextBtn;
    private JButton lastBtn;
    private JButton backBtn;
    private JLabel label10;
    private String[] column;
    private MemberInfoService service;
    private Object[][] data;
    private MemberInfoQuery info;
    private CustomModel model;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
