package com.library.LibraryManagementSystem.dto;

import lombok.Data;

@Data
public class BookResponseDto {

    private Long book_id;
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer publishedYear;
    private String category;
    private String description;

}