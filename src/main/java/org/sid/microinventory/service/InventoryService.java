package org.sid.microinventory.service;

import org.sid.microinventory.model.InventoryItem;
import org.sid.microinventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryItem> getAllItems(){
        return inventoryRepository.findAll();
    }

    public InventoryItem getItemById(Long id){
        return inventoryRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }

    public InventoryItem saveItem(InventoryItem item){
        return inventoryRepository.save(item);
    }

    public void deleteItem(Long id){
        inventoryRepository.deleteById(id);
    }

}
