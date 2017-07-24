package com.example.dto;

import java.io.Serializable;

public class NoticeDTO implements Serializable {

    private String title;
    private String content;

    //페이징
    private int page;
    private int size;

    private int id;


    public NoticeDTO() {
    }

    public NoticeDTO(int page, int size, int id) {
        this.page = page;
        this.size = size;
        this.id = id;
    }

    public NoticeDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoticeDTO(String title, String content, int page, int size, int id) {
        this.title = title;
        this.content = content;
        this.page = page;
        this.size = size;
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

    public NoticeDTO(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
