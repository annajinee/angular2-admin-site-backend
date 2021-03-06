package com.example.repository;

import com.example.model.InvoiceNotDelivered;
import com.example.model.InvoicePercent;
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
public interface InvoiceDelivereyPercentRepository extends JpaRepository<InvoicePercent, Long> {

    List<InvoicePercent> findByTiercodeAndComcodeAndRegdateBetweenOrderByRegdateAsc(String tier_code, String com_code, String regdate_from, String regdate_to);


}
