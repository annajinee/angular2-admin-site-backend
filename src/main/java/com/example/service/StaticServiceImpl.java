package com.example.service;
import com.example.dto.StaticDTO;
import com.example.model.InvoiceNotDelivered;
import com.example.model.InvoicePercent;
import com.example.model.InvoiceStatic;
import com.example.repository.InvoiceDelivereyPercentRepository;
import com.example.repository.InvoiceNotDeliveredRepository;
import com.example.repository.InvoiceStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gim-anna on 2017. 2. 14..
 */
@Service
@Transactional(readOnly=true)
public class StaticServiceImpl implements StaticService {

    private InvoiceStaticRepository invoiceStaticRepository;
    private InvoiceNotDeliveredRepository invoiceNotDeliveredRepository;
    private InvoiceDelivereyPercentRepository invoiceDelivereyPercentRepository;


    @Autowired
    public StaticServiceImpl(InvoiceStaticRepository invoiceStaticRepository, InvoiceNotDeliveredRepository invoiceNotDeliveredRepository, InvoiceDelivereyPercentRepository invoiceDelivereyPercentRepository) {
        this.invoiceStaticRepository = invoiceStaticRepository;
        this.invoiceNotDeliveredRepository = invoiceNotDeliveredRepository;
        this.invoiceDelivereyPercentRepository = invoiceDelivereyPercentRepository;
    }


    @Override
    public List<InvoiceStatic> findStaticList(StaticDTO staticDTO) {

        String tiercode = staticDTO.getUsername();
        String regdate_from="";
        String regdate_to="";
        String comcode = staticDTO.getComcode();

        System.out.println("tiercode : "+tiercode+" , comcode : "+comcode);

        // 검색 기간 설정
        if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null || staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) {

            if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd");
                regdate_from = formatter.format(calendar.getTime());

                if (staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) {
                    Calendar calendar2 = new GregorianCalendar();
                    calendar.add(calendar.DATE, -1); // 하루전
                    regdate_to = formatter.format(calendar2.getTime());
                } else {
                    regdate_to = staticDTO.getRegdate_to();
                }

            } else if (staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -1); // 하루전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd");
                regdate_to = formatter.format(calendar.getTime());

                if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null) {
                    Calendar calendar2 = new GregorianCalendar();
                    calendar.add(calendar.DATE, -1); // 하루전
                    regdate_from = formatter.format(calendar2.getTime());
                } else {
                    regdate_from = staticDTO.getRegdate_from();
                }
            }

        } else {
            regdate_from = staticDTO.getRegdate_from();
            regdate_to = staticDTO.getRegdate_to();
        }


        System.out.println("날짜" + regdate_from + "~" + regdate_to);

        List<InvoiceStatic> staticList  = null;


        if (comcode == null || comcode == "") {  // 전체조회

            comcode = "00";
            staticList = invoiceStaticRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(tiercode, comcode, regdate_from, regdate_to);

        } else {
            if (comcode != "") {    // comcode
                staticList = invoiceStaticRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(tiercode, comcode, regdate_from, regdate_to);
            }
        }

        return staticList;
    }


    // 미배송건수 조회
    @Override
    public List<InvoiceNotDelivered> findNotDeliveredList(StaticDTO staticDTO) {

        String tiercode = staticDTO.getUsername();
        String regdate_from="";
        String regdate_to="";
        String comcode = staticDTO.getComcode();

        System.out.println("tiercode : "+tiercode+" , comcode : "+comcode);

        // 검색 기간 설정
        if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null || staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) {

            if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -5);
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd");
                regdate_from = formatter.format(calendar.getTime());

                if (staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) {
                    Calendar calendar2 = new GregorianCalendar();
                    calendar2.add(calendar2.DATE, -4);
                    regdate_to = formatter.format(calendar2.getTime());
                } else {
                    regdate_to = staticDTO.getRegdate_to();
                }

            } else if (staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -4);
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd");
                regdate_to = formatter.format(calendar.getTime());

                if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null) {
                    Calendar calendar2 = new GregorianCalendar();
                    calendar2.add(calendar2.DATE, -5);
                    regdate_from = formatter.format(calendar2.getTime());
                } else {
                    regdate_from = staticDTO.getRegdate_from();
                }
            }

        } else {
            regdate_from = staticDTO.getRegdate_from();
            regdate_to = staticDTO.getRegdate_to();
        }


        System.out.println("날짜" + regdate_from + "~" + regdate_to);
        List<InvoiceNotDelivered> staticList  = null;


        if (comcode == null || comcode == "") {  // 전체조회

            comcode = "00";
            staticList = invoiceNotDeliveredRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(tiercode, comcode, regdate_from, regdate_to);

        } else {
            if (comcode != "") {    // comcode
                staticList = invoiceNotDeliveredRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(tiercode, comcode, regdate_from, regdate_to);
            }
        }
        return staticList;

    }

    // 배송율 통계
    @Override
    public List<InvoicePercent> findDeliveredPercentList(StaticDTO staticDTO) {

        String tiercode = staticDTO.getUsername();
        String regdate_from="";
        String regdate_to="";
        String comcode = staticDTO.getComcode();

        System.out.println("tiercode : "+tiercode+" , comcode : "+comcode);

        // 검색 기간 설정
        if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null || staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) {

            if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null) { //당일 기준 24시간 -from 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -8); // -2일의 일주일전
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd");
                regdate_from = formatter.format(calendar.getTime());

                if (staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) {
                    Calendar calendar2 = new GregorianCalendar();
                    calendar2.add(calendar2.DATE, -2);
                    regdate_to = formatter.format(calendar2.getTime());
                } else {
                    regdate_to = staticDTO.getRegdate_to();
                }

            } else if (staticDTO.getRegdate_to() == "" || staticDTO.getRegdate_to() == null) { //당일 기준 24시간 - to 값이 없을 경우
                Calendar calendar = new GregorianCalendar();
                calendar.add(calendar.DATE, -2);
                SimpleDateFormat formatter
                        = new SimpleDateFormat("yyyy-MM-dd");
                regdate_to = formatter.format(calendar.getTime());

                if (staticDTO.getRegdate_from() == "" || staticDTO.getRegdate_from() == null) {
                    Calendar calendar2 = new GregorianCalendar();
                    calendar2.add(calendar2.DATE, -8); // 하루전
                    regdate_from = formatter.format(calendar2.getTime());
                } else {
                    regdate_from = staticDTO.getRegdate_from();
                }
            }

        } else {
            regdate_from = staticDTO.getRegdate_from();
            regdate_to = staticDTO.getRegdate_to();
        }


        System.out.println("날짜" + regdate_from + "~" + regdate_to);
        List<InvoicePercent> staticList  = null;


        if (comcode == null || comcode == "") {  // 전체조회

            comcode = "00";
            staticList = invoiceDelivereyPercentRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(tiercode, comcode, regdate_from, regdate_to);

        } else {
            if (comcode != "") {    // comcode
                staticList = invoiceDelivereyPercentRepository.findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(tiercode, comcode, regdate_from, regdate_to);
            }
        }

        return staticList;
    }

}
