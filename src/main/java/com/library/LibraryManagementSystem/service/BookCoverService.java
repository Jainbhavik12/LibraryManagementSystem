package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.Entity.Book;
import com.library.LibraryManagementSystem.Entity.BookCover;
import com.library.LibraryManagementSystem.dto.BookCoverResponseDTO;
import com.library.LibraryManagementSystem.exception.BookNotFoundException;
import com.library.LibraryManagementSystem.exception.FileStorageException;
import com.library.LibraryManagementSystem.repository.IBookCoverRepository;
import com.library.LibraryManagementSystem.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookCoverService implements IBookCoverService {

    private final IBookCoverRepository bookCoverRepository;
    private final IBookRepository bookRepository;
    private  final ModelMapper modelMapper;


    @Override
    public String uploadBookCover(Long id, MultipartFile file) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        try{
            BookCover cover =  new BookCover();
            cover.setFileName(file.getOriginalFilename());
            cover.setFileType(file.getContentType());
            cover.setFileSize(file.getSize());
            cover.setFileData(file.getBytes());
            cover.setBook(book);
            cover.setUploadDate(LocalDate.now());

            BookCover saved = bookCoverRepository.save(cover);
            return "Saved Successfully" ;
        }catch (IOException e){
            throw new FileStorageException("File not found");
        }
    }

    @Override
    public Resource getCover(Long book_id) {
        Book book = bookRepository.findById(book_id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        BookCover cover = book.getBookCover();

        if(cover == null){
            throw new FileStorageException("Cover not found");
        }

        Resource resource = new ByteArrayResource(cover.getFileData());



        return resource;
    }
}
