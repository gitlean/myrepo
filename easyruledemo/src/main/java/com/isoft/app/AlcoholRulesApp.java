package com.isoft.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;

import com.isoft.bean.Person;

public class AlcoholRulesApp {
	public static void main(String[] args) {
		try {
			call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void call() throws Exception {
		// create a person instance (fact)
		Person tom = new Person("Tom", 14);
		Facts facts = new Facts();
		facts.put("person", tom);

		 
		
		MVELRule alcoholRule = MVELRuleFactory
				.createRuleFrom(new File(tom.getClass().getClassLoader().getResource("alcohol-rule.yml").getFile()));

		MVELRule alcoholRule2 = MVELRuleFactory
				.createRuleFrom(new File(AlcoholRulesApp.class.getClassLoader().getResource("alcohol-rule2.yml").getFile()));

//		File file=new File(tom.getClass().getClassLoader().getResource("alcohol-rule.yml").getFile());
//		if(!file.exists()){
//			System.out.println("Not exists...");
//		}else{
//			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//			String line=null;
//			while(null!=(line=reader.readLine())){
//				System.out.println(line);
//			}
//			reader.close();
//		}
		
		
		
		// create a rule set
		Rules rules = new Rules();
		rules.register(alcoholRule);
		rules.register(alcoholRule2);
		

		// create a default rules engine and fire rules on known facts
		RulesEngine rulesEngine = new DefaultRulesEngine();

		System.out.println("Tom: Hi! can I have some Vodka please?");
		rulesEngine.fire(rules, facts);
	}
}
