package org.example;

import java.io.*;

class Hero implements Serializable {
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
        System.out.println("Имя: " + name);
        System.out.println("Уровень: " + level);
        System.out.println("Оружие: " + weapon.getName());
        System.out.println("Броня: " + armor.getName());
    }
}

class Weapon implements Serializable {
    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Armor implements Serializable {
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

            loadedHero.toString();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
