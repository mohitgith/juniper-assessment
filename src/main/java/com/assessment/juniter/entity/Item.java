package com.assessment.juniter.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.assessment.juniter.config.ItemStatus;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false, unique = true)
    private String itemEnteredByUser;
    @Column(nullable = false)
    private LocalDateTime itemEnteredDate;
    @Column(nullable = false)
    private Double itemBuyingPrice;
    @Column(nullable = false)
    private Double itemSellingPrice;
    @Column(nullable = false)
    private LocalDateTime itemLastModifiedDate;
    @Column(nullable = false)
    private String itemLastModifiedByUser;
    @Column(nullable = false)
    private ItemStatus itemStatus;

    public Item() {
    }

    public Item(String itemName, String itemEnteredByUser, LocalDateTime itemEnteredDate,
            Double itemBuyingPrice, Double itemSellingPrice, LocalDateTime itemLastModifiedDate,
            String itemLastModifiedByUser, ItemStatus itemStatus) {
        this.itemName = itemName;
        this.itemEnteredByUser = itemEnteredByUser;
        this.itemEnteredDate = itemEnteredDate;
        this.itemBuyingPrice = itemBuyingPrice;
        this.itemSellingPrice = itemSellingPrice;
        this.itemLastModifiedDate = itemLastModifiedDate;
        this.itemLastModifiedByUser = itemLastModifiedByUser;
        this.itemStatus = itemStatus;
    }

    public Integer getItemId() {
        return itemId;
    }

    // public void setItemId(Integer itemId) {
    // this.itemId = itemId;
    // }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEnteredByUser() {
        return itemEnteredByUser;
    }

    public void setItemEnteredByUser(String itemEnteredByUser) {
        this.itemEnteredByUser = itemEnteredByUser;
    }

    public LocalDateTime getItemEnteredDate() {
        return itemEnteredDate;
    }

    public void setItemEnteredDate(LocalDateTime itemEnteredDate) {
        this.itemEnteredDate = itemEnteredDate;
    }

    public Double getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public void setItemBuyingPrice(Double itemBuyingPrice) {
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public Double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(Double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public LocalDateTime getItemLastModifiedDate() {
        return itemLastModifiedDate;
    }

    public void setItemLastModifiedDate(LocalDateTime itemLastModifiedDate) {
        this.itemLastModifiedDate = itemLastModifiedDate;
    }

    public String getItemLastModifiedByUser() {
        return itemLastModifiedByUser;
    }

    public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
        this.itemLastModifiedByUser = itemLastModifiedByUser;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemEnteredByUser=" + itemEnteredByUser
                + ", itemEnteredDate=" + itemEnteredDate + ", itemBuyingPrice=" + itemBuyingPrice
                + ", itemSellingPrice=" + itemSellingPrice + ", itemLastModifiedDate=" + itemLastModifiedDate
                + ", itemLastModifiedByUser=" + itemLastModifiedByUser + ", itemStatus=" + itemStatus + "]";
    }

}
