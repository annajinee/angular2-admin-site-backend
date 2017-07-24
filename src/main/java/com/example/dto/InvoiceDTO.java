package com.example.dto;


import java.io.Serializable;


public class InvoiceDTO implements Serializable {



    //페이징
    private int page;
    private int size;

    private String id;
    private String username; // 유저네임 :: ->tier_code
    private String regdate_from; //조회기간
    private String regdate_to; //조회기간
    private String comcode; // 배송사
    private String level;   // 배송상태
    private String invoice; // 운송장번호
    private String fid; // 주문번호
    private String period; // 미배송조회 - 기간설정
    private String name;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String comcode, String level, String invoice, String fid) {
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
    }

    public InvoiceDTO(String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid) {
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
    }

    public InvoiceDTO(String username, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid, String period, String name) {
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
        this.period = period;
        this.name = name;
    }

    public InvoiceDTO(String id, String username, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid, String period, String name) {
        this.id = id;
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
        this.period = period;
        this.name = name;
    }

    public InvoiceDTO(int page, int size, String id, String username, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid, String period, String name) {
        this.page = page;
        this.size = size;
        this.id = id;
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
        this.period = period;
        this.name = name;
    }

    public InvoiceDTO(int page, int size, String id, String username, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid, String period) {
        this.page = page;
        this.size = size;
        this.id = id;
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
        this.period = period;
    }

    public InvoiceDTO(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public InvoiceDTO(int page, int size, String id, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid) {
        this.page = page;
        this.size = size;
        this.id = id;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
    }

    public InvoiceDTO(int page, int size, String id, String username, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid) {
        this.page = page;
        this.size = size;
        this.id = id;
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public InvoiceDTO(String id) {
        this.id = id;
    }

    public InvoiceDTO(String id, String regdate_from, String regdate_to, String comcode, String level, String invoice, String fid) {
        this.id = id;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.level = level;
        this.invoice = invoice;
        this.fid = fid;
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

    public String getRegdate_from() {
        return regdate_from;
    }

    public void setRegdate_from(String regdate_from) {
        this.regdate_from = regdate_from;
    }

    public String getRegdate_to() {
        return regdate_to;
    }

    public void setRegdate_to(String regdate_to) {
        this.regdate_to = regdate_to;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
