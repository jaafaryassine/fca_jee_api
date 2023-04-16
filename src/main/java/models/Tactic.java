package models;

import java.util.ArrayList;

public class Tactic {
    public static int score;
    public static boolean isFalseNine = false;
    public static boolean isHighWingbacks = false;

    public String formation;
    public static ArrayList<String> all_instructions = new ArrayList<String>();

    public static String getFinalFormation(){
        if (score > 0) {
            if (isFalseNine)
                return "4-2-3-1 False 9";

            if (isHighWingbacks)
                return "3-5-2";

            return "4-2-3-1";
        } else if (score == 0) {
            return "4-4-2";
        }
        else {
            return "5-4-1";
        }
    }


    public static void resetParameters(){
        score = 0;
        all_instructions.clear();
        isFalseNine = false;
        isHighWingbacks = false;
    }



}
