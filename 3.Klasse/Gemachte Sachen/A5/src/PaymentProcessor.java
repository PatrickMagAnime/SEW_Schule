public class PaymentProcessor {
    //methode erstellt die eine andere methode aufruft und einen wert will
    //das wird später für die ausgabe wichtig, siehe main
    public void process(IPaymentMethod paymentMethod, double amount) {
        paymentMethod.processPayment(amount);
}
}
