package com.felipe.ecomrecev1.model;

public class IncludedItems {

    private Integer quantity;
    protected String item;

    public IncludedItems() {
    }

    public IncludedItems(Integer quantity, String item) {
        this.quantity = quantity;
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
