package com.example.csit321g2.belino_crud.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.csit321g2.belino_crud.entity.ItemEntity;
import com.example.csit321g2.belino_crud.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository irepo;

    @Autowired
    public ItemService(ItemRepository irepo) {
        this.irepo = irepo;
    }

    public ItemEntity postItem(ItemEntity item) {
        return irepo.save(item);
    }

    public List<ItemEntity> getAllItems() {
        return irepo.findAll();
    }

    public ItemEntity putItem(int id, ItemEntity newItemDetails) {
        ItemEntity item = irepo.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Item " + id + " does not exist"));
        item.setName(newItemDetails.getName());
        item.setUnit(newItemDetails.getUnit());
        item.setPrice(newItemDetails.getPrice());
        return irepo.save(item);
    }

    public String deleteItem(int id) {
        if (irepo.existsById(id)) {
            irepo.deleteById(id);
            return "Item " + id + " is successfully deleted";
        }
        throw new NoSuchElementException("Item " + id + " does not exist");
    }
}