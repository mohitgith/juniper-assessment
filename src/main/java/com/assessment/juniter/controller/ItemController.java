package com.assessment.juniter.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.juniter.config.ItemStatus;
import com.assessment.juniter.entity.Item;
import com.assessment.juniter.exceptions.ItemNotFoundException;
import com.assessment.juniter.service.ItemService;

@RestController
@CrossOrigin
@RequestMapping("/app/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /*
     * GET request to /app/item:
     * • should accept GET requests at /app/item
     * • should return all the items from the database with return status code 200
     */

    @GetMapping
    public ResponseEntity<List<Item>> getItems() throws ItemNotFoundException {
        List<Item> itemList = itemService.getAllItems();
        return ResponseEntity.ok(itemList);
    }

    /*
     * GET request to /app/item/{itemId}:
     * • should accept GET requests at /app/item/{itemId} where itemId is a path
     * variable
     * • if the itemId exists in the database, then it should return the item with
     * status code 200
     * • if the itemId doesn't exist in the database, it should return status code
     * 404
     */

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemByItemId(@PathVariable Integer itemId) throws ItemNotFoundException {
        Item item = itemService.getItemByItemId(itemId);
        return ResponseEntity.ok(item);
    }

    /*
     * GET request to /app/item?itemStatus={status}&itemEnteredByUser={enteredBy}:
     * • should accept GET requests at
     * /app/item?itemStatus={status}&itemEnteredByUser={enteredBy}
     * • should return all the items having itemStatus=status and
     * itemEnteredByUser=enteredBy, where status and enteredBy are request params,
     * with status code 200
     */
    @GetMapping(params = { "itemStatus", "itemEnteredByUser" })
    public ResponseEntity<List<Item>> getItemUsingStatusAndItemEnteredByUser(
            @RequestParam("itemStatus") ItemStatus itemStatus,
            @RequestParam("itemEnteredByUser") String enteredBy) throws ItemNotFoundException {

        // List<Item> items =
        // itemService.getItemsByStatusAndItemEnteredByUser(ItemStatus.valueOf(itemStatus),
        // enteredBy);
        List<Item> items = itemService.getItemsByStatusAndItemEnteredByUser(itemStatus, enteredBy);
        return ResponseEntity.ok(items);
    }

    /*
     * GET request to
     * /app/item?pageSize={pageSize}&page={page}&sortBy={sortByField}:
     * • should accept GET requests at
     * /app/item?pageSize={pageSize}&page={page}&sortBy={sortByField}
     * • should return the requested page by paginating with pageSize and sorting by
     * the sortBy field
     */
    @GetMapping(params = { "pageSize", "page", "sortBy" })
    public ResponseEntity<Page<Item>> getItemUsingPagination(@RequestParam("pageSize") int pageSize,
            @RequestParam("page") int page, @RequestParam("sortBy") String sortByField) {
        Page<Item> itemPage = itemService.getItemsWithPagination(0, 0, sortByField);
        return ResponseEntity.ok(itemPage);
    }

    /*
     * POST request to /app/item :
     * • should accept POST requests at /app/item and item data as a JSON body
     * • if the itemId exists in the database, then it should return status code 400
     * • If the itemId doesn't exist in the database, then it should insert the data
     * and return the inserted item as a response with status code 201
     */
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        System.out.println(item);
        itemService.createItem(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*
     * PUT request to /app/item/{itemId}:
     * • should accept PUT requests at /app/item/{itemId} and item data as a JSON
     * body, where itemId is a path variable
     * • if the itemId exists in the database then it should update and return the
     * updated item as a response with status code 200
     * • if the itemId doesn't exist in the database, it should return status code
     * 404
     */
    @PutMapping("/{itemId}")
    public ResponseEntity<Item> modifyItem(@PathVariable Integer itemId, @RequestBody Item item)
            throws ItemNotFoundException {
        itemService.updateItem(itemId, item);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /*
     * DELETE request to /app/item:
     * • should accept DELETE requests at /app/item
     * • should delete all the items from the database and return status code 200
     */
    @DeleteMapping
    public ResponseEntity<Item> deleteItem() {
        itemService.deleteAllItems();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * DELETE request to /app/item/{itemId}:
     * • should accept DELETE requests at /app/item/{itemId} where itemId is a path
     * variable
     * • if the itemId exists in the database, then it should delete the specified
     * item and return status code 200
     * • if the itemId doesn't exist in the database, it should return status code
     * 400
     */
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Item> deleteItemByItemId(@PathVariable Integer itemId) throws ItemNotFoundException {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
