package org.sid.microinventory.controller;


import org.sid.microinventory.model.InventoryItem;
import org.sid.microinventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getItemById(@PathVariable long id) {
        return ResponseEntity.ok(inventoryService.getItemById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return inventoryService.saveItem(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable long id) {
        inventoryService.deleteItem(id);
    }

}
