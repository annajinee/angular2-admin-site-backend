package com.example.repository;//package com.example.repository;

import com.example.model.Invoice;
import com.example.model.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*공지사항
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>{

    Page<Notice> findAll(Pageable pageable);

    Page<Notice> findByOrderByRegdateDesc(Pageable pageable);

    Notice findById(int id);

}
