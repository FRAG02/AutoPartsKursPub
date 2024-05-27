package CourseworkWorkAutoParts.controller;

import CourseworkWorkAutoParts.model.Parts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/vehicles")
public interface PartsController {

    @GetMapping
    ResponseEntity<List<Parts>> getAllParts();

    @GetMapping("/{id}")
    ResponseEntity<Parts> getPartsById(@PathVariable Long id);

    @GetMapping("/client/{clientId}")
    ResponseEntity<List<Parts>> getPartsByClientId(@PathVariable Long clientId);

    @GetMapping("/status/{status}")
    ResponseEntity<List<Parts>> getPartsByOrderStatus(@PathVariable String status);

    @PostMapping
    ResponseEntity<Parts> createParts(@RequestBody Parts parts);

    @PutMapping("/{id}")
    ResponseEntity<Parts> updateParts(@PathVariable Long id, @RequestBody Parts parts);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteParts(@PathVariable Long id);
}