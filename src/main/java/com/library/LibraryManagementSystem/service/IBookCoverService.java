package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.dto.BookCoverResponseDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IBookCoverService {
        public String uploadBookCover(Long id, MultipartFile file);
        public Resource getCover(Long id);

}
