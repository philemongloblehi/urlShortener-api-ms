package com.notarius.urlShortener.controller;

import com.notarius.urlShortener.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {
    private final ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }
}
