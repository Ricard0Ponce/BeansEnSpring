package com.trinity.demo1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration // Agregamos la etiqueta que indica que esta clase realiza proceso de
				// configuracion
//@Profile("dev") //Desde la configuracion podemos definir el perfil que vamos a usar
//Si hacemos esto entonces todos los beans creados aqui pertenecen al perfil que indicamos
public class ApplicationConfig {

	// En la configuracion se genera el Bean
	@Bean // Se declarea que este metodo tiene un Bean
	@Qualifier("bean1") // Indicamos el nombre del Bean
	public MyFirstClass myFirstBean() {
		return new MyFirstClass("First bean"); // Creamos la instancia del objeto de tipo MyFirstClass
	}

	// En las siguientes lineas se crea otro Bean
	@Bean // Se declarea que este metodo tiene un Bean
	// @Qualifier("bean2") //Indicamos el nombre del Bean
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("Second Bind");
	}

	// Ahora tenemos 2 Beans de la clase MyFirstClass
	// Para este caso, debemos referenciar 1 Bean en especifico al realizar la
	// inyeccion de dependencias
	// Para solucionar lo anterior se usara @Qualifier.

	// En las siguientes lineas se crea otro Bean
	@Bean // Se declarea que este metodo tiene un Bean
	// @Primary // Esta anotacion le otorga prioridad a este Bean.
	public MyFirstClass myThirdBean() {
		return new MyFirstClass("Third Bind");
	}

	/////// ESTE ES UN EJEMPLO DE COMO SE CREA UN BEAN PARA UN ENTORNO ESPECIFICO
	@Bean("bean4") // Se declarea que este metodo tiene un Bean
	@Profile("dev")
	public MyFirstClass myFourBean() {
		return new MyFirstClass("Four bean"); // Creamos la instancia del objeto de tipo MyFirstClass
	}
}
