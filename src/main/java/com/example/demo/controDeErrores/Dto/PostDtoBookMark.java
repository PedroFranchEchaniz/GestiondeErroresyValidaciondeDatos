package com.example.demo.controDeErrores.Dto;

import com.example.demo.controDeErrores.clase.BookMark;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record PostDtoBookMark(

        @NotEmpty(message = "{postDtoBookMark.title.notempty}")
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
