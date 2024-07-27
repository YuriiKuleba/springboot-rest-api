package com.yk.spring.springboot.springboot_rest_api.controller;

import com.yk.spring.springboot.springboot_rest_api.SpringbootRestApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringbootRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveUserById() throws JSONException {

        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            createURLWithPort("/api/users/1"), HttpMethod.GET, httpEntity, String.class
        );
        String expected =  "[" +
            "{\"id\":1,\"username\":\"db1_user_1\",\"name\":\"Spring\",\"surname\":\"Bootko\"}," +
            "{\"id\":1,\"username\":\"db2_user_1\",\"name\":\"Aws\",\"surname\":\"Cloudko\"}" +
            "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
