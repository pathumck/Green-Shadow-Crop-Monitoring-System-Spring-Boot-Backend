package lk.ijse.greenshadow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity {
    @Id
    private String fieldCode;
    private String name;
    private String location;
    private String size;
    @Column(columnDefinition = "LONGTEXT")
    private String imageOne;
    @Column(columnDefinition = "LONGTEXT")
    private String imageTwo;

    @ManyToMany(mappedBy = "fields", cascade = CascadeType.ALL)
    private List<CropEntity> crops;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "log_field",
            joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(name = "log_id")
    )
    private List<LogEntity> logs;

}
