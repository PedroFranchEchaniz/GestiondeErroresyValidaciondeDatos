package com.example.demo.controDeErrores.Dto;

import com.example.demo.controDeErrores.clase.BookMark;
import jakarta.validation.constraints.NotEmpty;

public record PostDtoBookMark(

        @NotEmpty
        String title,

        String url
) {

    public static PostDtoBookMark of (BookMark bookMark){
        return new PostDtoBookMark(
                bookMark.getTitle(),
                bookMark.getUrl()
        );
    }
}
