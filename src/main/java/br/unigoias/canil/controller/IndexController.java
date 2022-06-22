package br.unigoias.canil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ResponseEntity<HashMap<String, String>> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "OK");
        status.put("version", "1.0");
        return ResponseEntity.ok(status);
    }
}
