package com.jongkeun.book_management.controller;

import com.jongkeun.book_management.model.Author;
import com.jongkeun.book_management.service.AuthorService;
import com.jongkeun.book_management.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DashboardController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/api/dashboard/authors")
    public Map<Author, Long> countByAuthor(){
        return authorService.getAll().stream()
                .collect(
                        // List 형태 작가 데이터 Map 형태로 변환
                        Collectors.toMap(
                                // 키 값 작가
                                author -> author,
                                // 작가의 책 갯수
                                author -> bookService.getAll().stream()
                                        .filter(book -> book.getAuthorId().equals(author.getId()))
                                        .count()
                        )
                );
    }
}
