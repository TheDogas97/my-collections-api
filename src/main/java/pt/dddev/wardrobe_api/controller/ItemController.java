package pt.dddev.wardrobe_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.dddev.wardrobe_api.entity.Item;
import pt.dddev.wardrobe_api.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello from Item!";
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.addItem(item));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemService.removeItemById(id).isPresent())
            return ResponseEntity
                    .noContent()
                    .build();
        return ResponseEntity
                .notFound()
                .build();
    }
}