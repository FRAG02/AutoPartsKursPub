package CourseworkWorkAutoParts.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parts")
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "type_parts", nullable = false)
    private String type_parts;

    @Column(name = "type_cars", nullable = false)
    private String type_cars;

    @Column(name = "year_cars", nullable = false)
    private int year_cars;

    @Column(name = "type_engine", nullable = false)
    private String type_engine;

    @OneToMany(mappedBy = "parts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parts> orders;

}