package com.test;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TestOutput {

    private LocalDateTime current;
    private LocalDate history;

}
