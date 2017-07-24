package com.example.controllers;

import com.example.dto.InvoiceDTO;
import com.example.dto.NoticeDTO;
import com.example.model.Notice;
import com.example.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by gim-anna on 2017. 2. 14..
 * 공지사항
 * model - Notice 사용
 */
@RestController
@RequestMapping("/api/notice")
public class NoticeController {


    @Autowired
    NoticeRepository noticeRepository;

    //     공지사항
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> getAllNotices(@RequestBody NoticeDTO noticeDTO) {

        int page = 0;
        if (noticeDTO.getPage() == 0) {
            page = 0;
        } else {
            page = noticeDTO.getPage() - 1;
        }

        PageRequest pageRequest = new PageRequest(page, 10, new Sort(Sort.Direction.ASC, "id"));

        return new ResponseEntity<>(noticeRepository.findByOrderByRegdateDesc(pageRequest), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticeById(@PathVariable int id) {
        Notice notice = noticeRepository.findById(id);
        return new ResponseEntity<>(notice, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addNewNotice(@RequestBody NoticeDTO noticeDTO) {

        String regdate = "";
        Calendar calendar = new GregorianCalendar();
        calendar.add(calendar.DATE, 0); // 당일
        SimpleDateFormat formatter
                = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        regdate = formatter.format(calendar.getTime());

        Notice notice = new Notice();
        notice.setTitle(noticeDTO.getTitle());
        notice.setContent(noticeDTO.getContent());
        notice.setRegdate(regdate);
        noticeRepository.save(notice);
        return new ResponseEntity<>(noticeDTO.getTitle(), HttpStatus.CREATED);
    }



    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> deleteNotice(@RequestBody NoticeDTO noticeDTO) {
        System.out.println("삭제 왓엄");
        Notice notice = noticeRepository.findById(noticeDTO.getId());
        noticeRepository.delete(notice);
        return new ResponseEntity<>(noticeDTO.getTitle(), HttpStatus.CREATED);
    }




}
