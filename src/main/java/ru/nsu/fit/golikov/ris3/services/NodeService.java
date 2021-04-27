package ru.nsu.fit.golikov.ris3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.fit.golikov.ris3.dtos.NodeDTO;
import ru.nsu.fit.golikov.ris3.entities.Node;
import ru.nsu.fit.golikov.ris3.repositories.NodeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NodeService {
    private final NodeRepository nodeRepository;

    @Autowired
    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public NodeDTO create(NodeDTO nodeDTO) {
        return NodeConverter.entityToDTO(nodeRepository.save(NodeConverter.dtoToEntity(nodeDTO)));
    }

    public NodeDTO read(long id) {
        Optional<Node> nodeOptional = nodeRepository.findById(id);

        if(!nodeOptional.isPresent()) {
            throw new RuntimeException();
        }

        return NodeConverter.entityToDTO(nodeOptional.get());
    }

    public NodeDTO update(long id, NodeDTO nodeDTO) {
        Optional<Node> nodeOptional = nodeRepository.findById(id);

        if(!nodeOptional.isPresent()) {
            throw new RuntimeException();
        }

        Node node = NodeConverter.dtoToEntity(nodeDTO);
        node.setId(nodeOptional.get().getId());

        return NodeConverter.entityToDTO(nodeRepository.save(node));
    }

    public void delete(long id) {
        Optional<Node> nodeOptional = nodeRepository.findById(id);

        if(!nodeOptional.isPresent()) {
            throw new RuntimeException();
        }

        nodeRepository.delete(nodeOptional.get());
    }

    public List<NodeDTO> search(double lat, double lon, double radius) {
        return nodeRepository.getNodesInRadius(lat, lon, radius).stream().map(NodeConverter::entityToDTO).collect(Collectors.toList());
    }
}
