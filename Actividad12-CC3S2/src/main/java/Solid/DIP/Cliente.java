package Solid.DIP;


public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");

        // Usando Oracle
        Database database = new OracleDatabase();
        UserInterface userInterface = new UserInterface(database);
        userInterface.saveEmployeeId("E001");

        // Usando Mysql
        database = new MySQLDatabase();
        userInterface = new UserInterface(database);
        userInterface.saveEmployeeId("E002");

        // Cambiando la base de datos objetivo
        //usuario = new InterfazUsuario(new OracleDatabase());
        userInterface.setDatabase(new OracleDatabase());
        userInterface.saveEmployeeId("E002");


    }
}