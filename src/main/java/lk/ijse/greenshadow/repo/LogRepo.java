package lk.ijse.greenshadow.repo;

import lk.ijse.greenshadow.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<LogEntity, String> {
}
