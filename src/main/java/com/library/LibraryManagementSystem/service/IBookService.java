package com.library.LibraryManagementSystem.service;


import com.library.LibraryManagementSystem.dto.BookRequestDto;
import com.library.LibraryManagementSystem.dto.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    public BookResponseDto saveBook(BookRequestDto bookRequestDTO);
    public BookResponseDto findBookById(Long id);
    public Page<BookResponseDto> findAllBooks(Pageable pageable);
    public BookResponseDto updateBook(Long id,BookRequestDto bookRequestDTO);
    public String deleteBookById(Long id);
}
