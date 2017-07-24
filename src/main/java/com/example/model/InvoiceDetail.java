package com.example.model;


import javax.persistence.*;

/**
 * Created by gim-anna on 2017. 1. 16..
 * 운송장 Invoice 테이블 Model
 */
@Entity
@Table(name = "INVOICE_DETAIL")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // key값 자동증가, int(number(11)

    @Column(name = "INVOICE_ID")
    private String invoice_id;

    @Column(name = "REG_DATE")
    private String reg_date;

    @Column(name = "STATE")
    private String state;

    @Column(name = "TIME")
    private String time;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "PHONE_NO")
    private String phone_no;

    @Column(name = "PHONE_NO2")
    private String phone_no2;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "LEVEL")
    private String level;

    @Column(name = "MAN")
    private String man;

    @Column(name = "MAN_PIC")
    private String man_pic;

    @Column(name = "SYNC_YN")
    private String sync_yn;

    @Column(name = "SYNC_DATE")
    private String sync_date;

    public InvoiceDetail() {
    }

    public InvoiceDetail(String invoice_id, String reg_date, String state, String time, String place, String phone_no, String phone_no2, String remark, String level, String man, String man_pic, String sync_yn, String sync_date) {
        this.invoice_id = invoice_id;
        this.reg_date = reg_date;
        this.state = state;
        this.time = time;
        this.place = place;
        this.phone_no = phone_no;
        this.phone_no2 = phone_no2;
        this.remark = remark;
        this.level = level;
        this.man = man;
        this.man_pic = man_pic;
        this.sync_yn = sync_yn;
        this.sync_date = sync_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPhone_no2() {
        return phone_no2;
    }

    public void setPhone_no2(String phone_no2) {
        this.phone_no2 = phone_no2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getMan_pic() {
        return man_pic;
    }

    public void setMan_pic(String man_pic) {
        this.man_pic = man_pic;
    }

    public String getSync_yn() {
        return sync_yn;
    }

    public void setSync_yn(String sync_yn) {
        this.sync_yn = sync_yn;
    }

    public String getSync_date() {
        return sync_date;
    }

    public void setSync_date(String sync_date) {
        this.sync_date = sync_date;
    }
}
