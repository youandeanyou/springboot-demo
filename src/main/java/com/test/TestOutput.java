package com.test;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TestOutput {

    private LocalDateTime current;
    @JSONField(format = "yyyy-MM-dd HH")
    private Date history;
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate yesterday;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private java.sql.Date tomorrow;

}
