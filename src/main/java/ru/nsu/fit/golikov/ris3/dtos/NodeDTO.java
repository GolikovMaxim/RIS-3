package ru.nsu.fit.golikov.ris3.dtos;

import lombok.Data;

import java.util.List;

@Data
public class NodeDTO {
    private long id;

    private String username;

    private double lon, lat;

    private List<TagDTO> tags;
}
