package cs.springdemo.mvc.entity;

import cs.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @CourseCode(value = "CHRIS", message = "must start with CHRIS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value=0, message="must be equal to or greater than 0")
    @Max(value=10, message="cannot give out more than 10 free passes")
    private Integer freePasses; //use wrapper class so that the trimmer from earlier works

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Customer(){}


    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
