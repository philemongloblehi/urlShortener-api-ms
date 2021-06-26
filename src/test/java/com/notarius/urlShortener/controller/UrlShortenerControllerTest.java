package com.notarius.urlShortener.controller;

import com.notarius.urlShortener.repository.LongUrlRepository;
import com.notarius.urlShortener.repository.ShortUrlRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class UrlShortenerControllerTest {
    @Autowired
    private LongUrlRepository longUrlRepository;

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private MockMvc mvc;

    private static JSONObject json;

    @BeforeAll
    public void setUp() {
        longUrlRepository.deleteAll();
        shortUrlRepository.deleteAll();
        json = null;
    }

    @AfterAll
    public void tearDown() {
        longUrlRepository.deleteAll();
        shortUrlRepository.deleteAll();
        json = null;
    }

    @Test
    @Order(value = 0)
    public void testThatCanCreateUrlShortener() throws Exception {
        MvcResult result = this.mvc.perform(
                MockMvcRequestBuilders
                        .post("/api/v1/rest/url/shortener/generate")
                        .content("{"
                                + 	"\"url\": \"https://www.google.com\""
                                + "}"
                        )
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn()
                ;
    }

    @Test
    @Order(value = 1)
    public void testThatCanRestoreCompletelyUrl() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders
                        .get("/api/v1/rest/url/completely/restore/?urlShortener=shortUrl")
        )
                .andDo(print())
                .andExpect(status().isNotFound())
        ;
    }
}
