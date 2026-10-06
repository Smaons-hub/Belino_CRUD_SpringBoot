package com.example.csit321g2.belino_crud.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String name;
    private String unit;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    public ItemEntity() {}

    public ItemEntity(int itemId, String name, String unit, BigDecimal price) {
        this.itemId = itemId;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public String getUnit() { return unit; }
    public BigDecimal getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setUnit(String unit) { this.unit = unit; }
    public void setPrice(BigDecimal price) { this.price = price; }
}