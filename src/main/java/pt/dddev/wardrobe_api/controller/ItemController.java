package pt.dddev.wardrobe_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping
public class ItemController {

    @GetMapping("/hello")
    public String getMethodName() {
        return "Hello from Item!";
    }

}