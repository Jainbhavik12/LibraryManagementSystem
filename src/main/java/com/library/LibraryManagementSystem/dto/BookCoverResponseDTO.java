package com.library.LibraryManagementSystem.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCoverResponseDTO {

    private Long bookCoverId;

    private String fileName;

    private String fileType;

    private Long fileSize;

    private LocalDate uploadDate;

    private Long bookId;
}