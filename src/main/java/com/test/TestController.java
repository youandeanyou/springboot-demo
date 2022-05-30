package com.test;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public TestOutput test() {

        TestOutput output = new TestOutput();
        output.setCurrent(LocalDateTime.now());
        output.setHistory(new Date());
        output.setYesterday(LocalDate.now());
        output.setTomorrow(new java.sql.Date(System.currentTimeMillis()));
        // 这里的打印，JSONField是生效的
        log.info("结果 - [output - {}]", JSON.toJSONString(output));
        // 这里直接返回，得到的结果是以FastJsonConfig.setDateFormat为准的
        return output;

    }

}
