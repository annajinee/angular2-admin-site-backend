package com.example.repository;

import com.example.model.Invoice;
import com.example.model.InvoiceStatic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gim-anna on 2017. 2. 14..
 * Invoice Table Repository
 * 조회 - 배송조회
 * 조회 - 미배송조회
 */
@Repository
public interface InvoiceStaticRepository extends JpaRepository<InvoiceStatic, Long> {

    List<InvoiceStatic> findByTiercodeAndRegdateBetween(String tier_code, String regdate_from, String regdate_to);

    List<InvoiceStatic> findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(String tier_code, String com_code, String regdate_from, String regdate_to);



}
