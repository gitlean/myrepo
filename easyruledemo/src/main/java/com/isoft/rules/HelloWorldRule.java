package com.isoft.rules;


import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Action;
 
@Rule(name = "Hello World rule", description = "Always say hello world")
public class HelloWorldRule {
 
    @Condition
    public boolean when() {
        return true;
    }
 
    @Action
    public void then() throws Exception {
        System.out.println("hello world");
    }
 
}