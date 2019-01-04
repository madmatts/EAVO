package pl.eavo.model;

public class Statistics {

    private Long refuelCount;
    private Long distanceTraveled;
    private double fuelSpendings;
    private Long repairCount;
    private double repairSpendings;
    private double averageConsumption;
    private double averageFuelPrice;
    private double averageTimeBetweenRefuels;

    public Statistics(Long refuelCount, Long distanceTraveled, double fuelSpendings, Long repairCount, double repairSpendings, double averageConsumption, double averageFuelPrice, double averageTimeBetweenRefuels) {
        this.refuelCount = refuelCount;
        this.distanceTraveled = distanceTraveled;
        this.fuelSpendings = fuelSpendings;
        this.repairCount = repairCount;
        this.repairSpendings = repairSpendings;
        this.averageConsumption = averageConsumption;
        this.averageFuelPrice = averageFuelPrice;
        this.averageTimeBetweenRefuels = averageTimeBetweenRefuels;
    }

    public Long getRefuelCount() {
        return refuelCount;
    }

    public void setRefuelCount(Long refuelCount) {
        this.refuelCount = refuelCount;
    }

    public Long getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(Long distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double getFuelSpendings() {
        return fuelSpendings;
    }

    public void setFuelSpendings(double fuelSpendings) {
        this.fuelSpendings = fuelSpendings;
    }

    public Long getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(Long repairCount) {
        this.repairCount = repairCount;
    }

    public double getRepairSpendings() {
        return repairSpendings;
    }

    public void setRepairSpendings(double repairSpendings) {
        this.repairSpendings = repairSpendings;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(double averageConsumption) {
        this.averageConsumption = averageConsumption;
    }

    public double getAverageFuelPrice() {
        return averageFuelPrice;
    }

    public void setAverageFuelPrice(double averageFuelPrice) {
        this.averageFuelPrice = averageFuelPrice;
    }

    public double getAverageTimeBetweenRefuels() {
        return averageTimeBetweenRefuels;
    }

    public void setAverageTimeBetweenRefuels(double averageTimeBetweenRefuels) {
        this.averageTimeBetweenRefuels = averageTimeBetweenRefuels;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "refuelCount=" + refuelCount +
                ", distanceTraveled=" + distanceTraveled +
                ", fuelSpendings=" + fuelSpendings +
                ", repairCount=" + repairCount +
                ", repairSpendings=" + repairSpendings +
                ", averageConsumption=" + averageConsumption +
                ", averageFuelPrice=" + averageFuelPrice +
                ", averageTimeBetweenRefuels=" + averageTimeBetweenRefuels +
                '}';
    }
}
