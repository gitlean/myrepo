package com.isoft.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

@Rule
public class NonFizzBuzzRule {

	private int input;

	@Condition
	public boolean isNotFizzNorBuzz() {
		// can return true here
		return input % 5 != 0 || input % 7 != 0;
	}

	@Action
	public void printInput() {
		System.out.print(input);
	}

	public void setInput(int input) {
		this.input = input;
	}

	@Priority
	public int getPriority() {
		return 3;
	}
}
