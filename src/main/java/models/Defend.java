package models;

public class Defend implements Expression{
    public String input;

    public Defend(String tactic) {
        this.input = tactic;
    }

    @Override
    public void interpret() {
        Tactic.score--;
    }
}
