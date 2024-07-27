package cs.ph.powerhousing.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {

    private String[] wageTypes = {"Hourly", "Salaried"};


    private double hoursWorked;
    private double monthlyExpense;
    private double grossMonthlyWages;
    private double netMonthlyWages;

}
