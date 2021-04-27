package ru.nsu.fit.golikov.ris3.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data @Entity @Table(name = "nodes")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String username;

    private double lon, lat;

    @OneToMany(mappedBy = "node")
    private List<Tag> tags;
}
