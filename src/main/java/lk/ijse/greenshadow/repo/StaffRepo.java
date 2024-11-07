package lk.ijse.greenshadow.repo;

import lk.ijse.greenshadow.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<StaffEntity, String> {
}
