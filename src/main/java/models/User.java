package models;

import java.util.ArrayList;

public class User {
    public String desiredStyle;

    public User(String desiredStyle) {
        this.desiredStyle = desiredStyle;
    }

    public void getFinalTactic(){
        Variables variables = new Variables();// To initialize static attributes
        ArrayList<String> formations = Variables.formations;
        System.out.println("yeep********");
        String[] user_propositions = desiredStyle.split("\\+");
        for (String user_prop: user_propositions) {
            boolean isFormation = false;
            for (String key: Variables.tactics.keySet()) {
                if (key.equals(user_prop.trim())) {
                    Integer score = Variables.tactics.get(key);
                    switch (score){
                        case 1: new Attack(key).interpret();
                                break;
                        case 0: new Balance(key).interpret();
                                break;
                        case -1: new Defend(key).interpret();
                                break;
                    }
                    isFormation = true;
                    break;
                }
            }
            if (!isFormation) {
                Tactic.all_instructions.add(user_prop.trim());
            }
        }
        System.out.println("score " + Tactic.score);
        System.out.println("nb of instructions " + Tactic.all_instructions.size());
    }

}
