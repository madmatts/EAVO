package pl.eavo.model;

/**
 * Created by MadMattz on 12.05.2016.
 */
public enum FuelType {
    PETROL("PETROL"),
    OIL("OIL"),
    LPG("LPG");

    private final String fuel;

    private FuelType(String s) {
        fuel = s;
    }

    public String toString() {
        return this.fuel;
    }

}
