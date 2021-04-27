package ru.nsu.fit.golikov.ris3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fit.golikov.ris3.dtos.NodeDTO;
import ru.nsu.fit.golikov.ris3.services.NodeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/node")
public class NodeController {
    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/{id}")
    public NodeDTO getNode(@PathVariable("id") long id) {
        return nodeService.read(id);
    }

    @PostMapping("/")
    public NodeDTO createNode(@RequestBody NodeDTO nodeDTO) {
        return nodeService.create(nodeDTO);
    }

    @PutMapping("/{id}")
    public NodeDTO updateNode(@PathVariable("id") long id, @RequestBody NodeDTO nodeDTO) {
        return nodeService.update(id, nodeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable("id") long id) {
        nodeService.delete(id);
    }

    @GetMapping("/search")
    public List<NodeDTO> search(@RequestParam("lat") double lat, @RequestParam("lon") double lon, @RequestParam("radius") double radius) {
        return nodeService.search(lat, lon, radius);
    }
}
