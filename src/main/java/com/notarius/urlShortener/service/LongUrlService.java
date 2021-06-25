package com.notarius.urlShortener.service;

import com.notarius.urlShortener.repository.LongUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LongUrlService {
    private final LongUrlRepository longUrlRepository;

    @Autowired
    public LongUrlService(LongUrlRepository longUrlRepository) {
        this.longUrlRepository = longUrlRepository;
    }
}
