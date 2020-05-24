package com.mashup.srinee.daylog.controller;


import com.mashup.srinee.daylog.dto.TestDTO;
import com.mashup.srinee.daylog.service.DayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Request 가 올 때마다 객체 생성은 너무 비효율적이다
// 그래서 딱 한번만 생성해서 전체적으로 같이 쓰자 하나로
// ==> Singleton
@RequestMapping(value = "/daylog")
@RestController
public class DayLogController {


//    @Autowired
//    private DayLogService dayLogService;

    private final DayLogService dayLogService;

    public DayLogController(DayLogService dayLogService) {
         this.dayLogService = dayLogService;
    }

    // URL :  Mapping http://localhost:8080/daylog/main
    // Return is Not Page, Just String value
    // Return Type Can be any Object (-> Converted to JSON)
    @GetMapping("/main")
    public TestDTO main() {
        TestDTO testDTO = new TestDTO();
        testDTO.setId("ysjleader");
        testDTO.setAddress("POHANG");
        testDTO.setPassword("12345");
        return testDTO;
    }

    // URL : http://localhost:8080/info/{username}
    // URL : http://localhost:8080/info/ysjleader/password/1234
    // username is parameter which is appended url
    @GetMapping("/info/{username}/password/{password}")
    public String info(@PathVariable("username") String username, @PathVariable("password") String password) {
        return "Hello your name is " + username + " and password is " + password;
    }

    // ex) URL : http://localhost:8080/url-query?username=ysjleader&password=1234
    // key = value type => username = ysjleader
    // username is query parameter
    @GetMapping("/url-query")
    public String urlQuery(TestDTO testDTO) {
        return "Hello your name is " + testDTO.getId() + " and password is " + testDTO.getPassword();
    }

    @PostMapping("/id")
    public TestDTO id(TestDTO testDTO) {
        return testDTO;
    }

    @PostMapping("/id-json")
    public TestDTO idJson(@RequestBody TestDTO testDTO) {
        return testDTO;
    }

    @GetMapping("/getDayLog")
    public String getDayLog() {
        return dayLogService.makeDayLog();
    }

}
