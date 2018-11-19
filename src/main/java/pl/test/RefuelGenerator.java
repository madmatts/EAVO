package pl.test;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.eavo.model.entities.Refuel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.round;


public class RefuelGenerator {

    private List<Refuel> refuelList;
    private int listRange;

    public RefuelGenerator(int listRange) {
        this.refuelList = new ArrayList<>();
        this.listRange = listRange;
    }

    public Double randDoubleFromRange(double min, double max) {
//        System.out.println(Double.valueOf(max - min).isInfinite() ? 0 : (double) Math.round(min + (max - min) * Math.random() * 100)/100);
        return Double.valueOf(max - min).isInfinite() ? 0 : (double) Math.round(min + (max - min) * Math.random() * 100)/100;
//        return 0.1;
    }

    public long randFirstRefuel() {
        long min = 100000L;
        long max = 250000L;
        Random r = new Random();
        return min + r.nextLong();
    }

}
