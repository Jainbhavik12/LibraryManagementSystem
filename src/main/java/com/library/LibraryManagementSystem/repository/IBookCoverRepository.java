package com.library.LibraryManagementSystem.repository;

import com.library.LibraryManagementSystem.Entity.BookCover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCoverRepository extends JpaRepository<BookCover, Long> {
}
