package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Table
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ukrWord;

    private String engWord;

    @Lob
    private String image;
    @ManyToOne
    @JoinColumn(name = "wordId")
    private User user;


    public Word(String ukrWord, String engWord) {
        this.ukrWord = ukrWord;
        this.engWord = engWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return Objects.equals(getId(), word.getId()) && Objects.equals(getUkrWord(), word.getUkrWord()) && Objects.equals(getEngWord(), word.getEngWord()) && Objects.equals(getImage(), word.getImage()) && Objects.equals(getUser(), word.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUkrWord(), getEngWord(), getImage(), getUser());
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", ukrWord='" + ukrWord + '\'' +
                ", engWord='" + engWord + '\'' +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }
}
