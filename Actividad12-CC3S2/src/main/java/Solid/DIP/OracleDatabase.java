package Solid.DIP;

class OracleDatabase implements BaseDatos {
    @Override
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("The id: " + empId + " is saved in the Oracle database.");
    }
}