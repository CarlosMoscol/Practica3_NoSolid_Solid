<h2> Hi, Practica 3! <img src="https://i.imgur.com/jbvlrax.gif" width="50"></h2>

<!--# SRP-->
# Principio de responsabilidad única (SRP)
## Pregunta 1
<!--# ### Muestra la salida y explica los resultados en función de los métodos entregados-->
- **Muestra la salida y explica los resultados en función de los métodos entregados**
	- El método displayEmpDetail() nos muestra para el primer empleado su lastName abejita seguido de su fristName Jessica, para el segundo empleado su lastName es Smart seguido de su fristName Chalito. ❤️
	
	- El método generateEmpId() concatena la primera palabra del firstName con un número aleatorio (Los 1000 primeros) para formar una identificación del empleado. En la ejecución, dentro del método main() (el código del cliente) se crea dos instancias de Empleado y se usa estos métodos para mostrar los detalles relevantes.
	Para el primer empleado obtenemos el ID J950 y para el segundo empleado el ID C147.
	
	- El método checkSeniority() evalúa si un empleado es una persona mayor. Se establece que si el empleado tiene más de 5 años de experiencia, es un empleado senior; de lo contrario, es un empleado Junior.
	Para el primer empleado es Senior y el segundo empleado es Junior.

<img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/SRP_Pregunta1.png">


## Pregunta 2
- **¿Cuál es el problema con este diseño y las razones posibles del problema?**

El problema es que no se esta cumpliendo con el SRP aquí. Al mostrar los detalles de un empleado, generar una identificación de empleado o verificar un nivel de antigüedad son actividades diferentes. Dado que se codifico todo en una sola clase, es posible que tenga problemas para adoptar nuevos cambios en el futuro.

Aquí hay algunos posibles razones:

👋 En un futuro se puede establecer un criterio diferente para decidir si un empleado es Senior o Junior e inclusive se podria agregar otra categoria como Master, por parte de la empresa.

👋 También se pueden el modificar el algoritmo para generar la identificación del empleado.


## Pregunta 3
- **Modifica la clase Empleado. Agrega dos clases SeniorityChecker que contiene el método checkSeniority() y la clase GeneradorIDEmpleado contiene el método generateEmpId(...) para generar la identificación del empleado. 
Para mejorar la legibilidad del código y evitar torpezas dentro del método main(), utiliza el método estático showEmpDetail(...). Este método llama al método displayEmpDetail() de Empleado, al método generateEmpId() de GeneradorIDEmpleado y al método checkSeniority() de SeniorityChecker. Tú entiendes que este método no era necesario, pero hace que el código del cliente sea simple y fácilmente comprensible.**

 Agregamos la clase SeniorityChecker con el metodo checkSeniority
```java
public class SeniorityChecker {
    public String checkSeniority(double experienceInYears){
        return experienceInYears > 5 ?"senior":"junior";
    }
}
```

 Agregamos la clase GeneradorIDEmpleado con el metodo generateEmpId()
```java
import java.util.Random;

public class GeneradorIDEmpleado {
    String empId;
    public String generateEmpId(String empFirstName) {
        int random = new Random().nextInt(1000);
        empId = empFirstName.substring(0, 1) + random;
        return empId;
    }
}
```

Tenemos la clase Empleado
```java
public class Empleado {
    public String firstName, lastName, empId;
    public double experienceInYears;
    public Empleado(String firstName, String lastName, double experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experience;
    }
    public void displayEmpDetail(){
        System.out.println("Nombre del empleado: "+lastName+","+firstName);
        System.out.println("Este empleado tiene "+ experienceInYears+" años de experiencia.");
    }
}
```

En el método main() de Cliente, se utiliza el método estático showEmpDetail(...). Este método llama al método displayEmpDetail() de Empleado, al método generateEmpId() de GeneradorIDempleado y al método checkSeniority() de SeniorityChecker.

```java
public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion de SRP");

        Empleado jessica = new Empleado("Jessica", "Abejita", 7.5);
        showEmpDetail(jessica);

        System.out.println("\n*******\n");

        Empleado chalo = new Empleado ("Chalito", "Smart", 3.2);
        showEmpDetail(chalo);

    }

    private static void showEmpDetail(Empleado emp) {
        // Muestra detalles del empleado
        emp.displayEmpDetail();

        //Genera el ID
        GeneradorIDEmpleado idGenerador = new GeneradorIDEmpleado();
        String empId=idGenerador.generateEmpId(emp.firstName);
        System.out.println("El ID del empleado es: " + empId);

        // Verifica el nivel laboral
        SeniorityChecker seniorityChecker = new SeniorityChecker();
        System.out.println("Este empleado es un" + " empleado " + seniorityChecker.checkSeniority(emp.experienceInYears));
    }
}
```


## Pregunta 4
- **Realiza una demostración completa que sigue a SRP. Explica tus resultados**
<img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/SRP_Pregunta4.png">





<!--# OCP-->
# Principio abierto/cerrado (OCP)
## Pregunta 5
- **¿Por que no es correcto colocar displayResult() y evaluateDistinction() en la misma clase, como la siguiente:**
```java
class Estudiante { 
	// …. 
	public void displayResult() { 
		// codigo 
	} 
	public void evaluateDistinction() { 
		// codigo 
	} 
	// … 
} 
```

## Pregunta 6
- **Muestra la salida y explica los resultados en función de los métodos entregados**

## Pregunta 7
- **¿Cuál es el problema con este diseño y las razones posibles del problema?. Para abordar este problema, puedes escribir un mejor programa.**

## Pregunta 8
- **Debes abordar el método de evaluación para la distinción de una mejor manera. Por lo tanto, crea la interfaz DistinctionDecider que contiene un método llamado EvaluationDistinction.**


## Pregunta 9
- **Completa el código de ArtsDistinctionDecider y ScienceDistinctionDecider que implementan esta interfaz y sobreescriben el método de evaluateDistinction(...) para especificar los criterios de evaluación según sus necesidades. De esta forma, los criterios de distinción específicos de flujo se envuelven en una unidad independiente. 
Debes tener en cuenta que el método de evaluateDistinction(...) acepta un parámetro Estudiante. Significa que ahora también puede pasar un objeto ArtsStudent o un objeto ScienceStudent a este método.**
 
## Pregunta 10
- **Realiza una demostración completa que sigue a OCP. Explica tus resultados**


## Pregunta 11
- **¿Cuáles son las principales ventajas ahora?**

<!--# LSP-->
# Principio de sustitución de Liskov (LSP)
## Pregunta 12

## Pregunta 13

## Pregunta 14

## Pregunta 15

## Pregunta 16

## Pregunta 17


<!--# ISP-->
# Principio de segregación de interfaz (ISP)
## Pregunta 18

## Pregunta 19

## Pregunta 20

## Pregunta 21

## Pregunta 22

## Pregunta 23

## Pregunta 24

## Pregunta 25

## Pregunta 26

## Pregunta 27

## Pregunta 28

## Pregunta 29

## Pregunta 30


<!--# DIP-->
# Principio de inversión de dependencia (DIP)
## Pregunta 31

## Pregunta 32

## Pregunta 33

## Pregunta 34

## Pregunta 35

## Pregunta 36

