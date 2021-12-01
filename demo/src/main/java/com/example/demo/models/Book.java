package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String test_role;

    @Lob
    private String image;

    private String[] engText;

    private String[] ukrText;


    public Book(String name, String text) {
        this.name = name;
        this.description=text;
    }
}
