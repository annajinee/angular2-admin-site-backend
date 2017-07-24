package com.example.model;


import javax.persistence.*;

/**
 * Created by gim-anna on 2017. 1. 16..
 * 운송장 Invoice 테이블 Model
 */
@Entity
@Table(name = "Notice")

public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id; // key값 자동증가, int(number(11)

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "REGDATE")
    private String regdate;


    public Notice() {
    }

    public Notice(String title, String content, String regdate) {
        this.title = title;
        this.content = content;
        this.regdate = regdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
