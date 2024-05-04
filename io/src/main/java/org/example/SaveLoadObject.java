package org.example;

import java.io.*;

class Hero implements Serializable{
    String name;
    int level;
    Weapon weapon;
    Armor armor;

    public Hero(String name, int level, Weapon weapon, Armor armor) {
        this.name = name;
        this.level = level;
        this.weapon = weapon;
        this.armor = armor;
    }

    public String toString() {
        String res = "Имя: " + name + "\n";
        res += "Уровень: " + level + "\n";
        res += "Оружие: " + weapon.getName() + "\n";
        res += "Броня: " + armor.getName() + "\n";
        return res;
    }
}

class Weapon implements Serializable{
    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Armor implements Serializable{
    private String name;

    public Armor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class SaveLoadObject {
    public static void main(String[] args) {
        Hero hero = new Hero("Воин", 5, new Weapon("Меч"), new Armor("Доспехи"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("heroObject.ser"));
            out.writeObject(hero);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("heroObject.ser"));
            Hero loadedHero = (Hero) in.readObject();
            in.close();

            String result = loadedHero.toString();
            System.out.println(result);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
