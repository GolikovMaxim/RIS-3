package ru.nsu.fit.golikov.ris3.entities;

import lombok.Data;

import javax.persistence.*;

@Data @Entity @Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String k, v;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id")
    private Node node;
}
