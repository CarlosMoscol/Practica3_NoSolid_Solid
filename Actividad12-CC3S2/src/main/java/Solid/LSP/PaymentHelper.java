package Solid.LSP;

import java.util.ArrayList;
import java.util.List;

public class PaymentHelper {
    //A diferencia del código en la carpeta NoSolid aquí se implementa las interfaces PreviousPayment
    //y NewPayment de esta manera se reutiliza el código para cada caso que se necesita extendiendo
    //la utilidad del código inicial.
    List<PreviousPayment> previousPayments = new ArrayList<PreviousPayment>();
    List<NewPayment> newPayments = new ArrayList<NewPayment>();
    public void addPreviousPayment(PreviousPayment previousPayment){
        previousPayments.add(previousPayment);
    }

    public void addNewPayment(NewPayment newPaymentRequest){
        newPayments.add(newPaymentRequest);
    }
    public void showPreviousPayments() {
        for (PreviousPayment payment: previousPayments) {
            payment.previousPaymentInfo();
            System.out.println("------------");
        }
    }
    public void processNewPayments() {
        for (NewPayment payment: newPayments) {
            payment.newPayment();
            System.out.println("+++++++++++++");
        }
    }
}
