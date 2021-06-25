package com.notarius.urlShortener.entity;

import javax.persistence.*;

@Entity
@Table(name = "short_url")
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "short_url_id")
    private Long id;
    private String url;

    @ManyToOne
    @JoinColumn(name="long_url_id", nullable=false)
    private LongUrl longUrl;

    public ShortUrl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LongUrl getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(LongUrl longUrl) {
        this.longUrl = longUrl;
    }
}
