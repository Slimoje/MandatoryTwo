package com.example.mandatorytwo.models;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Table(name="Champions")
@Entity
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long championId;

    @Column
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Difficulty difficulty;

    @Column
    private String lore;


}
