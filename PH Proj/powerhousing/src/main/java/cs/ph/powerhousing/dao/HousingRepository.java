package cs.ph.powerhousing.dao;

import cs.ph.powerhousing.entities.Housing;
import cs.ph.powerhousing.entities.UserInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HousingRepository extends JpaRepository<Housing, String> {

    Housing findByNeighborhood(String neighborhood);

//    @Query("select h.medianOneBedApt from Housing h where h.neighborhood = :neighborhood")
//    int oneBedPriceByNeighborhood(String neighborhood);

}
