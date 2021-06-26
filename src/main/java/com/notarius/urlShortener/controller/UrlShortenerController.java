package com.notarius.urlShortener.controller;

import com.notarius.urlShortener.entity.LongUrl;
import com.notarius.urlShortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/rest", name = "app_")
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping(path = "/url/shortener/generate", name = "generate_short_url")
    @ResponseStatus(HttpStatus.CREATED)
    public String urlShortenerGenerate(@RequestBody LongUrl longUrl) {
        return this.urlShortenerService.generateUrlShortener(longUrl);
    }

    @GetMapping(path = "/url/completely/restore", name = "restore_long_url")
    @ResponseStatus(HttpStatus.OK)
    public String urlCompletelyRestore(@RequestParam String urlShortener) {
        return this.urlShortenerService.generateUrlCompletely(urlShortener);
    }
}
