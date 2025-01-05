package org.sid.microinventory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sid.microinventory.model.InventoryItem;
import org.sid.microinventory.repository.InventoryRepository;
import org.sid.microinventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    private InventoryItem testItem;

    @BeforeEach
    void setUp(){
        testItem = new InventoryItem();
        testItem.setName("Item x");
        testItem.setPrice(10.0);
        testItem.setQuantity(1);
    }

    @Test
    void testCreateProduct(){
        InventoryItem savedItem = inventoryService.saveItem(testItem);
        assertThat(savedItem).isNotNull();
        assertThat(savedItem.getName()).isEqualTo(testItem.getName());
        assertThat(savedItem.getPrice()).isEqualTo(testItem.getPrice());
        assertThat(savedItem.getQuantity()).isEqualTo(testItem.getQuantity());
    }

    @Test
    void testGetItemById(){
        InventoryItem savedItem = inventoryRepository.save(testItem);
        InventoryItem foundItem = inventoryService.getItemById(savedItem.getId());
        assertThat(foundItem).isNotNull();
        assertThat(foundItem.getName()).isEqualTo(testItem.getName());
    }

    @Test
    void testUpdateItem(){
        InventoryItem savedItem = inventoryRepository.save(testItem);
        InventoryItem foundItem = inventoryService.getItemById(savedItem.getId());
        foundItem.setQuantity(foundItem.getQuantity() + 1);
        inventoryService.saveItem(foundItem);
        InventoryItem updatedItem = inventoryService.getItemById(savedItem.getId());
        assertThat(updatedItem.getQuantity()).isEqualTo(2);
    }

    @Test
    void testDeleteItem(){
        InventoryItem savedItem = inventoryRepository.save(testItem);
        inventoryService.deleteItem(savedItem.getId());
        InventoryItem deletedItem = inventoryRepository.findById(savedItem.getId()).orElse(null);
        assertThat(deletedItem).isNull();


    }

}
