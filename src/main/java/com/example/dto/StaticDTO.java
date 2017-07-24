package com.example.dto;

/**
 * Created by annakim on 2017. 3. 10..
 */
public class StaticDTO {

    private String username; //tier_code
    private String regdate_from; //조회기간
    private String regdate_to; //조회기간
    private String comcode; // 배송사
    private String diffpercent; //미배송율 (미배송건수/전체)

    public StaticDTO() {
    }

    public StaticDTO(String regdate_from, String regdate_to, String comcode) {
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
    }

    public StaticDTO(String username, String regdate_from, String regdate_to, String comcode) {
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
    }

    public StaticDTO(String username, String regdate_from, String regdate_to, String comcode, String diffpercent) {
        this.username = username;
        this.regdate_from = regdate_from;
        this.regdate_to = regdate_to;
        this.comcode = comcode;
        this.diffpercent = diffpercent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDiffpercent() {
        return diffpercent;
    }

    public void setDiffpercent(String diffpercent) {
        this.diffpercent = diffpercent;
    }
}
