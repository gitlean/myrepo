package com.isoft.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

@Rule
public class BuzzRule {

    private int input;

    @Condition
    public boolean isBuzz() {
        return input % 7 == 0;
    }

    @Action
    public void printBuzz() {
        System.out.print("buzz");
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}

