package models;

public class Balance implements Expression{
    public String input;

    public Balance(String tactic) {
        this.input = tactic;
    }

    @Override
    public void interpret() {

    }
}
