package com.poject.coffeeshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client_bonus_card")
public class ClientBonusCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Client client;
    @Column(nullable = false)
    private Integer amount = 0;
    @Column(nullable = false)
    private Integer discountPercent = 5;

    public ClientBonusCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }
}
