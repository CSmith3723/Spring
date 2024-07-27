package cs.ph.powerhousing.dao;

import cs.ph.powerhousing.entities.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRepository extends JpaRepository<Housing, String> {


}
