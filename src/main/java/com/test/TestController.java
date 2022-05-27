package com.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/test")
    public TestOutput test() {

        TestOutput output = new TestOutput();
        output.setCurrent(LocalDateTime.now());
        output.setHistory(LocalDate.now());
        return output;

    }

}
