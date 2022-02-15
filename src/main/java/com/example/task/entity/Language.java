package com.example.task.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private String language;
}