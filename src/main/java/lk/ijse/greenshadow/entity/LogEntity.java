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
@Table(name = "log")
public class LogEntity {
    @Id
    private String logCode;
    private String date;
    private String details;
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    @ManyToMany(mappedBy = "logs", cascade = CascadeType.ALL)
    private List<FieldEntity> fields;

    @ManyToMany(mappedBy = "logs", cascade = CascadeType.ALL)
    private List<CropEntity> crops;

    @ManyToMany(mappedBy = "logs", cascade = CascadeType.ALL)
    private List<StaffEntity> staffs;
}
