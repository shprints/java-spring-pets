package com.example.java.spring.pets.concurrency;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = "/api/concurrency")
@RequiredArgsConstructor
public class ConcurrencyController {
    private final ConcurrencyService service;

    @PostMapping(path = "/run")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void runThreads() {
        service.runThreads();
    }


}
