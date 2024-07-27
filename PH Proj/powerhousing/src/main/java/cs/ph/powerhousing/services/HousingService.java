package cs.ph.powerhousing.services;

import cs.ph.powerhousing.entities.Calculator;
import cs.ph.powerhousing.entities.Housing;

import java.util.List;

public interface HousingService {

    List<String> neighborhoodsList();

    List<Housing> findAll();

    double calculateGrossWages(Calculator calculator);

    public double calculateNetWages(Calculator calculator);
}
