package com.rex.netty.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/echo")
    public ResponseEntity<String> echo(@RequestParam(value = "message", defaultValue = "") String msg) {
        if (msg.isEmpty()) {
            logger.info("REX API Server :: EMPTY MESSAGE");
            return ResponseEntity.ok("REX API Server :: EMPTY MESSAGE");
        }
        String response = "@RequestParam message :: " + msg;
        logger.info("REX API Server GetMapping :: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/echo")
    public ResponseEntity<String> echoPost(@RequestBody(required = false) String body) {
        if (body == null || body.isBlank()) {
            logger.info("REX API Server :: EMPTY BODY");
            return ResponseEntity.ok("REX API Server :: EMPTY BODY");
        }
        String response = "@RequestBody :: " + body;
        logger.info("REX API Server PostMapping :: {}", response);
        return ResponseEntity.ok(response);
    }
}
