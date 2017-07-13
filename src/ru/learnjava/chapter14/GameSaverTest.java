package ru.learnjava.chapter14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by belyakovvv1 on 13.07.2017.
 */
public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter gc1 = new GameCharacter(10, "Orc", new String[] {"Axe", "Fists"});
        GameCharacter gc2 = new GameCharacter(5,"Elven", new String[] {"Bow", "Skimmer", "Dagger"});
        GameCharacter gc3 = new GameCharacter(25, "Mage", new String[] {"Fireball", "Staff"});

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("g.ser"));
            os.writeObject(gc1);
            os.writeObject(gc2);
            os.writeObject(gc3);
            os.close();
        }
        catch (Exception e){e.printStackTrace();}

        gc1 = null;
        gc2 = null;
        gc3 = null;

        try{

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("g.ser"));
            GameCharacter gcr1 = (GameCharacter) is.readObject();
            GameCharacter gcr2 = (GameCharacter) is.readObject();
            GameCharacter gcr3 = (GameCharacter) is.readObject();
            is.close();

            System.out.println(gcr1.getType());
            System.out.println(gcr2.getType());
            System.out.println(gcr3.getType());

        }
        catch (Exception e){e.printStackTrace();}
    }
}
