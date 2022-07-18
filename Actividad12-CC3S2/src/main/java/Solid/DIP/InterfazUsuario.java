package Solid.DIP;
class InterfazUsuario {

    BaseDatos database;

    public InterfazUsuario(BaseDatos database) {
        this.database = database;
    }

    public void setDatabase(BaseDatos database) {
        this.database = database;
    }

    public void saveEmployeeId(String empId) {
        database.saveEmpIdInDatabase(empId);
    }
}