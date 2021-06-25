package com.notarius.urlShortener.controller;

import com.notarius.urlShortener.service.LongUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongUrlController {
    private final LongUrlService longUrlService;

    @Autowired
    public LongUrlController(LongUrlService longUrlService) {
        this.longUrlService = longUrlService;
    }
}
