package com.example.demo.controDeErrores.Controller;


import com.example.demo.controDeErrores.Dto.GetDtoBookMark;
import com.example.demo.controDeErrores.Dto.PostDtoBookMark;
import com.example.demo.controDeErrores.clase.BookMark;
import com.example.demo.controDeErrores.service.BookMarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookMark")
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkService bookMarkService;

    @PostMapping("/")
    public ResponseEntity<PostDtoBookMark> newBookMark(@Valid @RequestBody PostDtoBookMark newBookMark) {
        BookMark bookMark = bookMarkService.save(newBookMark);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PostDtoBookMark.of(bookMark));
    }

    @GetMapping("/")
    public ResponseEntity<List<GetDtoBookMark>> getAll() {
        List<BookMark> bookMarkList = bookMarkService.findAll();
        if (bookMarkList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                bookMarkList.stream()
                        .map(GetDtoBookMark::of)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public GetDtoBookMark getBookMark(@PathVariable Long id){
        return GetDtoBookMark.of(bookMarkService.findByid(id));
    }
}
