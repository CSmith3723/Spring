package cs.ph.powerhousing.services;

import cs.ph.powerhousing.dao.HousingRepository;
import cs.ph.powerhousing.entities.Calculator;
import cs.ph.powerhousing.entities.Housing;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class HousingService{

    private HousingRepository housingRepository;

    @Autowired
    public HousingService(HousingRepository thehousingRepository){
        housingRepository=thehousingRepository;
    }


    public List<String> neighborhoodsList() {
        List<Housing> neighborhoodInfo = housingRepository.findAll();

        return neighborhoodInfo.stream()
                .map(Housing::getNeighborhood)
                .collect(Collectors.toList());
    }

    public List<Housing> findAll() {
        return housingRepository.findAll();
    }



}
