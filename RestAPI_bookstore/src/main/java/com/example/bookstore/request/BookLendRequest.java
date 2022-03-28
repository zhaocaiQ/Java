package com.example.bookstore.request;

import java.util.List;

import lombok.Data;

@Data
public class BookLendRequest {
    private List<Long> bookIds;
    private Long memberId;
}