
package NoSolid.ISP;

class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion sin ISP");

        Impresora impresora = new ImpresoraAvanzada();
        impresora.printDocument();

        impresora = new ImpresoraBasica();
        impresora.printDocument();

        DispositivoFax faxDevice = new ImpresoraAvanzada();
        faxDevice.sendFax();
    }

}
