package com.isoft.app;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;

import com.isoft.rules.BuzzRule;
import com.isoft.rules.FizzBuzzRule;
import com.isoft.rules.FizzRule;
import com.isoft.rules.NonFizzBuzzRule;

public class FizzBuzzWithEasyRulesApp {
	public static void main(String[] args) {

		// create facts
		Facts facts = new Facts();

		// create rules engine
		RulesEngine fizzBuzzEngine = RulesEngineBuilder.aNewRulesEngine().withSkipOnFirstAppliedRule(true) // 如果第一个规则满足条件，后面的规则将不再执行
				.withSilentMode(true).build();

		// create rules
		FizzRule fizzRule = new FizzRule();
		BuzzRule buzzRule = new BuzzRule();
		FizzBuzzRule fizzBuzzRule = new FizzBuzzRule(fizzRule, buzzRule);
		NonFizzBuzzRule nonFizzBuzzRule = new NonFizzBuzzRule();

		// register rules
		Rules rules = new Rules();
		rules.register(fizzRule);
		rules.register(buzzRule);
		rules.register(fizzBuzzRule);
		rules.register(nonFizzBuzzRule);

		// fire rules
		for (int i = 1; i <= 100; i++) {
			fizzRule.setInput(i);
			buzzRule.setInput(i);
			nonFizzBuzzRule.setInput(i);
			fizzBuzzEngine.fire(rules, facts);
			System.out.println();

		}
	}

}
