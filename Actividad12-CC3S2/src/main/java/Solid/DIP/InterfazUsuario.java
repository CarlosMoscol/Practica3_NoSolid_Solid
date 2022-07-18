package Solid.DIP;
class InterfazUsuario {
    @Override
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("The id: " + empId + " is saved in the MySQL database.");
    }
}