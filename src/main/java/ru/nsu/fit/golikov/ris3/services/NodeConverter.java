package ru.nsu.fit.golikov.ris3.services;

import ru.nsu.fit.golikov.ris3.dtos.NodeDTO;
import ru.nsu.fit.golikov.ris3.entities.Node;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NodeConverter {
    public static Node dtoToEntity(NodeDTO nodeDTO) {
        Node node = new Node();

        node.setLat(nodeDTO.getLat());
        node.setLon(nodeDTO.getLon());
        node.setUsername(nodeDTO.getUsername());
        if(nodeDTO.getTags() != null) {
            node.setTags(nodeDTO.getTags().stream().map(TagConverter::dtoToEntity).collect(Collectors.toList()));
        } else {
            node.setTags(new ArrayList<>());
        }

        return node;
    }

    public static NodeDTO entityToDTO(Node node) {
        NodeDTO nodeDTO = new NodeDTO();

        nodeDTO.setId(node.getId());
        nodeDTO.setLat(node.getLat());
        nodeDTO.setLon(node.getLon());
        nodeDTO.setUsername(node.getUsername());
        nodeDTO.setTags(node.getTags().stream().map(TagConverter::entityToDTO).collect(Collectors.toList()));

        return nodeDTO;
    }
}
