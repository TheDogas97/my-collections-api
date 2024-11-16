package pt.dddev.wardrobe_api.controller;

import java.util.List;

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

import pt.dddev.wardrobe_api.dto.ItemDTO;
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
    public ResponseEntity<List<ItemDTO>> addItem(@RequestBody List<Item> items) {
        return items.isEmpty()
                ? ResponseEntity
                        .noContent()
                        .build()
                : ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(itemService.addItems(items));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> listItems() {
        List<ItemDTO> items = itemService
                .getItems();

        return items.isEmpty()
                ? ResponseEntity
                        .noContent()
                        .build()
                : ResponseEntity
                        .accepted()
                        .body(items);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        return itemService.removeItemById(id).isPresent()
                ? ResponseEntity
                        .ok()
                        .build()
                : ResponseEntity
                        .notFound()
                        .build();
    }
}