package com.sprintboot.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldControllerTest {

    @Autowired
    private RestTemplate template = new RestTemplate();

    @Test
    public void hello() {
        ResponseEntity<String> resp = template.exchange("localhost:8080/json", HttpMethod.GET, new HttpEntity<>(null), String.class);
        System.out.println("reso ===" + resp.getBody());
    }
}