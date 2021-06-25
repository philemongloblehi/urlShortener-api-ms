package com.notarius.urlShortener.service;

import com.notarius.urlShortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }
}
