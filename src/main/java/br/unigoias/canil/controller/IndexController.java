package br.unigoias.canil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public RedirectView index() throws URISyntaxException {
        RedirectView redirectView = new RedirectView();

        String indexFile = "src/main/resources/public/index.html";

        File indexPage = new File(indexFile);

        if(indexPage.exists()) {
            redirectView.setUrl("index.html");
        } else {
            redirectView.setUrl("/health");
        }

        return redirectView;
    }

    @GetMapping("/health")
    public ResponseEntity<HashMap<String, String>> health() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "OK");
        status.put("version", "1.0");
        return ResponseEntity.ok(status);
    }
}
