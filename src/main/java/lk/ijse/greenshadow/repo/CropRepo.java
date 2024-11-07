package lk.ijse.greenshadow.repo;

import lk.ijse.greenshadow.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepo extends JpaRepository<CropEntity, String> {
}
