public class CreditCardPayment implements IPaymentMethod {
    //methode aus interface klasse eingefügt
    @Override
    public void processPayment(double amount){
        System.out.println("Processing CreditCard Payment of: "+ amount+"$");
    }
}
