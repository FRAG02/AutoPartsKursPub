package CourseworkWorkAutoParts.repository;

import CourseworkWorkAutoParts.model.Order;
import CourseworkWorkAutoParts.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Parts> findDistinctByStatus(String status);
}

