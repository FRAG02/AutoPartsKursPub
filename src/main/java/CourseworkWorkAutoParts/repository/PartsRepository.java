package CourseworkWorkAutoParts.repository;

import CourseworkWorkAutoParts.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long> {
    List<Parts> findByClientId(Long clientId);
}

