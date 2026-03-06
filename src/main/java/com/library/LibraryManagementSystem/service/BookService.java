package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.Entity.Book;
import com.library.LibraryManagementSystem.Entity.BookCover;
import com.library.LibraryManagementSystem.dto.BookRequestDto;
import com.library.LibraryManagementSystem.dto.BookResponseDto;
import com.library.LibraryManagementSystem.exception.BookNotFoundException;
import com.library.LibraryManagementSystem.exception.FileStorageException;
import com.library.LibraryManagementSystem.repository.IBookCoverRepository;
import com.library.LibraryManagementSystem.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{
    private final  IBookRepository bookRepository;
    private final IBookCoverRepository bookCoverRepository;


    private final  ModelMapper modelMapper;





    @Override
    public BookResponseDto saveBook(BookRequestDto bookRequestDTO) {
        Book book = modelMapper.map(bookRequestDTO, Book.class);
        Book saved=bookRepository.save(book);

        return modelMapper.map(saved,BookResponseDto.class);
    }

    @Override
    public BookResponseDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        return modelMapper.map(book,BookResponseDto.class);
    }

    @Override
    public Page<BookResponseDto> findAllBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);

        return books.map(book -> modelMapper.map(book,BookResponseDto.class));
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookRequestDTO) {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        Book saved = modelMapper.map(bookRequestDTO,Book.class);

        return modelMapper.map(saved,BookResponseDto.class);
    }

    @Override
    public String deleteBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        bookRepository.delete(book);
        return "Book with id "+id+" has been deleted";
    }
}
