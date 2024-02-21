package com.trinity.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service // Esta clase funcionara como un servicio, por lo que se agrega la etiqueta
// @PropertySource("classpath:custom.properties") //Indicamos que vamos a leer
// de un archivo. Me conviene si solo se lee de un fichero

// Si usamos @PropertuSources podemos inyectar de mas de un fichero, siguiendo
// la siguiente estructura
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file.properties")
})
public class MyFirstService {
    // Hacemos inyeccion por campo(field)
    // @Autowired
    // @Qualifier("mySecondBean") // Por medio de inyeccion por campo, usamos
    // Quelifier si es que...
    // ... tenemos los beans declarados sin una especificacion

    private final MyFirstClass myFirstClass; // Nota: Agregarle un final provoca un error de compilacion
    @Value("Hola")
    private String customProperty;
    @Value("${my.prop}") // Indicamos que variable es la que se va a leer
    private String customPropertyFromAnotherFile;
    @Value("${my.prop.2}") // Indicamos que variable es la que se va a leer
    private String customPropertyFromAnotherFile2;

    // Esta es otra forma de leer desde el application.properties
    @Value("${my.custom.property}") // Se debe pasar con ${} el nombre de la variable y el tipo que esta almacenando
    private String customProperty2; // Usar el getter de esta variable para obtener el valor
    @Value("${my.custom.property.int}")
    private Integer customProperty3;

    public Integer getCustomProperty3() {
        return customProperty3;
    }

    public String getCustomProperty2() {
        return customProperty2;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public void setCustomPropertyFromAnotherFile2(String customPropertyFromAnotherFile2) {
        this.customPropertyFromAnotherFile2 = customPropertyFromAnotherFile2;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public void setCustomProperty(String customProperty) {
        this.customProperty = customProperty;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public void setCustomPropertyFromAnotherFile(String customPropertyFromAnotherFile) {
        this.customPropertyFromAnotherFile = customPropertyFromAnotherFile;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    public void setCustomPropertyInt(Integer customPropertyInt) {
        this.customPropertyInt = customPropertyInt;
    }

    @Value("123")
    private Integer customPropertyInt;
    // private Environment environment; // Creado para poder crear los beans de
    // variables de entorno.

    //Aqui es donde se define cual de los beans esta siendo usando en este momento, gracias al Qualifier
    public MyFirstService(
            @Qualifier("bean4") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
    ///////////////
    // Si usamos inyeccion de dependencias por medio del constructor no se usa
    /////////////// @Autowired
    /*
     * //@Autowired //Se realiza la inyeccion de dependencias
     * public MyFirstService(
     * 
     * @Qualifier("bean1") MyFirstClass myFirstClass) //Aqui al constructor le
     * decimos que bean va a usar
     * {
     * this.myFirstClass = myFirstClass;
     * }
     * 
     */

    ////// POR MEDIO DE INYECCION DE METODO. //////////////
    /*
     * @Autowired
     * public void injectDependencies(
     * 
     * @Qualifier("mySecondBean") MyFirstClass myFirstClass
     * ) {
     * this.myFirstClass = myFirstClass;
     * }
     * 
     */

    public MyFirstClass getMyFirstClass() {
        return myFirstClass;
    }

    /*
     * public void setMyFirstClass(MyFirstClass myFirstClass) {
     * this.myFirstClass = myFirstClass;
     * }
     * 
     * 
     */

    /*
     * public Environment getEnvironment() {
     * return environment;
     * }
     * 
     * @Autowired // Agregado para el Bean, esto realiza la inyeccion de dependencia
     * public void setEnvironment(Environment environment) {
     * this.environment = environment;
     * }
     * 
     */

    /*
     * ////Luego creamos un metodo que nos de la version de Java que esta utilizando
     * nuestro sistema
     * public String getJavaVersion(){
     * return environment.getProperty("java.version"); //Esto nos regresa la version
     * de Java en formato String
     * }
     * public String getOsName(){
     * return environment.getProperty("os.name"); //Nos permite saber el S.O que
     * esta usando la aplicacion
     * }
     * //Este metodo permite la lectura de una variable que esta en el
     * application.properties
     * public String readProp(){
     * return environment.getProperty("my.custom.property"); //Nos permite leer la
     * variable, tiene el nombre de esa variable tambien
     * }
     * 
     */

    ////////// INYECCION POR MEDIO DE SETTERS//////
    /*
     * @Autowired
     * public void setMyFirtsClass(
     * 
     * @Qualifier("mySecondBean") MyFirstClass myFirstClass) {
     * this.myFirstClass = myFirstClass;
     * }
     * 
     */

    public String tellAStory() {
        return "The bean is saying : " + myFirstClass.sayHello();
    }
}
