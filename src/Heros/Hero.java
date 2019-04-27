package Heros;

import JSONUtils.JsonFormatter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class Hero implements Walkable, Inferior {
    private String name;
    private String nickName;
    private String race;
    private int agility;
    private int strength;
    private int intelligence;

    public Hero(String name, String nickName, String race, int agility, int strength, int intelligence) {
        this.name = name;
        this.nickName = nickName;
        this.race = race;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;
    }

    protected Hashtable<String , String> generateStatusMap() {
        Hashtable<String , String> statMap = new Hashtable<>();
        statMap.put("name", name);
        statMap.put("nickName", nickName);
        statMap.put("race", race);
        statMap.put("agility", String.valueOf(agility));
        statMap.put("strength", String.valueOf(strength));
        statMap.put("intelligence", String.valueOf(intelligence));

        return statMap;
    }


    /**
     * getters and setters
     */
    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return "a/an " +race+ " hero named " + name + " also known as " + nickName;
    }

    @Override
    public void attack() {
        System.out.println("ha ha i'm attacking");

    }

    @Override
    public void insult() {
        System.out.println("*#$*@");

    }

    @Override
    public void walk() {

    }

    @Override
    public void run() {

    }
}
