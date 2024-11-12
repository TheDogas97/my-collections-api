package pt.dddev.wardrobe_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.dddev.wardrobe_api.entity.Item;
import pt.dddev.wardrobe_api.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> removeItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(itemRepository::delete);
        return item;
    }
}