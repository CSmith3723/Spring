package cs.ph.powerhousing.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="neighborhoods")
public class Housing {

    public Housing(){}

    @Id
    @Column(name="neighborhood")
    private String neighborhood;

    @Column(name="median_home_price")
    private double medianHomePrice;

    @Column(name="median_onebr_apt_price")
    private double medianOneBedApt;

    @Column(name="median_twobr_apt_price")
    private double medianTwoBedApt;



}
