package com.example.controllers;

import com.example.dto.InvoiceDTO;
import com.example.dto.InvoiceDetailDTO;
import com.example.model.Invoice;
import com.example.model.InvoiceComcode;
import com.example.model.InvoiceDetail;
import com.example.repository.InvoiceComcodeRepository;
import com.example.repository.InvoiceDetailRepository;
import com.example.repository.InvoiceRepository;
import com.example.service.InvoiceDetailService;
import com.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gim-anna on 2017. 2. 14..
 * 조회 - 배송조회
 * 조회 - 미배송조회 관련
 * model - Invoice 사용
 */
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceDetailService invoiceDetailService;

    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceComcodeRepository invoiceComcodeRepository;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, InvoiceDetailService invoiceDetailService) {
        this.invoiceService = invoiceService;
        this.invoiceDetailService = invoiceDetailService;
    }

    //     배송조회
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> getAllInvoices(@RequestBody InvoiceDTO invoiceDTO) {

        int page=0;
        if (invoiceDTO.getPage() == 0) {
            page = 0;
        } else {
            page = invoiceDTO.getPage() - 1;
        }

        PageRequest pageRequest = new PageRequest(page, 10, new Sort(Sort.Direction.ASC, "id"));

        return new ResponseEntity<>(invoiceService.findList(invoiceDTO, pageRequest), HttpStatus.OK);
    }


    //     미배송조회
    @RequestMapping(value = "/notdelivered", method = RequestMethod.POST)
    public ResponseEntity<?> getNotDeliveredInvoices(@RequestBody InvoiceDTO invoiceDTO) {

        int page=0;
        if (invoiceDTO.getPage() == 0) {
            page = 0;
        } else {
            page = invoiceDTO.getPage() - 1;
        }

        PageRequest pageRequest = new PageRequest(page, 10, new Sort(Sort.Direction.ASC, "id"));

        return new ResponseEntity<>(invoiceService.findNotDelivered(invoiceDTO, pageRequest), HttpStatus.OK);
    }


    // 배송조회 상세보기
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseEntity<?> getDetailInvoices(@RequestBody InvoiceDetailDTO invoiceDetailDTO) {

        List<InvoiceDetail> detailList = invoiceDetailService.findAll(invoiceDetailDTO.getInvoice_id());
        return new ResponseEntity<>(detailList, HttpStatus.OK);
    }

    // 배송사 이름
    @RequestMapping(value = "/comcode", method = RequestMethod.POST)
    public ResponseEntity<?> getcomcodes() {

        List<InvoiceComcode> comcodeList = invoiceComcodeRepository.findAll();
        return new ResponseEntity<>(comcodeList, HttpStatus.OK);
    }


    // 엑셀 다운로드 - 배송조회
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<?> downloadDeliveredList(@RequestBody InvoiceDTO invoiceDTO) {

        List<Invoice> downloadList = invoiceService.downloadDeliveredList(invoiceDTO);
        return new ResponseEntity<>(downloadList, HttpStatus.OK);
    }

    // 엑셀 다운로드 - 미 배송조회
    @RequestMapping(value = "/download/notdelivered", method = RequestMethod.POST)
    public ResponseEntity<?> downloadNotDeliveredList(@RequestBody InvoiceDTO invoiceDTO) {

        List<Invoice> downloadList = invoiceService.downloadNotDeliveredList(invoiceDTO);
        return new ResponseEntity<>(downloadList, HttpStatus.OK);
    }

}
