package pl.eavo.repository;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.eavo.model.FuelStationCount;
import pl.eavo.model.entities.Refuel;
import pl.eavo.model.entities.Vehicle;

import java.util.List;
import java.util.Map;

@Repository
public interface RefuelRepository extends CrudRepository<Refuel, Long> {

    List<Refuel> findAllRefuelsByVehicle(Vehicle vehicle);

    @Query("SELECT new pl.eavo.model.FuelStationCount(r.fuelStation, count(r.fuelStation)) FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} GROUP by fuelStation")
    List<FuelStationCount> findDistinctFuelStationByVehicle(@Param("vehicle") Vehicle vehicle);

    @Query("SELECT r.mileage FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} ORDER BY r.id DESC")
    Page<Long> findLatestMileage(@Param("vehicle") Vehicle vehicle, Pageable pageable);

    @Query("SELECT count(r.id) FROM Refuel r WHERE vehicle_id = :#{#vehicle.id}")
    Long findRefuelCountByVehicle(@Param("vehicle") Vehicle vehicle);

    @Query("SELECT sum(r.mileage - r.latestMileage) as sum FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} AND latestMileage != 0")
    Long findDistanceTraveledByVehicle(@Param("vehicle") Vehicle vehicle);

    @Query("SELECT sum(r.price) as priceSum FROM Refuel r WHERE vehicle_id = :#{#vehicle.id}")
    double findFuelSpendingsByVehicle(@Param("vehicle") Vehicle vehicle);

    // TODO @Query
    @Query("SELECT sum(r.mileage - r.latestMileage) FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} AND latestMileage != 0")
    Long findRepairCountByVehicle(@Param("vehicle") Vehicle vehicle);

    // TODO @Query
    @Query("SELECT sum(r.mileage - r.latestMileage) FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} AND latestMileage != 0")
    double findRepairSpendingsByVehicle(@Param("vehicle") Vehicle vehicle);

    @Query("SELECT avg(r.consumption) FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} AND latestMileage != 0")
    double findAverageConsumptionByVehicle(@Param("vehicle") Vehicle vehicle);

    @Query("SELECT avg(r.pricePerLitre) as sum FROM Refuel r WHERE vehicle_id = :#{#vehicle.id} AND latestMileage != 0")
    double findAverageFuelPriceByVehicle(@Param("vehicle") Vehicle vehicle);

    @Query("SELECT DATEDIFF(MAX(r.date), MIN(r.date)) / (COUNT(r.date) - 1) FROM Refuel r WHERE vehicle_id = :#{#vehicle.id}")
    double findAverageTimeBetweenRefuelsByVehicle(@Param("vehicle") Vehicle vehicle);
}
