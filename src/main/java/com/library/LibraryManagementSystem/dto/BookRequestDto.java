package com.library.LibraryManagementSystem.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BookRequestDto {

    @NotBlank(message = "Title must not empty")
    private String title;

    private String author;

    @Pattern(regexp="^\\d{13}$")
    private String isbn;

    @Min(1)
    private Double price;

    private Integer publishedYear;
    private String category;
    private String description;

}