package models;

import java.util.ArrayList;

public class Instruction implements Expression{
    public String instruction;
    public static ArrayList<String> all_instructions = new ArrayList<String>();

    public Instruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public void interpret() {

    }
}
