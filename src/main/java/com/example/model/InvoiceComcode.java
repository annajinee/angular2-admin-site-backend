package com.example.model;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by gim-anna on 2017. 1. 16..
 * 운송장 Invoice 테이블 Model
 */
@Entity
@Table(name = "INVOICE_COMCODE")
public class InvoiceComcode {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    private int id; // key값 자동증가, int(number(11)

    @Id
    @Column(name = "COM_CODE")
    private String comcode;

    @Column(name = "NAME")
    private String name;

    public InvoiceComcode(String name) {
        this.name = name;
    }

    public InvoiceComcode(String com_code, String name) {
        this.comcode = com_code;
        this.name = name;

    }

    public InvoiceComcode() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getCom_code() {
        return comcode;
    }

    public void setCom_code(String com_code) {
        this.comcode = com_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

}
