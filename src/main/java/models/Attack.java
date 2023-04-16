package models;

public class Attack implements Expression{
    public String input;

    public Attack(String input) {
        this.input = input;
    }

    @Override
    public void interpret() {
        if (input.equals("False nine, deep")) {
            Tactic.isFalseNine=true;
        }
        if (input.equals("High wing-backs, overloads")) {
            Tactic.isHighWingbacks=true;
        }
        Tactic.score++;
    }
}
