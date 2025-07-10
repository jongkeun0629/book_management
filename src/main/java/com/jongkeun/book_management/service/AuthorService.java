package com.jongkeun.book_management.service;

import com.jongkeun.book_management.model.Author;
import com.jongkeun.book_management.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author create(Author author){
        return authorRepository.save(author);
    }
}
