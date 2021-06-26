package com.notarius.urlShortener.repository;

import com.notarius.urlShortener.entity.LongUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LongUrlRepository extends JpaRepository<LongUrl, Long> {
    public Optional<LongUrl> findLongUrlByUrl(String url);
}
