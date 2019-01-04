package pl.eavo.model;

public class FuelStationCount {

    private String fuelStation;
    private Long count;

    public FuelStationCount(String fuelStation, Long count) {
        this.fuelStation = fuelStation;
        this.count = count;
    }

    public String getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(String fuelStation) {
        this.fuelStation = fuelStation;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FuelStationCount{" +
                "fuelStation='" + fuelStation + '\'' +
                ", count=" + count +
                '}';
    }
}
