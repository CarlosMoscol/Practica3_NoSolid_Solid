package Solid.SRP;

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