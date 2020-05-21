package com.mashup.srinee.daylog.controller;


import com.mashup.srinee.daylog.dto.TestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/daylog")
@RestController
public class DayLogController {

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

}
