package com.example.service;

import com.example.dto.StaticDTO;
import com.example.model.InvoiceNotDelivered;
import com.example.model.InvoicePercent;
import com.example.model.InvoiceStatic;

import java.util.List;


/**
 * Created by gim-anna on 2017. 2. 14..
 */

public interface StaticService {

    List<InvoiceStatic> findStaticList(StaticDTO staticDTO);
    List<InvoiceNotDelivered> findNotDeliveredList(StaticDTO staticDTO);
    List<InvoicePercent> findDeliveredPercentList(StaticDTO staticDTO);
}
