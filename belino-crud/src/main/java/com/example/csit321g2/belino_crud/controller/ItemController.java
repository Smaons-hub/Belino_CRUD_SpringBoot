package com.example.csit321g2.belino_crud.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.csit321g2.belino_crud.entity.ItemEntity;
import com.example.csit321g2.belino_crud.service.ItemService;

@RestController
@RequestMapping("/item/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    private final ItemService iserv;

    @Autowired
    public ItemController(ItemService iserv) {
        this.iserv = iserv;
    }

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Simon Belino";
    }

    @PostMapping("/postNewItem")
    public ItemEntity postNewItem(@RequestBody ItemEntity item) {
        return iserv.postItem(item);
    }

    @GetMapping("/getAllItems")
    public List<ItemEntity> getAllItems() {
        return iserv.getAllItems();
    }

    @PutMapping("/putItem")
    public ItemEntity putItem(@RequestParam int id, @RequestBody ItemEntity newItemDetails) {
        return iserv.putItem(id, newItemDetails);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id) {
        return iserv.deleteItem(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
