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

<img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/SRP_Pregunta1.png" alt="">


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

<img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/SRP_Pregunta4.png" alt="">





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
  - RPTA:
  - El archivo Payment.java tiene por función general simular interfaz de pago que puede hacer una nueva orden de pago 
  y el almacenar los pagos previos de un usuario teniendo los métodos:
    - El previousPaymentInfo() del archivo Payment.java tiene como función simular el almacenar los pagos previos
    - El método newPayment() del archivo Payment.java tiene como función simular la nueva solicitud de pago de un usuario
  - El archivo PaymentHelper.java tiene por función general ayudar a visualizar pagos anteriores y nuevas solicitudes 
  esto mediante los métodos:
    - El método addUser() del archivo PaymentHelper.java añade un usuario a la lista de órdenes de pagos (payments), 
    para que pueda iniciar el proceso
    - El método showPreviousPayments() del archivo PaymentHelper.java llama a previousPaymentInfo() para poder mostrar 
    las órdenes de pago previas, haciendo uso de un bucle for para ello.
    - El método processNewPayments() del archivo PaymentHelper.java llama a newPayment() para simular el generar el 
    proceso de hacer una nueva orden de pago, haciendo uso de un bucle for para ello.
  - Dentro del archivo cliente.java se crearon dos usuarios (con ayuda del método addUser()) y se solicita el realizar 
  una nueva orden de pago para cada uno, así como mostrar las órdenes de pago previas. Aparentemente, no ha habido un 
  error de compilación y ejecución.
  
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta12.png" alt="">

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
  - RPTA:
  - Se agrega el codigo solicitado en el archivo GuestUserPayment.java:

  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta13.png" alt="">

## Pregunta 14
- **Dentro del método main(), utilizas una instancia de usuario invitado e intentas
  usar su clase auxiliar de la misma manera,¿qué tipo de excepción te encuentras?¿Cuál es la
  solución?**
  - RPTA:
  - La excepción que se muestra es UnsupportedOperationException la cual aparece para indicar que la operación 
  solicitada no es compatible. Esto se debe a que el nuevo segmento de código GuestUserPayment no es compatible con 
  la operación de showPreviousPayments() del archivo PaymentHelper.java aun si parece funcional (e implementa a Payment), 
  en específico debido al loop for de showPreviousPayments(), en cada bucle este método llama al método 
  previousPaymentInfo(), dicho método causa la excepción en GuestUserPayment, esto gracias a que en las líneas 9 a 11 de 
  GuestUserPayment sobreescribe a previousPaymentInfo() haciendo que lance dicha excepción si es que se utiliza el 
  método mencionado, dado que no hay una diferenciación entre un usuario registrado y un usuario invitado.

  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta14.png" alt="">
  
  - La solución que inicialmente utilizaría sería hacer uso de un switch case o varios if-else para verificar cuando se
  trate de un usuario o un invitado en función de una palabra clave para cada uno, sin embargo, gracias a lo aprendido 
  en clases sobre el tema de principios SOLID nos damos cuenta de que al agregar cualquiera de los dos (Switch case o 
  if-else) a la clase PaymentHelper se estaría violando el principio de abierto/cerrado (OCP) dado que se estaría 
  modificando una clase para extender su comportamiento.

## Pregunta 15
- **Todo lo anterior Lo más importante es que viola el OCP cada vez que modifica una
  clase existente que usa esta cadena if-else. Entonces, busquemos una mejor solución.**
  - RPTA:
  - Una solución que busque respetar el código ya establecido en PaymentHelper sería trabajar con interfaces 
  como se menciona en la siguiente pregunta.
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
  - RPTA:
  - Cambios realizados a los archivos y archivos solicitados:
  - NewPayment.java:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_1.png" alt="">
    
  - PreviousPayment.java:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_2.png" alt="">
  
  - PaymentHelper.java:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_3.png" alt="">
  
  - RegisteredUserPayment.java:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_4.png" alt="">
  
  - GuestUserPayment.java:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_5.png" alt="">
  
  - Cliente.java:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_6.png" alt="">
  
  - Lista de archivos:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_7.png" alt="">
  
  - Ejecución:
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/LSP_Pregunta16_8.png" alt="">

## Pregunta 17
- **¿Cuáles son los cambios clave?**
  - RPTA:
  - En el primer caso (NoSolid) los métodos showPreviousPayments() y processNewPayments() usaban solo 1 interfaz para 
  el bucle for, sin embargo, en el segundo caso (Solid) se usan dos interfaces, uno para cada método.
  Para el primer método (showPreviousPayments()) se utiliza la interfaz PreviousPayment la cual contiene al método 
  previousPaymentInfo(). Para el segundo caso se utilizó la interfaz NewPayment que tiene al método newPayment(), es 
  así que se soluciona el problema la excepción vista en la pregunta 14; ahora sí se respeta el principio LSP dado que 
  el programa funciona y es refactorizable.

## Pregunta 18
- **Ten que aquí el enfoque clave estaba en el principio LSP, nada más. Podrías
  refactorizar fácilmente el código del cliente usando algún método estático. Por ejemplo realiza
  una modificación donde utilizas un método estático para mostrar todas las solicitudes de pago
  y utilizar este método siempre que lo necesites.**
  - RPTA:
  - Para este código simplemente se trabajará sobre el archivo cliente añadiendo el método estático solicitado:

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
- RPTA:
  - La jerarquía utilizada será la siguiente:
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/ISP_Pregunta19.png" alt="">
  - Mediante la interfaz Fax se crea de manera nativa el método faxType, el cual será sobreescrito según el tipo 
  de envio de fax que se solicite. Los tipos (clases) serán LanFax en el que se sobreescribe faxtype() para mostrar un 
  mensaje que mencione que se utiliza este tipo de envio, de forma similar para el tipo (clase) EFax.

## Pregunta 20
- **Para usar esta jerarquía de herencia, una vez que modificas el método sendFax() a
  sendFax(Fax faxType) en la clase ImpresoraAvanzada, exige que cambies la interfaz de
  Impresora (sí, aquí también rompe el OCP).**
- **Cuando actualices Impresora, también debes actualizar la clase impresoraBasica para
  adaptarse a este cambio. ¡Ahora ves el problema!. Explica el problema.**
  - RPTA:
  - El problema radica en el hecho de que al hacer el cambio en la clase ImpresoraAvanzada dicho cambio solicita que 
  agregue se agregue el método sendFax() a la interfaz Impresora, dicho método no es necesario para la clase 
  impresoraBasica por lo que esto "engrosa" la interfaz Impresora con métodos que no son relevantes para todas las 
  clases que la implementan. Es aquí donde el ISP entra a actuar, segregando los métodos que engrosan a lña interfaz 
  de tal manera que sean implementados solo los métodos necesarios a las clases que los requieran. 
  (Se adjunta foto del cómo el propio IDE solicitaría que se agregue el método mencionado a la interfaz Impresora)
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/ISP_Pregunta20.png" alt="">

## Pregunta 21
- **Si has entendido correctamente el problema. El ISP te sugiere que te ocupes de
  este tipo de escenario. Explica tu respuesta.**
  - RPTA:
  - Tal y como se mencionó en la respuesta anterior el uso del ISP es debido a que el engrosamiento de la interfaz 
  más adelante podría generar conflictos en caso se necesitaran agregar otros tipos de impresoras que no requieran de 
  todos los métodos utilizados en la interfaz. La segregación de interfaces permite distribuir los métodos que se 
  usarían en la interfaz principal permitiendo una mayor flexibilidad de añadir nuevas clases, minimizando la 
  posibilidad de errores, sdin la necesidad de romper el OCP.

## Pregunta 22
- **¿Es conveniente usar e inicializar el siguiente código?**
```java
interface Impresora {
	void printDocument();
	void sendFax();
}
```
  - RPTA:
  - Como respuesta corta, No; Explicación: esto debido a que dicha interfaz si bien permite facilmente agregar una clase 
  ImpresoraAvanzada en caso se necesite agregar un tipo de impresora que no utilice todos los métodos habría un 
  conflicto y al añadir una excepción para dicho nuevo tipo de impresora puede llegar a causar un conflicto con las 
  demás clases o incluso con la interfaz misma (como fue visto en un caso anterior NoSolid del LSP)

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
  - RPTA:
  - El código que se puede escribir contendría una excepción para que no haga uso del envio de fax (que no es 
  necesario para una impresora basica), sin embargo, como se vio en la sección de LSP (NoSolid) esto causaría un 
  conflicto similar
  - El código que se podría utilizar sería el siguiente:
  ```java
  class ImpresoraBasica implements Impresora {
    @Override
    public void printDocument() {
      System.out.println("La impresora basica imprime un documento.");
    }
  
    @Override
    public void sendFax() {
      throw new UnsupportedOperationException();
    }
  }
  ```
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
  - RPTA:
  - Se adjunta imagen en la que se puede visualizar el cómo sucede el error esperado al hacer uso la excepción 
mencionada en el código de la pregunta 23, esto prueba las respuestas expuestas anteriormente.
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/ISP_Pregunta23.png" alt="">



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
  - RPTA:


## Pregunta 25
- **Reemplaza el segmento de código**
```java
for (Impresora dispositivo : impresoras) { .printDocument();
// dispositivo.sendFax();
        }
```
- **con una expresión lambda adecuada. Tú eliges cuál quieres usar.**
- **Sean los siguientes archivos:**
  - Impresora.java 
  - ImpresoraBasica.java 
  - ImpresoraAvanzada.java 
  - Cliente.java 
  - JerarquiaFax.java
## Pregunta 26
- **Muestra la salida y explica los resultados en función de los métodos entregados.**
## Pregunta 27
- **Supongamos que necesitas admitir otra impresora que pueda imprimir, enviar
  faxes y fotocopiar. En este caso, si agregas un método de fotocopiado en la interfaz Impresora,
  los dos clientes existentes, ImpresoraBasica y ImpresoraAvanzada, deben adaptarse al cambio.**
- **Busquemos una mejor solución.**
- **Hay dos actividades diferentes: una es imprimir unos documentos y la otra es enviar un fax.
  Crea dos interfaces llamada Impresora y DispositivoFax. Impresora contiene el método
  printDocument() y DispositivoFax contiene el método SendFax(). La idea es sencilla:**
  - La clase que desea la función de impresión implementa la interfaz Impresora y la clase
    que desea la función de fax implementa la interfaz DispositivoFax.
  - Si una clase quiere ambas funcionalidades, implementa ambas interfaces.
- **No debes asumir que el ISP dice que una interfaz debe tener solo un método. En este ejemplo
  hay dos métodos en la interfaz de Impresora y la clase ImpresoraBasica necesita solo uno de
  ellos. Es por eso que ves las interfaces segregadas con un solo método.**
- **Para terminar esta pregunta, en la sección de SOLID del código entregado, completa los
  siguientes archivos. No olvides explicar tus resultados.**
  - Impresora.java 
  - DispositivoFax.java 
  - ImpresoraBasica.java 
  - ImpresoraAvanzada.java 
  - Cliente.java
## Pregunta 28
- **¿Qué sucede si usa un método predeterminado dentro de la interfaz?**
## Pregunta 29
- **¿Qué sucede si proporcionas un método de fax predeterminado en una interfaz?.
  Viste el problema potencial con esto!**
## Pregunta 30
- **¿Qué sucede si usa un método vacío, en lugar de lanzar la excepción?**

<!--# DIP-->
# Principio de inversión de dependencia (DIP)
## Pregunta 31
- **Muestra la salida y explica los resultados en función de los métodos entregados**
  - InterfaceUsuario.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta31_1.png" alt="">
  - OracleDataBase.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta31_2.png" alt="">
  - Cliente.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta31_3.png" alt="">
- **En un inicio se crea una instancia del objeto OracleDatabase dentro del constructor UserInterface. Luego se usa este
  objeto para invocar el método saveEmpIdInDatabase(), que realizará el guardado real dentro de la base de datos de Oracle.**
## Pregunta 32
- **El programa es simple, pero ¿qué tipo de problemas presenta?**
  - problemas:
    - La clase UserInterface tiene demasiada dependencia de la clase de nivel inferior de la Base de datos Oracle. Estas dos clases están estrechamente unidas. 
    - Entonces, en un futuro, si la clase OracleDatabase esta necesitará adecuar la clase UserInterface.
    - No se tiene con claridad que sucede en caso se hiciera un cambio de base de datos de Oracle a MySQL por ejemplo.
## Pregunta 33
- **En el programa de la carpeta SOLID, para el caso DIP verás la siguiente jerarquía:**
  - BaseDatos.java
  - OracleDatabase.java
- **La primera parte del DIP sugiere que nos centramos en la abstracción. Esto hace que el
  programa sea eficiente. Entonces, esta vez la clase InterfazUsuario tiene como objetivo la base
  de datos de abstracción, en lugar de una implementación concreta como OracleDatabase.**
- **Implementa la clase InterfazUsuario.**
  <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta33.png" alt="">
- **Esto brinda la flexibilidad de considerar una nueva base de datos, como MYSQLDatabase
  también.**
- **La segunda parte del DIP sugiere hacer la interfaz de la base de datos considerando la
  necesidad de la clase InterfazUsuario.**
- **Es importante porque si una interfaz necesita cambiar para admitir a uno de sus clientes, otros
  clientes pueden verse afectados por el cambio.**
  - Es importante porque si una interfaz necesita cambiar para admitir a uno de sus clientes, otros
    clientes pueden verse afectados por el cambio.
## Pregunta 34
- **Completa todos los archivos siguientes de la sección SOLID**
  - InterfazUsuario.java
  - BaseDatos.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta34_1.png" alt="">
  - OracleDataBase.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta34_2.png" alt="">
  - MySQLDatabase.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta34_3.png" alt="">
  - Cliente.java
    <img src="https://github.com/CarlosMoscol/Practica3_NoSolid_Solid/blob/master/PruebasImagenes/DIP_Pregunta34_4.png" alt="">
- **Explica los resultados.¿ El programa resuelve todos los posibles problemas del programa que
  no usa DIP.**
- **En resumen, en OOP, te sugiero seguir la cita de Robert C. Martin:**
  - Los módulos de alto nivel simplemente no deberían depender de los módulos de bajo nivel de
    ninguna manera.
- **Entonces, cuando tienes una clase base y una clase derivada, tu clase base no debe conocer
  ninguna de sus clases derivadas.**
## Pregunta 35
- **Encuentra alguna excepción a esta sugerencia.**
## Pregunta 36
- **El constructor de la clase InterfazUsuario acepta un parámetro de base de datos.
  Proporciona una instalación adicional a un usuario cuando utiliza tanto el constructor como el
  método setter (setDatabase) dentro de esta clase. ¿Cuál es el beneficio?.**
