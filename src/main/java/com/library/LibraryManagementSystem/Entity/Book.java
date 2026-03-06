package com.library.LibraryManagementSystem.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer publishedYear;
    private String category;
    private String description;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private BookCover bookCover;

}