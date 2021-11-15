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

//    public String[] getEngText() {
//        return engText;
//    }
//
//    public void setEngText(String[] engText) {
//        this.engText = engText;
//    }
//
//    public String[] getUkrText() {
//        return ukrText;
//    }
//
//    public void setUkrText(String[] ukrText) {
//        this.ukrText = ukrText;
//    }
//
//    public String getTest_role() {
//        return test_role;
//    }
//
//    public void setTest_role(String test_role) {
//        this.test_role = test_role;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
