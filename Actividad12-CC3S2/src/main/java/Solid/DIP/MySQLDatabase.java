package Solid.DIP;


class MySQLDatabase implements BaseDatos {
    @Override
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("The id: " + empId + " is saved in the MySQL database.");
    }

}
