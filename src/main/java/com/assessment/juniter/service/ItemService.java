package com.assessment.juniter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assessment.juniter.config.ItemStatus;
import com.assessment.juniter.entity.Item;
import com.assessment.juniter.exceptions.ItemNotFoundException;
import com.assessment.juniter.repository.ItemRepository;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Method to add default data for testing
    public void createDefaultItemList(List<Item> items) {
        itemRepository.saveAll(items);
    }

    public void createItem(Item item) {
        if (!itemRepository.existsById(item.getItemId())) {
            itemRepository.save(item);
        } else {
            throw new DataIntegrityViolationException("Entry already exist for id=" + item.getItemId());
        }
    }

    public List<Item> getAllItems() throws ItemNotFoundException {
        List<Item> itemList = (List<Item>) itemRepository.findAll();
        if (itemList.isEmpty()) {
            throw new ItemNotFoundException();
        } else {
            return itemList;
        }
    }

    public List<Item> getItemsByStatusAndItemEnteredByUser(ItemStatus itemStatus, String enteredBy)
            throws ItemNotFoundException {
        List<Item> itemList = itemRepository.findByItemStatusAndItemEnteredByUser(itemStatus, enteredBy);
        if (itemList.isEmpty()) {
            throw new ItemNotFoundException();
        } else {
            return itemList;
        }
    }

    public Page<Item> getItemsWithPagination(int pageSize, int page, String sortBy) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        return itemRepository.findAll(pageRequest);
    }

    public Item getItemByItemId(Integer itemId) throws ItemNotFoundException {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        Item item = optionalItem.orElseThrow(() -> new ItemNotFoundException());
        return item;
    }

    public void updateItem(Integer itemId, Item updatedItem) throws ItemNotFoundException {
        Item existingItem = getItemByItemId(itemId);
        existingItem.setItemName(updatedItem.getItemName());
        existingItem.setItemBuyingPrice(updatedItem.getItemBuyingPrice());
        existingItem.setItemSellingPrice(updatedItem.getItemSellingPrice());
        existingItem.setItemLastModifiedDate(updatedItem.getItemLastModifiedDate());
        existingItem.setItemLastModifiedByUser(updatedItem.getItemLastModifiedByUser());
        existingItem.setItemStatus(updatedItem.getItemStatus());
        itemRepository.save(existingItem);
    }

    public void deleteItem(Integer itemId) throws ItemNotFoundException {
        Item existingItem = getItemByItemId(itemId);
        itemRepository.delete(existingItem);
    }

    public void deleteAllItems() {
        itemRepository.deleteAll();
    }
}
