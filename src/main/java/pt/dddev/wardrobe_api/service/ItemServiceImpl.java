package pt.dddev.wardrobe_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.dddev.wardrobe_api.entity.Item;
import pt.dddev.wardrobe_api.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item addItem(String name) {
        Item item = new Item(name);
        return itemRepository.save(item);
    }
}
