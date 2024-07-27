package cs.ph.powerhousing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Entity
public class Housing {

    @Id
    private int id;

    private List<String> locations = new ArrayList<>();
    private List<String> housingTypes = new ArrayList<>(Arrays.asList("House", "One-Bedroom Apartment", "Two-Bedroom Apartment"));

    private double medianHomePrice;
    private double medianOneBedApt;
    private double medianTwoBedApt;

}
