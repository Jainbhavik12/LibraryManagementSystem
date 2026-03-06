package com.library.LibraryManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private Long fileSize;

    @Lob
    private byte[] fileData;

    private LocalDate uploadDate;

    @OneToOne
    @JoinColumn(name="book_id")
    private Book book;

}