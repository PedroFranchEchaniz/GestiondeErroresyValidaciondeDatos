package com.example.demo.controDeErrores.Dto;

import com.example.demo.controDeErrores.clase.BookMark;

public record GetDtoBookMark(
    String title,

    String url
) {

    public static GetDtoBookMark of (BookMark bookMark){
        return new GetDtoBookMark(
                bookMark.getTitle(),
                bookMark.getUrl()
        );
    }
}
