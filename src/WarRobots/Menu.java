package WarRobots;

import java.lang.invoke.SwitchPoint;
import java.util.*;

public class Menu {
    public static String getNumberShootConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static boolean contains(char args, String alf) {
        String args1 = "" + args;
        int indexM = alf.indexOf(args1); // Ищем символ в строке
        if (indexM == -1) {
            System.out.println("Промазав");
            System.out.println(args);
            System.out.println(alf);
            return false;
        } else {
            System.out.println("Влучив");
            alf = alf.replace(args1, "");
            System.out.println(args);
            System.out.println(alf);
            return true;
        }

    }

    public static boolean Menu1(HashMap<String, Robots> shootKeys1) {
        System.out.println("Game \"WarRobots\"");
        String nameRb;
        for (int i = 0; i < 2; i++) {
            int k = i + 1;
            System.out.println("Enter robot name " + k);
            System.out.println("Exit P");
            nameRb = getNumberShootConsole();
            if (nameRb.equalsIgnoreCase("P")) {
                System.out.println("Goodbye)");
                return false;
            } else if (shootKeys1.get(nameRb) != null) {
                i = i - 1;
                System.out.println(String.format("Назви роботів повинні відрізнятися"));
            } else {
                shootKeys1.put(nameRb, new Robots(nameRb));
                System.out.println(String.format("Назва робота %s", nameRb));
                System.out.println(String.format("вбивчі кнопки : %s", shootKeys1.get(nameRb).getGetShootRandomAlf()));
                System.out.println(String.format("Здоров'я робота %s =", nameRb + " " + shootKeys1.get(nameRb).getHealthRobot()));
            }
        }
        System.out.println(shootKeys1);
        System.out.println("---");
        return true;
    }
    public static boolean checkHelth(HashMap<String, Robots> shootKeys12) {
        boolean result;
        HashMap<String, Robots> shootKeys3 = shootKeys12;
        String nameRb;
        String shoots;
        char char1;
        Robots rb;
        for (Map.Entry<String, Robots> entry : shootKeys3.entrySet()) {
            nameRb = entry.getKey();
            rb = entry.getValue();
            if (rb.getHealthRobot() == 0) {
                System.out.println(String.format("Програв робот %s", nameRb));
                return result = false;
            } else {
                result = true;
                System.out.println(String.format("Cтріляють по роботу %s", nameRb));
                System.out.println("Exit P");
                shoots = getNumberShootConsole().toUpperCase(Locale.ROOT);
                char1 = shoots.charAt(0);

                if (char1 == 'P') {
                    System.out.println("Goodbye)");
                    return result = false;
                } else if (contains(char1, rb.getGetShootRandomAlf())) {
                    rb.setHelthRobot(rb.getHealthRobot() - 50);
                    System.out.println(String.format("Здоров'я робота %s ", nameRb + " = " + rb.getHealthRobot()));
                }
            }
        }
        return result = true;
    }

    public static void Menu2() {
        HashMap<String, Robots> shootKeys2 = new HashMap();
        boolean resultMenu1 = Menu1(shootKeys2);
        if (resultMenu1) {
            String nameRb;
            String shoots;
            char char1;
            Robots rb;
            int helthRb;
           while (checkHelth(shootKeys2)){};
        }
    }
}

 /*   public static void Menu2() {
        HashMap<String, Robots> shootKeys2 = new HashMap();
        boolean resultMenu1 = Menu1(shootKeys2);
        if (resultMenu1) {
            String nameRb;
            String shoots;
            char char1;
            Robots rb;
            int helthRb;
            do {
                for (Map.Entry<String, Robots> entry : shootKeys2.entrySet()) {
                    nameRb = entry.getKey();
                    rb = entry.getValue();
                    if (rb.getHealthRobot() == 0) {
                        System.out.println(String.format("Програв робот %s", nameRb));
                        return;
                    } else {
                        System.out.println(String.format("Cтріляють по роботу %s", nameRb));
                        System.out.println("Exit P");
                        shoots = getNumberShootConsole().toUpperCase(Locale.ROOT);
                        char1 = shoots.charAt(0);

                        if (char1 == 'P') {
                            System.out.println("Goodbye)");
                            return;
                        } else if (contains(char1, rb.getGetShootRandomAlf())) {
                            rb.setHelthRobot(rb.getHealthRobot() - 50);
                            helthRb = rb.getHealthRobot();
                            System.out.println(String.format("Здоров'я робота %s ", nameRb + " = " + rb.getHealthRobot()));
                        }
                    }
                }
            } while (.);
        }
    }
}*/
