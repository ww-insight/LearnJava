package ru.learnjava.chapter14;

import java.io.Serializable;

/**
 * Created by belyakovvv1 on 13.07.2017.
 */
public class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponList = "";

        for (int i =0; i< weapons.length; i++){
            weaponList += "".equals(weaponList)?"":" " + weapons[i];
        }

        return weaponList;
    }
}
