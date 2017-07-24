package com.example.repository;//package com.example.repository;


import com.example.model.InvoiceComcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceComcodeRepository extends JpaRepository<InvoiceComcode, Long>{

}
