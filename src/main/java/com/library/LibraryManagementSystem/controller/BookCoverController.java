package com.library.LibraryManagementSystem.controller;

import com.library.LibraryManagementSystem.dto.BookCoverResponseDTO;
import com.library.LibraryManagementSystem.dto.BookResponseDto;
import com.library.LibraryManagementSystem.service.BookCoverService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@RestController
@RequestMapping("/bookcovers")
@RequiredArgsConstructor
public class BookCoverController {

    private final BookCoverService bookCoverService;

    @PostMapping("/uploadBookCover/{id}")
    public ResponseEntity<?> addBookCover(@PathVariable Long id,@RequestParam("file") MultipartFile file) {
        String dto = bookCoverService.uploadBookCover(id, file);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("getBookCover/{id}")
    public ResponseEntity<?> getBookCover(@PathVariable Long id) {
        Resource resource = bookCoverService.getCover(id);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }




}