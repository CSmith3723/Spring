package cs.ph.powerhousing.dao;

import cs.ph.powerhousing.entities.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingRepository extends JpaRepository<Housing, String> {
}
