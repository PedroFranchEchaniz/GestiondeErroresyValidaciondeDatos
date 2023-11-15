package com.example.demo.controDeErrores.error;

public class BookmarKNotFoundexception extends RuntimeException{

    public BookmarKNotFoundexception(Long id){
        super("Bookmark with id:" +id+" not found");
    }
}
