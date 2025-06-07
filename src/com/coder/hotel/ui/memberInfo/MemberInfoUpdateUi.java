/*
 * Created by JFormDesigner on Fri Jun 06 22:14:59 CST 2025
 */

package com.coder.hotel.ui.memberInfo;

import com.coder.hotel.entity.MemberInfo;
import com.coder.hotel.entity.MemberInfoQuery;
import com.coder.hotel.entity.MemberLevel;
import com.coder.hotel.entity.RoomType;
import com.coder.hotel.service.MemberInfoService;
import com.coder.hotel.service.MemberLevelService;
import com.coder.hotel.util.Page;
import com.coder.hotel.util.UiUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author bulang
 */
public class MemberInfoUpdateUi extends JFrame {
    private MemberInfoUpdateUi() {
        initComponents();
    }
    private static final MemberInfoUpdateUi UI=new MemberInfoUpdateUi();
    public static MemberInfoUpdateUi getInstance(){
        return UI;
    }

    private void idnumValFocusLost(FocusEvent e){
        // TODO add your code here
        String text = idnumVal.getText();
        String regx="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        boolean b = Pattern.matches(regx,text);
        if(!b){
            JOptionPane.showMessageDialog(this,"身份证录入错误");
            return;
        }
        //112233198010122564
        String dataVal=text.substring(6,14);
        LocalDate localDate=LocalDate.parse(dataVal, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Date date= Date.valueOf(localDate);
        birthVal.setText(date.toString());
        LocalDate now=LocalDate.now();
        long age= ChronoUnit.YEARS.between(localDate,now);
        ageVal.setText(String.valueOf(age));
        String c=text.charAt(16)+"";
        int i=Integer.parseInt(c);
        if(i%2==0){
            womanBtn.setSelected(true);
        }else{
            manBtn.setSelected(true);
        }
    }

    private void submit(ActionEvent e) {
        // TODO add your code here
        String name=nameVal.getText();
        String level=levelVal.getSelectedItem().toString();
        String idnum=idnumVal.getText();
        String tel=telVal.getText();
        String birth=birthVal.getText();
        String age=ageVal.getText();
        String gender;
        if(manBtn.isSelected()){
            gender="男";
        }else{
            gender="女";
        }
        memberInfo.setName(name);
        memberInfo.setIdnum(idnum);
        memberInfo.setBirth(Date.valueOf(birth));
        memberInfo.setAge(Integer.valueOf(age));
        memberInfo.setGender(gender);
        memberInfo.setTel(tel);
        //根据level查询到对应的id
        levelService =new MemberLevelService();
        Integer levelid=levelService.selectByLevel(level);
        memberInfo.setLevelid(levelid);
        memberInfo.setLevel(level);
        MemberInfoService service=new MemberInfoService();
        int i=service.update(memberInfo);
        if(i>0){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            //重新查询一下数据库
            MemberInfoQuery infoQuery=new MemberInfoQuery();
            infoQuery.setName("");
            infoQuery.setGender("请选择");
            infoQuery.setLowAge(0);
            infoQuery.setHighAge(0);
            infoQuery.setLevel("请选择");
            Object[][] objects=service.selectExample(infoQuery,1);
            String [] column =new String[]{"id","姓名","身份证号","出生日期","年龄","性别","电话","等级id","等级"};
            model.setDataVector(objects,column);
            table.updateUI();
            JOptionPane.showMessageDialog(this,"修改成功");
            goBack(e);
        }
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        init();
    }

    private void goBack(ActionEvent e) {
        // TODO add your code here
        UiUtil.indent(UI,MemberInfoUi.getInstance());
    }

    private void init(){
        //回显数据
        nameVal.setText(memberInfo.getName());
        idnumVal.setText(memberInfo.getIdnum());
        telVal.setText(memberInfo.getTel());
        birthVal.setText(memberInfo.getBirth().toString());
        ageVal.setText(memberInfo.getAge().toString());
        String gender=memberInfo.getGender();
        if(gender.equals("男")){
            manBtn.setSelected(true);
        }else{
            womanBtn.setSelected(true);
        }
        //回显会员等级
        levelVal.setSelectedItem(memberInfo.getLevel());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        panel1 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        nameVal = new JTextField();
        MemberLevelService levelService=new MemberLevelService();
        List<MemberLevel> list = levelService.getList();
        List<String> collect = list.stream().map(MemberLevel::getLevel).collect(Collectors.toList());
        collect.add(0,"---请选择---");
        levelVal = new JComboBox(collect.toArray());
        idnumVal = new JTextField();
        telVal = new JTextField();
        birthVal = new JTextField();
        ageVal = new JTextField();
        label14 = new JLabel();
        manBtn = new JRadioButton();
        womanBtn = new JRadioButton();
        group=new ButtonGroup();
        group.add(manBtn);
        group.add(womanBtn);
        okBtn = new JButton();
        resetBtn = new JButton();
        backBtn = new JButton();
        label15 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        setTitle("\u9152\u5e97\u7ba1\u7406\u7cfb\u7edf");
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

            //---- label8 ----
            label8.setText("\u4f1a\u5458\u59d3\u540d");
            label8.setHorizontalAlignment(SwingConstants.RIGHT);
            label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label8);
            label8.setBounds(60, 30, 95, 35);

            //---- label9 ----
            label9.setText("\u8eab\u4efd\u8bc1\u53f7");
            label9.setHorizontalAlignment(SwingConstants.RIGHT);
            label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label9);
            label9.setBounds(60, 130, 95, 35);

            //---- label10 ----
            label10.setText("\u8054\u7cfb\u7535\u8bdd");
            label10.setHorizontalAlignment(SwingConstants.RIGHT);
            label10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label10);
            label10.setBounds(60, 180, 95, 35);

            //---- label11 ----
            label11.setText("\u51fa\u751f\u65e5\u671f");
            label11.setHorizontalAlignment(SwingConstants.RIGHT);
            label11.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label11);
            label11.setBounds(60, 230, 95, 35);

            //---- label12 ----
            label12.setText("\u4f1a\u5458\u5e74\u9f84");
            label12.setHorizontalAlignment(SwingConstants.RIGHT);
            label12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label12);
            label12.setBounds(60, 280, 95, 35);

            //---- label13 ----
            label13.setText("\u4f1a\u5458\u7b49\u7ea7");
            label13.setHorizontalAlignment(SwingConstants.RIGHT);
            label13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label13);
            label13.setBounds(60, 80, 95, 35);
            panel1.add(nameVal);
            nameVal.setBounds(170, 27, 405, 40);
            panel1.add(levelVal);
            levelVal.setBounds(170, 77, 405, 40);
            panel1.add(idnumVal);
            idnumVal.setBounds(170, 127, 405, 40);
            idnumVal.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e){
                    idnumValFocusLost(e);
                }
            });
            panel1.add(telVal);
            telVal.setBounds(170, 177, 405, 40);

            //---- birthVal ----
            birthVal.setEditable(false);
            panel1.add(birthVal);
            birthVal.setBounds(170, 227, 405, 40);

            //---- ageVal ----
            ageVal.setEditable(false);
            panel1.add(ageVal);
            ageVal.setBounds(170, 277, 405, 40);

            //---- label14 ----
            label14.setText("\u4f1a\u5458\u6027\u522b");
            label14.setHorizontalAlignment(SwingConstants.RIGHT);
            label14.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            panel1.add(label14);
            label14.setBounds(60, 325, 95, 35);

            //---- manBtn ----
            manBtn.setText("\u7537");
            manBtn.setBackground(Color.white);
            manBtn.setEnabled(false);
            panel1.add(manBtn);
            manBtn.setBounds(new Rectangle(new Point(170, 330), manBtn.getPreferredSize()));

            //---- womanBtn ----
            womanBtn.setText("\u5973");
            womanBtn.setBackground(Color.white);
            womanBtn.setEnabled(false);
            panel1.add(womanBtn);
            womanBtn.setBounds(new Rectangle(new Point(245, 330), womanBtn.getPreferredSize()));
        }
        contentPane.add(panel1);
        panel1.setBounds(55, 60, 680, 370);

        //---- okBtn ----
        okBtn.setText("\u786e\u5b9a");
        okBtn.addActionListener(e -> submit(e));
        contentPane.add(okBtn);
        okBtn.setBounds(465, 450, 90, 40);

        //---- resetBtn ----
        resetBtn.setText("\u91cd\u7f6e");
        resetBtn.addActionListener(e -> reset(e));
        contentPane.add(resetBtn);
        resetBtn.setBounds(555, 450, 90, 40);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addActionListener(e -> goBack(e));
        contentPane.add(backBtn);
        backBtn.setBounds(645, 450, 90, 40);

        //---- label15 ----
        label15.setIcon(new ImageIcon(getClass().getResource("/img/bg.jpg")));
        contentPane.add(label15);
        label15.setBounds(0, 0, 800, 500);

        contentPane.setPreferredSize(new Dimension(800, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JPanel panel1;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JTextField nameVal;
    private JComboBox levelVal;
    private JTextField idnumVal;
    private JTextField telVal;
    private JTextField birthVal;
    private JTextField ageVal;
    private JLabel label14;
    private JRadioButton manBtn;
    private JRadioButton womanBtn;
    private JButton okBtn;
    private JButton resetBtn;
    private JButton backBtn;
    private JLabel label15;
    private MemberInfo memberInfo;
    private JTable table;
    private ButtonGroup group;
    private MemberLevelService levelService;

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }
    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
        init();
    }
    public JTable getTable() {
        return table;
    }
    public void setTable(JTable table) {
        this.table = table;
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
