package com.example.service;

import com.example.dto.InvoiceDTO;
import com.example.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created by gim-anna on 2017. 2. 14..
 */

public interface InvoiceService {

    Page<Invoice> findList(InvoiceDTO invoiceDTO, Pageable pageable);

    Page<Invoice> findNotDelivered(InvoiceDTO invoiceDTO, Pageable pageable); //조회 - 마배송조회

    List<Invoice> downloadDeliveredList(InvoiceDTO invoiceDTO);

    List<Invoice> downloadNotDeliveredList(InvoiceDTO invoiceDTO);

}
