package com.example.demo.controDeErrores.service;

import com.example.demo.controDeErrores.Dto.PostDtoBookMark;
import com.example.demo.controDeErrores.clase.BookMark;
import com.example.demo.controDeErrores.error.BookmarKNotFoundexception;
import com.example.demo.controDeErrores.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookMarkService {

private final BookMarkRepository bookMarkRepository;
    public BookMark save (PostDtoBookMark bookMark){
        BookMark newBookmark = new BookMark();
        newBookmark.setUrl(bookMark.url());
        newBookmark.setTitle(bookMark.title());
        return bookMarkRepository.save(newBookmark);
    }

    public List<BookMark> findAll(){
        return bookMarkRepository.findAll();
    }

    public BookMark findByid(Long id){
        return bookMarkRepository.findById(id).orElseThrow(() -> new BookmarKNotFoundexception(id));
    }

}
