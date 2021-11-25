package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class EngVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String videoName;

    @Lob
    private String videoContent;

}
