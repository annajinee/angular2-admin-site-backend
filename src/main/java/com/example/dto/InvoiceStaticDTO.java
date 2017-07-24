package com.example.dto;

import com.example.model.InvoiceComcode;
import com.example.model.InvoiceStatic;

import javax.persistence.*;
import java.util.List;

/**
 * Created by annakim on 2017. 3. 5..
 */


public class InvoiceStaticDTO {

   private List<InvoiceStatic> invoiceStatics;
   private List<InvoiceComcode> invoiceComcodes;

    public InvoiceStaticDTO() {
    }

    public InvoiceStaticDTO(List<InvoiceStatic> invoiceStatics, List<InvoiceComcode> invoiceComcodes) {
        this.invoiceStatics = invoiceStatics;
        this.invoiceComcodes = invoiceComcodes;
    }

    public List<InvoiceStatic> getInvoiceStatics() {
        return invoiceStatics;
    }

    public void setInvoiceStatics(List<InvoiceStatic> invoiceStatics) {
        this.invoiceStatics = invoiceStatics;
    }

    public List<InvoiceComcode> getInvoiceComcodes() {
        return invoiceComcodes;
    }

    public void setInvoiceComcodes(List<InvoiceComcode> invoiceComcodes) {
        this.invoiceComcodes = invoiceComcodes;
    }
}
