package pt.dddev.my_collections_api.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import pt.dddev.wardrobe_api.dto.ItemDTO;
import pt.dddev.wardrobe_api.entity.Item;

@Service
public class ItemDTOMapper implements Function<Item, ItemDTO> {

    @Override
    public ItemDTO apply(Item item) {
        return new ItemDTO(item.getName(),
                item.getType(),
                item.getCategory());
    }
}