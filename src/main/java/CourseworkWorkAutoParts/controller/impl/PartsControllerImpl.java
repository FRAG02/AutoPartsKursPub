package CourseworkWorkAutoParts.controller.impl;

import CourseworkWorkAutoParts.controller.PartsController;
import CourseworkWorkAutoParts.model.Parts;
import CourseworkWorkAutoParts.repository.OrderRepository;
import CourseworkWorkAutoParts.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PartsControllerImpl implements PartsController {

    @Autowired
    private PartsRepository partsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<List<Parts>> getAllParts() {
        return ResponseEntity.ok(partsRepository.findAll());
    }

    @Override
    public ResponseEntity<Parts> getPartsById(Long id) {
        Optional<Parts> vehicle = partsRepository.findById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Parts> createParts(Parts parts) {
        return ResponseEntity.ok(partsRepository.save(parts));
    }

    @Override
    public ResponseEntity<List<Parts>> getPartsByClientId(Long clientId) {
        List<Parts> parts = partsRepository.findByClientId(clientId);
        if (parts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parts);
    }

    @Override
    public ResponseEntity<List<Parts>> getPartsByOrderStatus(String status) {
        List<Parts> parts = orderRepository.findDistinctByStatus(status);
        if (parts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parts);
    }

    @Override
    public ResponseEntity<Parts> updateParts(Long id, Parts parts) {
        if (!partsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        parts.setId(id);
        return ResponseEntity.ok(partsRepository.save(parts));
    }

    @Override
    public ResponseEntity<Void> deleteParts(Long id) {
        if (!partsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        partsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}