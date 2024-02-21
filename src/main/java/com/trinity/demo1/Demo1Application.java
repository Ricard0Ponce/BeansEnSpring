package com.trinity.demo1;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // La clase principal de nuestra aplicacion
public class Demo1Application {

	public static void main(String[] args) {
		var app = new SpringApplication(Demo1Application.class); // Nos permite cargar el perfil
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev")); //Cargamos perfil que queremos ejecutar
		var ctx = app.run(args);
		// var ctx = SpringApplication.run(Demo1Application.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		/*
		 * System.out.println(myFirstService.getJavaVersion()); //Esto se obtiene
		 * gracias al Enviroment, con el bean creado
		 * System.out.println(myFirstService.getOsName());
		 * System.out.println(myFirstService.readProp()); // Lee la variable de las
		 * propiedades
		 * 
		 */
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
		System.out.println(myFirstService.getCustomProperty2());
		System.out.println(myFirstService.tellAStory());

	}

}
