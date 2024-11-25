package pt.dddev.my_collections_api.service;

import java.util.List;
import java.util.Optional;

import pt.dddev.my_collections_api.dto.ItemDTO;
import pt.dddev.my_collections_api.entity.Item;

public interface ItemService {
    public List<ItemDTO> addItems(List<Item> items);

    public List<ItemDTO> getItems();

    public Optional<ItemDTO> editItem(Long id, Item item);

    public Optional<Item> removeItemById(Long id);
}