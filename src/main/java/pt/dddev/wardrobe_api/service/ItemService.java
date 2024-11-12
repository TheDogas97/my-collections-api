package pt.dddev.wardrobe_api.service;

import java.util.Optional;

import pt.dddev.wardrobe_api.entity.Item;

public interface ItemService {
    public Item addItem(Item item);

    public Optional<Item> removeItemById(Long id);
}