package pt.dddev.my_collections_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.dddev.wardrobe_api.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}