package com.example.tmnn;

import java.io.Serializable;

public class ItemsList implements Serializable {
    private Item[] items;

    public ItemsList(Item[] items){
        this.items = items;
    }

    public Item[] getItems() {
        return this.items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

}
