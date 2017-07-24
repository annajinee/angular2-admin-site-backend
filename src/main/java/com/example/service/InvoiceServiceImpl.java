package com.example.service;

import com.example.dto.InvoiceDTO;
import com.example.model.Invoice;
import com.example.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gim-anna on 2017. 2. 14..
 */
@Service
@Transactional(readOnly=true)
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public Page<Invoice> findList(InvoiceDTO invoiceDTO, Pageable pageable) {

        String tiercode = invoiceDTO.getUsername();
        System.out.println("tiercode : " + tiercode);
        String regdate_from = "";
        String regdate_to = "";
        String comcode = invoiceDTO.getComcode();
        String level = invoiceDTO.getLevel();
        String invoice = invoiceDTO.getInvoice();
        String fid = invoiceDTO.getFid();


        // 검색 기간 설정
        if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null || invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {

            if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 00:00");
                regdate_from = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {

                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 23:59");
                    regdate_to = formatter2.format(calendar.getTime());
                } else {
                    regdate_to = invoiceDTO.getRegdate_to();
                }

            } else if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -2); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 23:59");
                regdate_to = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) {
                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 00:00");
                    regdate_from = formatter2.format(calendar.getTime());
                } else {
                    regdate_from = invoiceDTO.getRegdate_from();
                }
            }

        } else {
            regdate_from = invoiceDTO.getRegdate_from();
            regdate_to = invoiceDTO.getRegdate_to();
        }


        System.out.println("날짜" + regdate_from + "~" + regdate_to);

        Page<Invoice> invoicePage = null;
        System.out.println("페이지 : " + pageable.getPageNumber());

        invoicePage = invoiceRepository.findInvoiceComCodeFidLevelRegdateByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to, pageable);


        if (comcode == null && level == null && invoice == null && fid == null) {  // 전체조회

            invoicePage = invoiceRepository.findInvoiceComCodeFidLevelRegdateByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to, pageable);

        } else if (comcode == "" && level == "" && invoice == "" && fid == "") {  // 전체조회

            invoicePage = invoiceRepository.findInvoiceComCodeFidLevelRegdateByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to, pageable);

        } else {

            if (comcode != "") {    // comcode

                if (level == "" && invoice == "" && fid == "") {

                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, regdate_from, regdate_to, pageable);

                } else if (level != "" && invoice == "" && fid == "") {    // comcode & level

                    System.out.println("level" + level);
                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, regdate_from, regdate_to, pageable);

                } else if (level == "" && invoice != "" && fid == "") {    // comcode & invoice

                    System.out.println("invoice" + invoice);
                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, invoice, regdate_from, regdate_to, pageable);

                } else if (level == "" && invoice == "" && fid != "") {   // comcode & fid
                    System.out.println("fid" + fid);
                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, fid, regdate_from, regdate_to, pageable);

                } else if (level != "" && invoice != "" && fid == "") {    // comcode & level & invoice

                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, invoice, regdate_from, regdate_to, pageable);

                } else if (level != "" && invoice == "" && fid != "") {    // comcode & level & fid

                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, fid, regdate_from, regdate_to, pageable);

                } else if (level == "" && invoice != "" && fid != "") {    // comcode & invoice & fid

                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, invoice, fid, regdate_from, regdate_to, pageable);

                } else if (level != "" && invoice != "" && fid != "") {    // comcode & level & invoice & fid

                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndLevelAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, invoice, fid, regdate_from, regdate_to, pageable);
                }
            }

            if (level != "") {
                if (comcode == "" && invoice == "" && fid == "") {

                    invoicePage = invoiceRepository.findByTiercodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, level, regdate_from, regdate_to, pageable);

                } else if (comcode == "" && invoice != "" && fid == "") {    // level & invoice

                    invoicePage = invoiceRepository.findByTiercodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, level, invoice, regdate_from, regdate_to, pageable);

                } else if (comcode == "" && invoice == "" && fid != "") {   // level & fid

                    invoicePage = invoiceRepository.findByTiercodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, level, fid, regdate_from, regdate_to, pageable);

                }
            }

            if (invoice != "") {
                if (level == "" && comcode == "" && fid == "") {
                    invoicePage = invoiceRepository.findByTiercodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, invoice, regdate_from, regdate_to, pageable);
                } else if (comcode == "" && level == "" && fid != "") {   // invoice & fid

                    invoicePage = invoiceRepository.findByTiercodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, invoice, fid, regdate_from, regdate_to, pageable);

                }
            }

            if (fid != "") {
                if (level == "" && invoice == "" && comcode == "") {
                    invoicePage = invoiceRepository.findByTiercodeAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, fid, regdate_from, regdate_to, pageable);
                }
            }
        }

        return invoicePage;
    }


    // 미배송조회
    @Override
    public Page<Invoice> findNotDelivered(InvoiceDTO invoiceDTO, Pageable pageable) {

        String tiercode = invoiceDTO.getUsername(); // 로그인 한 사용자
        String regdate_from = "";
        String regdate_to = "";
        String comcode = invoiceDTO.getComcode();
        String level = invoiceDTO.getLevel();

        // 검색 기간 설정
        if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null || invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {

            if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우

                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 00:00");
                regdate_from = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {   // to 값이 없을 경우 : 현재일까지 (기간설정필요없음)

                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 23:59");
                    regdate_to = formatter2.format(calendar.getTime());

                } else {     // to 값이 있을 경우 (기간설정)

                    regdate_to = invoiceDTO.getRegdate_to();    // regdate_to = regdate_to
                }


            } else if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우

                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 23:59");
                regdate_to = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) {
                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 00:00");
                    regdate_from = formatter2.format(calendar.getTime());
                } else {
                    regdate_from = invoiceDTO.getRegdate_from();
                }
            }

        } else {

            regdate_from = invoiceDTO.getRegdate_from();
//            regdate_to = invoiceDTO.getRegdate_to();

            if (invoiceDTO.getPeriod() != null && invoiceDTO.getPeriod() != "") {   // 기간설정 값있을 경우

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                switch (invoiceDTO.getPeriod()) {
                    case "1":    // regdate_to = regdate_to + 1
                        try {
                            Date date = df.parse(invoiceDTO.getRegdate_to());
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, 1);
                            regdate_to = df.format(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("기간선택 등록일 +1일 : " + regdate_to);
                        break;
                    case "2":     // regdate_to = regdate_to + 2
                        try {
                            Date date = df.parse(invoiceDTO.getRegdate_to());
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, 2);
                            regdate_to = df.format(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("기간선택 등록일 +2일 : " + regdate_to);
                        break;
                    case "3":     // regdate_to = regdate_to + 3
                        try {
                            Date date = df.parse(invoiceDTO.getRegdate_to());
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, 3);
                            regdate_to = df.format(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("기간선택 등록일 +3일 : " + regdate_to);
                        break;
                    case "4":     // regdate_to = 24시간 전까지
                        Calendar calendar = new GregorianCalendar();
                        calendar.add(calendar.DATE, -1); // 하루전

                        SimpleDateFormat formatter
                                = new SimpleDateFormat("yyyy-MM-dd 23:59");
                        regdate_to = formatter.format(calendar.getTime());
                        System.out.println("기간선택 등록일 +4일이상 : " + regdate_to);
                        break;
                }
            } else {    // 기간 설정 값 없을 경우
                regdate_to = invoiceDTO.getRegdate_to();    // regdate_to = regdate_to
            }
        }

        System.out.println("날짜" + regdate_from + "~" + regdate_to);


        Page<Invoice> invoicePage = null;
        System.out.println("페이지 : " + pageable.getPageNumber());

        if (comcode == null && level == null) {  // 전체조회
            invoicePage = invoiceRepository.findByTiercodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(tiercode, "6", regdate_from, regdate_to, pageable);

        } else if (comcode == "" && level == "") {  // 전체조회
            invoicePage = invoiceRepository.findByTiercodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(tiercode, "6", regdate_from, regdate_to, pageable);

        } else {
            if (comcode != "") {    // comcode
                if (level == "") {
                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, "6", regdate_from, regdate_to, pageable);

                } else if (level != "") {    // comcode & level
                    invoicePage = invoiceRepository.findByTiercodeAndComcodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, regdate_from, regdate_to, pageable);

                }
            }

            if (level != "") {
                if (comcode == "") {

                    invoicePage = invoiceRepository.findByTiercodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, level, regdate_from, regdate_to, pageable);

                }
            }
        }

        return invoicePage;
    }

    @Override
    public List<Invoice> downloadDeliveredList(InvoiceDTO invoiceDTO) {

        String tiercode = invoiceDTO.getUsername();
        System.out.println("tiercode : " + tiercode);
        String regdate_from = "";
        String regdate_to = "";
        String comcode = invoiceDTO.getComcode();
        String level = invoiceDTO.getLevel();
        String invoice = invoiceDTO.getInvoice();
        String fid = invoiceDTO.getFid();

        System.out.println("tiercpde:" + tiercode + "comcode" + comcode + "level" + level + "invoice" + invoice + "fid" + fid);

        // 검색 기간 설정
        if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null || invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {

            if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 00:00");
                regdate_from = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {
                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 23:59");
                    regdate_to = formatter2.format(calendar.getTime());
                } else {
                    regdate_to = invoiceDTO.getRegdate_to();
                }

            } else if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 23:59");
                regdate_to = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) {
                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 00:00");
                    regdate_from = formatter2.format(calendar.getTime());
                } else {
                    regdate_from = invoiceDTO.getRegdate_from();
                }
            }

        } else {
            regdate_from = invoiceDTO.getRegdate_from();
            regdate_to = invoiceDTO.getRegdate_to();
        }


        System.out.println("날짜" + regdate_from + "~" + regdate_to);
        List<Invoice> invoiceList = null;

        if (comcode == null && level == null && invoice == null && fid == null) {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to);

        } else if (comcode == "" && level == "" && invoice == "" && fid == "") {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to);

        } else if (comcode == "" && level == "" && invoice == null && fid == null) {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to);

        } else if (comcode == "" && level == "" && invoice == null && fid == "") {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to);

        } else if (comcode == "" && level == "" && invoice == "" && fid == null) {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndRegdateBetweenOrderByRegdateDesc(tiercode, regdate_from, regdate_to);

        } else {

            if (comcode != "") {    // comcode

                if (level == "" && invoice == "" && fid == "") {
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, regdate_from, regdate_to);

                } else if (level != "" && invoice == "" && fid == "") {    // comcode & level
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, regdate_from, regdate_to);

                } else if (level == "" && invoice != "" && fid == "") {    // comcode & invoice
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, invoice, regdate_from, regdate_to);

                } else if (level == "" && invoice == "" && fid != "") {   // comcode & fid
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, fid, regdate_from, regdate_to);

                } else if (level != "" && invoice != "" && fid == "") {    // comcode & level & invoice
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, invoice, regdate_from, regdate_to);

                } else if (level != "" && invoice == "" && fid != "") {    // comcode & level & fid
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, fid, regdate_from, regdate_to);

                } else if (level == "" && invoice != "" && fid != "") {    // comcode & invoice & fid
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, invoice, fid, regdate_from, regdate_to);

                } else if (level != "" && invoice != "" && fid != "") {    // comcode & level & invoice & fid
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndLevelAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, invoice, fid, regdate_from, regdate_to);

                }
            }

            if (level != "") {
                if (comcode == "" && invoice == "" && fid == "") {
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, level, regdate_from, regdate_to);

                } else if (comcode == "" && invoice != "" && fid == "") {    // level & invoice
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, level, invoice, regdate_from, regdate_to);

                } else if (comcode == "" && invoice == "" && fid != "") {   // level & fid
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, level, fid, regdate_from, regdate_to);

                }
            }

            if (invoice != "") {
                if (level == "" && comcode == "" && fid == "") {
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(tiercode, invoice, regdate_from, regdate_to);

                } else if (comcode == "" && level == "" && fid != "") {   // invoice & fid
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, invoice, fid, regdate_from, regdate_to);

                }
            }

            if (fid != "") {
                if (level == "" && invoice == "" && comcode == "") {
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndFidAndRegdateBetweenOrderByRegdateDesc(tiercode, fid, regdate_from, regdate_to);
                }
            }
        }

        return invoiceList;
    }

    @Override
    public List<Invoice> downloadNotDeliveredList(InvoiceDTO invoiceDTO) {
        String tiercode = invoiceDTO.getUsername(); // 로그인 한 사용자
        String regdate_from = "";
        String regdate_to = "";
        String comcode = invoiceDTO.getComcode();
        String level = invoiceDTO.getLevel();


        // 검색 기간 설정
        if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null || invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {

            if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우

                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 00:00");
                regdate_from = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) {   // to 값이 없을 경우 : 현재일까지 (기간설정필요없음)

                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 23:59");
                    regdate_to = formatter2.format(calendar.getTime());

                } else {     // to 값이 있을 경우 (기간설정)

                    regdate_to = invoiceDTO.getRegdate_to();    // regdate_to = regdate_to
                }


            } else if (invoiceDTO.getRegdate_to() == "" || invoiceDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우

                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd 23:59");
                regdate_to = formatter.format(calendar.getTime());

                if (invoiceDTO.getRegdate_from() == "" || invoiceDTO.getRegdate_from() == null) {
                    SimpleDateFormat formatter2
                            = new SimpleDateFormat("yyyy-MM-dd 00:00");
                    regdate_from = formatter2.format(calendar.getTime());
                } else {
                    regdate_from = invoiceDTO.getRegdate_from();
                }
            }

        } else {

            regdate_from = invoiceDTO.getRegdate_from();
//            regdate_to = invoiceDTO.getRegdate_to();

            if (invoiceDTO.getPeriod() != null && invoiceDTO.getPeriod() != "") {   // 기간설정 값있을 경우

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                switch (invoiceDTO.getPeriod()) {
                    case "1":    // regdate_to = regdate_to + 1
                        try {
                            Date date = df.parse(invoiceDTO.getRegdate_to());
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, 1);
                            regdate_to = df.format(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("기간선택 등록일 +1일 : " + regdate_to);
                        break;
                    case "2":     // regdate_to = regdate_to + 2
                        try {
                            Date date = df.parse(invoiceDTO.getRegdate_to());
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, 2);
                            regdate_to = df.format(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("기간선택 등록일 +2일 : " + regdate_to);
                        break;
                    case "3":     // regdate_to = regdate_to + 3
                        try {
                            Date date = df.parse(invoiceDTO.getRegdate_to());
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(date);
                            cal.add(Calendar.DATE, 3);
                            regdate_to = df.format(cal.getTime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("기간선택 등록일 +3일 : " + regdate_to);
                        break;
                    case "4":     // regdate_to = 24시간 전까지
                        Calendar calendar = new GregorianCalendar();
                        calendar.add(calendar.DATE, -1); // 하루전

                        SimpleDateFormat formatter
                                = new SimpleDateFormat("yyyy-MM-dd 23:59");
                        regdate_to = formatter.format(calendar.getTime());
                        System.out.println("기간선택 등록일 +4일이상 : " + regdate_to);
                        break;
                }
            } else {    // 기간 설정 값 없을 경우
                regdate_to = invoiceDTO.getRegdate_to();    // regdate_to = regdate_to
            }
        }

        System.out.println("다운로드 날짜" + regdate_from + "~" + regdate_to);

        List<Invoice> invoiceList = null;

        if (comcode == null && level == null) {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(tiercode, "6", regdate_from, regdate_to);

        } else if (comcode == "" && level == "") {  // 전체조회
            invoiceList = invoiceRepository.findTop13000ByTiercodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(tiercode, "6", regdate_from, regdate_to);

        } else {
            if (comcode != "") {    // comcode
                if (level == "") {
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, "6", regdate_from, regdate_to);

                } else if (level != "") {    // comcode & level
                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndComcodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, comcode, level, regdate_from, regdate_to);

                }
            }

            if (level != "") {
                if (comcode == "") {

                    invoiceList = invoiceRepository.findTop13000ByTiercodeAndLevelAndRegdateBetweenOrderByRegdateDesc(tiercode, level, regdate_from, regdate_to);

                }
            }
        }

        return invoiceList;
    }

}
