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


Notamos que los resultados obtenidos son similares a los resultados de No Solid. Se comprende que el método showEmpDetail() de la clase empleado no es necesario, pero hace que el codigo del cliente sea mas simple y facilmente comprensible.

Ademas se debe tener en cuenta que SRP no dice que una clase deba tener como maximo un metodo. El enfasis esta en la responsabilidad única. Pueden haber métodos estrechamente relacionados que pueden ayudar a impletar dicha resposabilidad.

Por ejemplo podemos colocar todos los métodos de visualización en una sola clase como se realiza en la clase cliente, la cual nos permite mostrar el nombre del empleado, los años de experiencia, el ID del empleado y si un empleado es Senior o Junior.

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
- **Muestra la salida y explica los resultados en función de los métodos entregados**

## Pregunta 13
- **Ahora supongamos que tienes un nuevo requisito que dice que necesitas admitir
usuarios invitados en el futuro. Puedes procesar la solicitud de pago de un usuario invitado,
pero no muestra su último detalle de pago. Entonces, crea la siguiente clase que implementa la
interfaz de pago de la siguiente manera:**
```java
class GuestUserPayment implements Payment {
	String name;
	public GuestUserPayment() {
		this.name = "guest";
	}
	@Override
	public void previousPaymentInfo(){
		throw new UnsupportedOperationException();
	}
	@Override
	public void newPayment(){
		System.out.println("Procesando de "+name+ "pago actual request.");
	}
}
```

## Pregunta 14
- **Dentro del método main(), utilizas una instancia de usuario invitado e intentas
  usar su clase auxiliar de la misma manera,¿ qué tipo de excepción te encuentras?¿Cuál es la
  solución?**

## Pregunta 15
- **Todo lo anterior Lo más importante es que viola el OCP cada vez que modifica una
  clase existente que usa esta cadena if-else. Entonces, busquemos una mejor solución.**

## Pregunta 16
**En el próximo programa, eliminaremos el método newPayment() de la interfaz de
  payment. Coloca este método en otra interfaz llamada NewPayment. Como resultado, ahora
  tienes dos interfaces con las operaciones específicas. Dado que todos los tipos de usuarios
  pueden generar una nueva solicitud de pago, las clases concretas de RegisteredUserPayment y
  GuestUserPayment implementan la interfaz NewPayment.**

**Pero muestra el último detalle de pago solo para los usuarios registrados. Entonces, la clase
  RegisteredUser implementa la interfaz payment. Dado que Payment contiene el método
  previousPaymentInfo(), tiene sentido elegir un nombre mejor, como PreviousPayment en lugar
  de Payment. Entonces, ahora verá las siguientes interfaces:**

```java
interface PreviousPayment {
	void previousPaymentInfo();
}
interface NewPayment {
	void newPayment();
}
```
**Ajuste estos nuevos nombres en la clase auxiliar también. En sección del código debes tener los siguientes archivos:**
- PreviousPayment.java
- NewPayment.java
- RegisteredUserPayment.java
- GuestUserPayment.java
- PaymentHelper.java
- Cliente.java


## Pregunta 17
- **¿Cuáles son los cambios clave?**


## Pregunta 18
- **Ten que aquí el enfoque clave estaba en el principio LSP, nada más. Podrías
  refactorizar fácilmente el código del cliente usando algún método estático. Por ejemplo realiza
  una modificación donde utilizas un método estático para mostrar todas las solicitudes de pago
  y utilizar este método siempre que lo necesites.**

<!--# ISP-->
# Principio de segregación de interfaz (ISP)
## Pregunta 19
- **¿Por qué un usuario necesita cambiar una clase base (o una interfaz)? Para
  responder a esto, supongamos que deseas mostrar qué el tipo de fax está utilizando en una fase
  de desarrollo posterior.**
**Tu sabes que existen diferentes variaciones de métodos de fax, como LanFax, InternetFax (o
  EFax) y AnalogFax. Entonces, antes, el método SendFax() no usaba ningún parámetro, pero
  ahora necesita aceptar un parámetro para mostrar el tipo de fax que usa. Escribe una jerarquía
  de fax que puede parecerse a la siguiente:**
```java
interface Fax {
// codigo
}
class LanFax implements Fax {
	@Override
// codigo
}
class EFax implements Fax {
	@Override
// codigo
}
```

## Pregunta 20
- **Para usar esta jerarquía de herencia, una vez que modificas el método sendFax() a
  sendFax(Fax faxType) en la clase ImpresoraAvanzada, exige que cambies la interfaz de
  Impresora (sí, aquí también rompe el OCP).**
- **Cuando actualices Impresora, también debes actualizar la clase impresoraBasica para
  adaptarse a este cambio. ¡Ahora ves el problema!. Explica el problema.**

## Pregunta 21
- **Si has entendido correctamente el problema. El ISP te sugiere que te ocupes de
  este tipo de escenario. Explica tu respuesta.**

## Pregunta 22
- **¿Es conveniente usar e inicializar el siguiente código?**
```java
interface Impresora {
	void printDocument();
	void sendFax();
}
```
## Pregunta 23
- **Si comienzas tu codificación considerando las impresoras avanzadas que pueden
  imprimir y enviar un fax, está bien. Pero en una etapa posterior, si tu programa también
  necesita admitir impresoras básicas,¿ qué código puedes escribir?**
- **¡Ya has visto que este código puede causarte un problema potencial!**
- **Está bastante claro que una impresora básica no necesita enviar un fax. Pero dado que
  ImpresoraBasica implementa Impresora, debe proporcionar una implementación de sendFax().
  Como resultado, cuando sendFax() cambia en la interfaz Impresora, ImpresoraBasica necesita
  adaptarse al cambio. El ISP sugiere que evites este tipo de situaciones.**
- **En este contexto, Cuando lanzas la excepción e intentas usar código polimórfico de manera
  incorrecta, ves el impacto de violar el LSP. Una vez que modificas Impresora, también viola el
  OCP.**

## Pregunta 24
- **Comprueba tus respuestas añadiendo dentro de main(), el siguiente código
  polimórfico:**
```java
Impresora impresora = new ImpresoraAvanzada();
impresora.printDocument();
impresora.sendFax();
impresora = new ImpresoraBasica();
impresora.printDocument();
//impresora .sendFax();
```
#### Nota: Además, no puedes escribir algo como:
```java
List<Impresora> impresoras = new ArrayList<Impresora>();
impresoras.add(new ImpresoraAvanzada());
impresoras.add(new ImpresoraBasica());
for (Impresora dispositivo : impresoras) { .printDocument();
	// dispositivo.sendFax();
}
```
#### En ambos casos, verás excepciones de tiempo de ejecución.
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

