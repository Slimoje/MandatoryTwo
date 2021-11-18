package com.example.mandatorytwo.models;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

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

    @Column(length = 2000)
    private String lore;

    @Column(length = 10000)
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "champion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Contestant> contestants;

}
