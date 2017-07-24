package com.example.repository;

import com.example.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gim-anna on 2017. 2. 14..
 * Invoice Table Repository
 * 조회 - 배송조회
 * 조회 - 미배송조회
 */
@Repository

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

//    Page<Invoice> findAll(Pageable pageable);


    Page<Invoice> findInvoiceComCodeFidLevelRegdateByTiercodeAndRegdateBetweenOrderByRegdateDesc(String tier_code, String regdate_from, String regdate_to, Pageable pageable);

    // comcode
    Page<Invoice> findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & level
    Page<Invoice> findByTiercodeAndComcodeAndLevelAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & invoice
    Page<Invoice> findByTiercodeAndComcodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String invoice, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & fid
    Page<Invoice> findByTiercodeAndComcodeAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String fid, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & level & invoice
    Page<Invoice> findByTiercodeAndComcodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String invoice, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & level & fid
    Page<Invoice> findByTiercodeAndComcodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String fid, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & invoice & fid
    Page<Invoice> findByTiercodeAndComcodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String invoice, String fid, String regdate_from, String regdate_to, Pageable pageable);

    // comcode & level & invoice & fid
    Page<Invoice> findByTiercodeAndComcodeAndLevelAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String invoice, String fid, String regdate_from, String regdate_to, Pageable pageable);

    // level
    Page<Invoice> findByTiercodeAndLevelAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String regdate_from, String regdate_to, Pageable pageable);

    // level & invoice
    Page<Invoice> findByTiercodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String invoice, String regdate_from, String regdate_to, Pageable pageable);

    // level & fid
    Page<Invoice> findByTiercodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String fid, String regdate_from, String regdate_to, Pageable pageable);

    // invoice
    Page<Invoice> findByTiercodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String invoice, String regdate_from, String regdate_to, Pageable pageable);

    // invoice & fid
    Page<Invoice> findByTiercodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String invoice, String fid, String regdate_from, String regdate_to, Pageable pageable);

    // fid
    Page<Invoice> findByTiercodeAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String fid, String regdate_from, String regdate_to, Pageable pageable);


    // 다운로드 리스트
//    List<Invoice> findTop50ByTiercodeAndRegdateBetween(String tier_code, String regdate_from, String regdate_to);

    List<Invoice> findTop13000ByTiercodeAndRegdateBetweenOrderByRegdateDesc(String tier_code, String regdate_from, String regdate_to);

    // comcode
    List<Invoice> findTop13000ByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String regdate_from, String regdate_to);

    // comcode & level
    List<Invoice> findTop13000ByTiercodeAndComcodeAndLevelAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String regdate_from, String regdate_to);

    // comcode & invoice
    List<Invoice> findTop13000ByTiercodeAndComcodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String invoice, String regdate_from, String regdate_to);

    // comcode & fid
    List<Invoice> findTop13000ByTiercodeAndComcodeAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String fid, String regdate_from, String regdate_to);

    // comcode & level & invoice
    List<Invoice> findTop13000ByTiercodeAndComcodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String invoice, String regdate_from, String regdate_to);

    // comcode & level & fid
    List<Invoice> findTop13000ByTiercodeAndComcodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String fid, String regdate_from, String regdate_to);

    // comcode & invoice & fid
    List<Invoice> findTop13000ByTiercodeAndComcodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String invoice, String fid, String regdate_from, String regdate_to);

    // comcode & level & invoice & fid
    List<Invoice> findTop13000ByTiercodeAndComcodeAndLevelAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String invoice, String fid, String regdate_from, String regdate_to);

    // level
    List<Invoice> findTop13000ByTiercodeAndLevelAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String regdate_from, String regdate_to);

    // level & invoice
    List<Invoice> findTop13000ByTiercodeAndLevelAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String invoice, String regdate_from, String regdate_to);

    // level & fid
    List<Invoice> findTop13000ByTiercodeAndLevelAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String fid, String regdate_from, String regdate_to);

    // invoice
    List<Invoice> findTop13000ByTiercodeAndInvoiceAndRegdateBetweenOrderByRegdateDesc(String tier_code, String invoice, String regdate_from, String regdate_to);

    // invoice & fid
    List<Invoice> findTop13000ByTiercodeAndInvoiceAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String invoice, String fid, String regdate_from, String regdate_to);

    // fid
    List<Invoice> findTop13000ByTiercodeAndFidAndRegdateBetweenOrderByRegdateDesc(String tier_code, String fid, String regdate_from, String regdate_to);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //미배송조회
    Page<Invoice> findByTiercodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String regdate_from, String regdate_to, Pageable pageable);

    Page<Invoice> findByTiercodeAndLevelIsNotAndRegdateOrderByRegdateDesc(String tier_code, String level, String regdate_from, String regdate_to, Pageable pageable);


    // comcode
    Page<Invoice> findByTiercodeAndComcodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String regdate_from, String regdate_to, Pageable pageable);

    //미배송조회-다운로드
    List<Invoice> findTop13000ByTiercodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(String tier_code, String level, String regdate_from, String regdate_to);

    // comcode
    List<Invoice> findTop13000ByTiercodeAndComcodeAndLevelIsNotAndRegdateBetweenOrderByRegdateDesc(String tier_code, String com_code, String level, String regdate_from, String regdate_to);



}
