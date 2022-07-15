<h2> Hi, Practica 3! <img src="https://i.imgur.com/jbvlrax.gif" width="50"></h2>

<!--# SRP-->
# Principio de responsabilidad única (SRP)
## Pregunta 1
<!--# ### Muestra la salida y explica los resultados en función de los métodos entregados-->
- **Muestra la salida y explica los resultados en función de los métodos entregados**
	- displayEmpDetail() ❤️
	- generateEmpId()
	- checkSeniority()



<img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/SRP_Pregunta1.png">

## Pregunta 2
- **¿Cuál es el problema con este diseño y las razones posibles del problema?**

## Pregunta 3
- **Modifica la clase Empleado. Agrega dos clases SeniorityChecker que contiene el método checkSeniority() y la clase GeneradorIDEmpleado contiene el método generateEmpId(...) para generar la identificación del empleado. 
Para mejorar la legibilidad del código y evitar torpezas dentro del método main(), utiliza el método estático showEmpDetail(...). Este método llama al método displayEmpDetail() de Empleado, al método generateEmpId() de GeneradorIDEmpleado y al método checkSeniority() de SeniorityChecker. Tú entiendes que este método no era necesario, pero hace que el código del cliente sea simple y fácilmente comprensible.**
 
## Pregunta 4
- **Realiza una demostración completa que sigue a SRP. Explica tus resultados**


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
