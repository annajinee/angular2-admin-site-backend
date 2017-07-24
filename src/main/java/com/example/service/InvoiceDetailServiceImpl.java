package com.example.service;//package com.example.service;


import com.example.model.InvoiceDetail;
import com.example.repository.InvoiceDetailRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by gim-anna on 2017. 2. 14..
 */
@Service
@Transactional(readOnly=true)
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private InvoiceDetailRepository invoiceDetailRepository;


    @Autowired
    public InvoiceDetailServiceImpl(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }


    @PersistenceContext
    private EntityManager em;

    protected Session getCurrentSession() {
        return em.unwrap(Session.class);
    }

    @Override
    public List<InvoiceDetail> findAll(String invoice_id) { // 배송조회 - 상세보기



        Session session = getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("");
        String sqlQueryString = "select * from invoice_detail where INVOICE_ID =:INVOICE_ID";

        sqlQuery = session.createSQLQuery(sqlQueryString).addEntity(InvoiceDetail.class);
        sqlQuery.setString("INVOICE_ID", invoice_id);
        System.out.println("sql문 : " + sqlQueryString);
        List<InvoiceDetail> InvoiceDetail = (List<InvoiceDetail>) sqlQuery.list();
        return InvoiceDetail;
    }
}
