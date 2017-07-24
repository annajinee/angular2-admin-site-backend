package com.example.dto;

import java.io.Serializable;

/**
 * Created by annakim on 2017. 2. 23..
 */

public class InvoiceDetailDTO implements Serializable {

    private String id;
    private String username; // 유저네임 :: tiercode
    private String invoice_id;
    private String reg_date;
    private String state;
    private String time;
    private String place;
    private String phone_no;
    private String phone_no2;
    private String remark;
    private String level;
    private String sync_yn;
    private String sync_date;

    public InvoiceDetailDTO() {
    }

    public InvoiceDetailDTO(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public InvoiceDetailDTO(String id, String invoice_id, String reg_date, String state, String time, String place, String phone_no, String phone_no2, String remark, String level, String sync_yn, String sync_date) {
        this.id = id;
        this.invoice_id = invoice_id;
        this.reg_date = reg_date;
        this.state = state;
        this.time = time;
        this.place = place;
        this.phone_no = phone_no;
        this.phone_no2 = phone_no2;
        this.remark = remark;
        this.level = level;
        this.sync_yn = sync_yn;
        this.sync_date = sync_date;
    }

    public InvoiceDetailDTO(String id, String username, String invoice_id, String reg_date, String state, String time, String place, String phone_no, String phone_no2, String remark, String level, String sync_yn, String sync_date) {
        this.id = id;
        this.username = username;
        this.invoice_id = invoice_id;
        this.reg_date = reg_date;
        this.state = state;
        this.time = time;
        this.place = place;
        this.phone_no = phone_no;
        this.phone_no2 = phone_no2;
        this.remark = remark;
        this.level = level;
        this.sync_yn = sync_yn;
        this.sync_date = sync_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
