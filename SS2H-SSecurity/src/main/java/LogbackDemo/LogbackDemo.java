package LogbackDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackDemo {
	private static Logger logger=LoggerFactory.getLogger(LogbackDemo.class);
	public static void main(String[] args) {
		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure("src/main/resources/logback.xml");
       } catch (JoranException e) {
            e.printStackTrace();
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
        System.out.println("===================");
        //logger.debug("Hello {}","debug message");
        logger.trace("======trace");  
        logger.debug("======debug");  
        logger.info("======info");  
        logger.warn("======warn");  
        logger.error("======error");   
	}

}
