package mx.uam.is.practicadiseno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Carga el application context
		 System.getProperty("java.classpath");
		new ClassPathXmlApplicationContext("mx/uam/is/practicadiseno/applicationContext.xml");

	}
}
