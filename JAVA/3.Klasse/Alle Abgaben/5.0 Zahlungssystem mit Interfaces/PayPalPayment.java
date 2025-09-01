public class PayPalPayment implements IPaymentMethod{
    //methode aus interface klasse eingefügt
    @Override
   public void processPayment(double amount){
        System.out.println("Processing PayPal Payment of: "+ amount+"$");
    }
}
