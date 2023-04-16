package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Variables {
    public static ArrayList<String> formations =new ArrayList<String>();
    public static HashMap<String,Integer> tactics = new HashMap<String,Integer>();
    public static ArrayList<String> suggestions =new ArrayList<String>();
    public Variables() {
        formations.add("4-1-2-3");
        formations.add("4-1-2-3 False 9");
        formations.add("4-4-2");
        formations.add("3-5-2");
        formations.add("5-4-1");

        tactics.put("Possession-based, accurate passes",1);
        tactics.put("Compact defense, limited space",-1);
        tactics.put("Counter-attacking, pace",-1);
        tactics.put("False nine, deep",1);
        tactics.put("High wing-backs, overloads",1);
        tactics.put("Diamond midfield, possession",0);
        tactics.put("Flat back four, solid",-1);

        suggestions.add("High-pressing, turnovers");
        suggestions.add("Zonal marking, set-pieces");
        suggestions.add("High defensive line, pressing");
        suggestions.add("Sweeper-keeper, attacking moves");
        suggestions.add("Set-piece routines, variety");
    }

    // Formations array



}
