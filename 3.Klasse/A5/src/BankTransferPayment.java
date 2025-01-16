public class BankTransferPayment implements IPaymentMethod{
    //methode aus interface klasse eingefügt
    @Override
    public void processPayment(double amount){
        System.out.println("Processing BankTransfer Payment of: "+ amount+"$");
    }
}
