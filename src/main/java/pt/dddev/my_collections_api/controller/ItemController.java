package pt.dddev.my_collections_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.dddev.my_collections_api.dto.ItemDTO;
import pt.dddev.my_collections_api.entity.Item;
import pt.dddev.my_collections_api.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("/hello")
	public String getHello() {
		return "Hello from Item!";
	}

	// C - CREATE
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

	// R - READ
	@GetMapping("/list")
	public ResponseEntity<List<ItemDTO>> listItems() {
		List<ItemDTO> items = itemService
				.getItems();

		return items.isEmpty()
				? ResponseEntity
						.noContent()
						.build()
				: ResponseEntity
						.ok(items);
	}

	// U - UPDATE
	@PostMapping("/edit")
	public ResponseEntity<ItemDTO> editItem(@PathVariable Long id, @RequestBody Item item) {
		Optional<ItemDTO> updatedItem = itemService.editItem(id, item);

		return updatedItem.isPresent()
				? ResponseEntity
						.ok(updatedItem.get())
				: ResponseEntity
						.notFound()
						.build();
	}

	// D - DELETE
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