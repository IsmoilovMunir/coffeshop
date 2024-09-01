package com.poject.coffeeshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, unique = true)
    private Long chatId;
    private String name;
    private LocalDate birthday;
    private String email;
    private String registrationState;

    public Client() {
    }

    public Client(String registrationState) {
        this.registrationState = registrationState;
    }

    public Client(Long id, Long chatId, String name, LocalDate birthday, String email, String registrationState) {
        Id = id;
        this.chatId = chatId;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.registrationState = registrationState;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationState() {
        return registrationState;
    }

    public void setRegistrationState(String registrationState) {
        this.registrationState = registrationState;
    }
}
