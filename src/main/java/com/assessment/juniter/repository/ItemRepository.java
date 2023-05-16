package com.assessment.juniter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.assessment.juniter.config.ItemStatus;
import com.assessment.juniter.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByItemStatusAndItemEnteredByUser(ItemStatus itemStatus, String itemEnteredByUser);

    Page<Item> findAll(Pageable pageable);

    boolean existsByItemName(String itemName);

}
