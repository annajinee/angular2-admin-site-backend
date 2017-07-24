package com.example.service;//package com.example.service;

import com.example.model.InvoiceDetail;
import java.util.List;


/**
 * Created by gim-anna on 2017. 2. 14..
 */
public interface InvoiceDetailService {
    List<InvoiceDetail> findAll(String invoice_id); //조회 - 배송조회- 상세보기

}
