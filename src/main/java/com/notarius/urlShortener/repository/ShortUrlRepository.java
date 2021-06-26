package com.notarius.urlShortener.repository;

import com.notarius.urlShortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    public Optional<ShortUrl> findShortUrlByUrl(String url);
}
