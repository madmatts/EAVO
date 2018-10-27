package pl.eavo.model.entities;

import org.springframework.format.annotation.DateTimeFormat;
import pl.eavo.model.FuelType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    private int id;
    private String brand;
    private String model;
    private String engine;
    private String vin;
    private FuelType fuelType;
    private Date productionDate;
    private Date firstRegistrationDate;
    private String registrationNumber;
    private User user;
    private Set<Refuel> refuel;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Temporal(TemporalType.DATE)
    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Temporal(TemporalType.DATE)
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vehicle")
    public Set<Refuel> getRefuel() {
        return refuel;
    }

    public void setRefuel(Set<Refuel> refuel) {
        this.refuel = refuel;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", vin='" + vin + '\'' +
                ", fuelType=" + fuelType +
                ", productionDate=" + productionDate +
                ", firstRegistrationDate=" + firstRegistrationDate +
                ", registrationNumber='" + registrationNumber + '\'' +
//                ", user=" + user +
//                ", refuel=" + refuel +
                '}';
    }
}
