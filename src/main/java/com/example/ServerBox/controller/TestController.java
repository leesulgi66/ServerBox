package com.example.ServerBox.controller;

import com.example.ServerBox.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/around-hub")
    public String getTest1() {
        LOGGER.info("getTest1 호출!");

        return "Hello. Around Hub Studio!";
    }

    @GetMapping(value = "/name")
    public String getTest2(@RequestParam String name) {
        LOGGER.info("getTest2 호출!");
        return "Hello. "+name+"!";
    }

    @GetMapping(value = "/path-variable/{name}")
    public String getTest3(@PathVariable String name) {
        LOGGER.info("getTest3 호출!");
        return "Hello. "+name+"!";
    }

    @PostMapping(value = "/member")
    public ResponseEntity<MemberDTO> getMember(
            @RequestBody MemberDTO memberDTO,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ){

        LOGGER.info("getMember 호출!");

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("around-header") String header, @RequestBody MemberDTO memberDTO){

        LOGGER.info("add-header 호출!");
        LOGGER.info("header 값 : {}", header);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }
}
