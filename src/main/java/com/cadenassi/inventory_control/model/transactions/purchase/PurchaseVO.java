package com.cadenassi.inventory_control.model.transactions.purchase;

import com.cadenassi.inventory_control.model.transactions.Transaction;

public class Purchase implements Transaction {

    private Long id;
    private Float price;
    private String description;


    public Purchase() {
    }

    public Purchase(Float price, String description) {
        this.price = price;
        this.description = description;
    }


    @Override
    public void execute() {

    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
