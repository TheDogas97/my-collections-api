package pt.dddev.wardrobe_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.dddev.wardrobe_api.entity.Item;
import pt.dddev.wardrobe_api.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/hello")
    public String getMethodName() {
        return "Hello from Item!";
    }

    @PostMapping("/add")
    public Item getMethodName(@RequestParam String name) {
        return itemService.addItem(name);
    }

}