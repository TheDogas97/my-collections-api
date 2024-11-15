package pt.dddev.wardrobe_api.service;

import java.util.List;
import java.util.Optional;

import pt.dddev.wardrobe_api.dto.ItemDTO;
import pt.dddev.wardrobe_api.entity.Item;

public interface ItemService {
    public List<ItemDTO> addItems(List<Item> items);

    public List<ItemDTO> getItems();

    public Optional<Item> getItemById(Long id);

    public Optional<Item> removeItemById(Long id);
}