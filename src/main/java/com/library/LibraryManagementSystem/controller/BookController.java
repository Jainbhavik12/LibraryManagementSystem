package com.library.LibraryManagementSystem.controller;


import com.library.LibraryManagementSystem.Entity.Book;
import com.library.LibraryManagementSystem.dto.BookRequestDto;

import com.library.LibraryManagementSystem.dto.BookResponseDto;
import com.library.LibraryManagementSystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private IBookService iBookService;

    @Autowired
    public void setiBookService(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @PostMapping("/regBook")
    public ResponseEntity<?> regBook(BookRequestDto bookRequestDTO) {
        BookResponseDto bookResponseDTO = iBookService.saveBook(bookRequestDTO);
        return new  ResponseEntity<>(bookResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        BookResponseDto bookResponseDTO = iBookService.findBookById(id);
        return new  ResponseEntity<>(bookResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> fetchAllBooks(Pageable pageable) {
        Page<BookResponseDto> books = iBookService.findAllBooks(pageable);
        return new  ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody BookRequestDto bookRequestDTO) {
        BookResponseDto responseDto = iBookService.updateBook(id, bookRequestDTO);
        return new  ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long id) {
        String status = iBookService.deleteBookById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


}
