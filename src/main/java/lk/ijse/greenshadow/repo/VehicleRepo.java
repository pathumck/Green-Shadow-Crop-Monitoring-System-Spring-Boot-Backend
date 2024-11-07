package lk.ijse.greenshadow.repo;

import lk.ijse.greenshadow.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<VehicleEntity, String> {
}
