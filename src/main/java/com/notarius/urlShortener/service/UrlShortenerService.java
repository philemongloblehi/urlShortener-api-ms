package com.notarius.urlShortener.service;

import com.notarius.urlShortener.entity.LongUrl;
import com.notarius.urlShortener.entity.ShortUrl;
import com.notarius.urlShortener.exception.ResourceNotFoundException;
import com.notarius.urlShortener.repository.LongUrlRepository;
import com.notarius.urlShortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UrlShortenerService {
    private final LongUrlRepository longUrlRepository;
    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public UrlShortenerService(LongUrlRepository longUrlRepository, ShortUrlRepository shortUrlRepository) {
        this.longUrlRepository = longUrlRepository;
        this.shortUrlRepository = shortUrlRepository;
    }

    public String generateUrlShortener(LongUrl longUrl) {
        Optional<LongUrl> longUrlExist = this.longUrlRepository.findLongUrlByUrl(longUrl.getUrl());
        if (longUrlExist.isPresent()) {
            longUrl.setShortUrl(longUrl.getShortUrl());
            this.longUrlRepository.save(longUrl);

            return longUrl.getShortUrl().getUrl();
        }

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setUrl(this.generateShortUrl());
        ShortUrl shortUrlSaved = this.shortUrlRepository.save(shortUrl);

        longUrl.setShortUrl(shortUrlSaved);
        this.longUrlRepository.save(longUrl);

        return shortUrl.getUrl();
    }

    public String generateUrlCompletely(String urlShortener) {
        List<ShortUrl> shortUrls = this.shortUrlRepository.findShortUrlByUrl(urlShortener);
        if (shortUrls.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Url shortener with url %s not found!", urlShortener));
        }

        return shortUrls.get(0).getUrl();
    }

    private String generateShortUrl() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8);
    }
}
