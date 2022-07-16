package NoSolid.ISP;

interface Fax {
    void faxType();
}

class LanFax implements Fax {
    @Override
    public void faxType() {
        System.out.println("Usando LanFax para el envio.");

    }
}

class EFax implements Fax {
    @Override
    public void faxType() {
        System.out.println("Usando EFax para el envio.");
    }
}
