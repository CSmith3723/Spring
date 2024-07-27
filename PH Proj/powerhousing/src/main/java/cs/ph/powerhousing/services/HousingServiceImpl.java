package cs.ph.powerhousing.services;

import cs.ph.powerhousing.dao.HousingRepository;
import cs.ph.powerhousing.entities.Calculator;
import cs.ph.powerhousing.entities.Housing;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class HousingServiceImpl implements HousingService{

    private HousingRepository housingRepository;

    @Autowired
    public HousingServiceImpl(HousingRepository thehousingRepository){
        housingRepository=thehousingRepository;
    }


    @Override
    public List<String> neighborhoodsList() {
        List<Housing> neighborhoodInfo = housingRepository.findAll();

        return neighborhoodInfo.stream()
                .map(Housing::getNeighborhood)
                .collect(Collectors.toList());
    }

    @Override
    public List<Housing> findAll() {
        return housingRepository.findAll();
    }


    @Override
    public double calculateGrossWages(Calculator calculator){
        if(calculator.getWageType().equals("Hourly")){
            return calculator.getWageInput() * 40 * 4;
        }
        else{
            return  calculator.getWageInput()/12;
        }
    }


    @Override
    public double calculateNetWages(Calculator calculator){
        return calculator.getGrossMonthlyWages() - calculator.getMonthlyExpenses();
    }

}
