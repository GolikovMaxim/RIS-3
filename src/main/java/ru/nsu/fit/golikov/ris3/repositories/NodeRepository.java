package ru.nsu.fit.golikov.ris3.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.nsu.fit.golikov.ris3.entities.Node;

import java.util.List;

public interface NodeRepository extends CrudRepository<Node, Long> {
    @Query(value = "SELECT * FROM nodes " +
            "WHERE earth_distance(ll_to_earth(?1, ?2), ll_to_earth(nodes.lat, nodes.lon)) < ?3 " +
            "ORDER BY earth_distance(ll_to_earth(?1, ?2), ll_to_earth(nodes.lat, nodes.lon)) ASC",
            nativeQuery = true)
    List<Node> getNodesInRadius(double lat, double lon, double radius);
}
