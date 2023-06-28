package WarRobots;

import java.util.Random;

public class Robots {
    private int healthRobot = 100;
    private String nameRobot;
    private String getShootRandomAlf = "QWEASDZXC";


    public Robots(String nameRobot) {
        this.nameRobot = nameRobot;
        setGetShootRandomAlf(getShootRandomAlf);
        setHelthRobot(healthRobot);
    }

    public String getGetShootRandomAlf() {
        return this.getShootRandomAlf;
    }

    public String setGetShootRandomAlf(String getShootRandomAlf) {
        this.getShootRandomAlf = upSetRandomAlf(getShootRandomAlf);
        return getShootRandomAlf;
    }

    public int getHealthRobot() {
        return healthRobot;
    }

    public int setHelthRobot(int healthRobot) {
        this.healthRobot = healthRobot;
        return healthRobot; }

    public String getNameRobot() {
        return nameRobot;
    }

    public void setNameRobot(String nameRobot) {
        this.nameRobot = nameRobot;
    }

    public static String upSetRandomAlf(String getShootRandomAlf) {
        String alphabet = getShootRandomAlf;
        String alShoot = "";
        for (int i = 0; i < 5; i++) {
            int randIdx = new Random().nextInt(alphabet.length());
            char randChar = alphabet.charAt(randIdx);
            alphabet = alphabet.replace(String.valueOf(randChar), "");
            alShoot = alShoot + randChar;
        }
        return alShoot;
    }
}
