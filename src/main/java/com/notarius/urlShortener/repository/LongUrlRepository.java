package com.notarius.urlShortener.repository;

import com.notarius.urlShortener.entity.LongUrl;
import com.notarius.urlShortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LongUrlRepository extends JpaRepository<LongUrl, Long> {
    public List<LongUrl> findLongUrlByUrl(String url);
    public List<LongUrl> findLongUrlByShortUrl(ShortUrl shortUrl);
}
