package com.example.controllers;

import com.example.dto.StaticDTO;
import com.example.service.StaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gim-anna on 2017. 2. 14..
 * 통계 - 추적건수 통계, 배송율 통계, 미배송율 통계
 *
 * model - Invoice_static 사용
 */
@RestController
@RequestMapping("/api/static")
public class StaticController {

    private final StaticService staticService;


    @Autowired
    public StaticController(StaticService staticService) {
        this.staticService = staticService;
    }

    //    추적건수 통계
    @RequestMapping(value = "/tracking", method = RequestMethod.POST)
    public ResponseEntity getAllInvoices(@RequestBody StaticDTO staticDTO) {

        System.out.println("추적건수 통계");
        return new ResponseEntity(staticService.findStaticList(staticDTO), HttpStatus.OK);
    }


    //    배송율 통계
    @RequestMapping(value = "/delivered", method = RequestMethod.POST)
    public ResponseEntity<?> getNotDeliveredInvoices(@RequestBody StaticDTO staticDTO) {
        System.out.println("list :: "+staticService.findDeliveredPercentList(staticDTO));
        System.out.println("배송율 통계");
        return new ResponseEntity<>(staticService.findDeliveredPercentList(staticDTO), HttpStatus.OK);
    }


    // 미배송율 통계
    @RequestMapping(value = "/notdelivered", method = RequestMethod.POST)
    public ResponseEntity<?> getDetailInvoices(@RequestBody StaticDTO staticDTO) {

        System.out.println("미배송율 통계");
        return new ResponseEntity<>(staticService.findNotDeliveredList(staticDTO), HttpStatus.OK);
    }

}
