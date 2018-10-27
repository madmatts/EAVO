package pl.test;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class MainMethod {

    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println(bCryptPasswordEncoder.matches("123", "$2a$10$TBQK/mYsV/oEVufKbcddcOzhU9R67MCavrIZNnfbmbojmyV7979ku"));


        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure("123");
        System.out.println(strength.getScore());

        strength = passwordCheck.measure("B123");
        System.out.println(strength.getScore());

        strength = passwordCheck.measure("Babilon354");
        System.out.println(strength.getScore());

        strength = passwordCheck.measure("B@!abilon354");
        System.out.println(strength.getScore());
    }
}
