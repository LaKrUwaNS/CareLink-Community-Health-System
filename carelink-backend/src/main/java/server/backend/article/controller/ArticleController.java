package server.backend.article.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    // localhost:8080/api/articles/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello from ArticleController";
    }
}
