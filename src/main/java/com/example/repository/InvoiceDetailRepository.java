package com.example.repository;//package com.example.repository;

import com.example.model.Invoice;
import com.example.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gim-anna on 2017. 2. 14..
 * Invoice Table Repository
 * 조회 - 배송조회 - 상세보기
 * 조회 - 미배송조회 - 상세보기
 */
@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long>{

}
