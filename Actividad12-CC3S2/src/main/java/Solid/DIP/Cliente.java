package Solid.DIP;


public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");

        // Usando Oracle
        BaseDatos database = new OracleDatabase();
        InterfazUsuario usuario = new InterfazUsuario(database);
        usuario.saveEmployeeId("E001");

        // Usando Mysql
        database = new MySQLDatabase();
        usuario = new InterfazUsuario(database);
        usuario.saveEmployeeId("E002");

        // Cambiando la base de datos objetivo
        //usuario = new InterfazUsuario(new OracleDatabase());
        usuario.setDatabase(new OracleDatabase());
        usuario.saveEmployeeId("E002");


    }
}