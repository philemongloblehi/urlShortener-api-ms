package com.notarius.urlShortener.entity;

import javax.persistence.*;

@Entity
@Table(name = "long_url")
public class LongUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "long_url_id")
    private Long id;

    private String url;

    public LongUrl() {
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
}
