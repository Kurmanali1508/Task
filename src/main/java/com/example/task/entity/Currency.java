package com.example.task.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "currency")
    private String currency;
}