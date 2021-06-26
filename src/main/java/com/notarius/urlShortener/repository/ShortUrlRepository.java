package com.notarius.urlShortener.repository;

import com.notarius.urlShortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    public List<ShortUrl> findShortUrlByUrl(String url);
}
