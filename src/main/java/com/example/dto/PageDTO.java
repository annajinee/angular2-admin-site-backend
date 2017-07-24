package com.example.dto;

import org.springframework.data.domain.Sort;

/**
 * Created by annakim on 2017. 4. 21..
 */

public class PageDTO {

    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;
    private int size;
    private int number;
    private Sort sort;
    private int numberOfElements;
}
