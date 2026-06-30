public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPal());

        PaymentProcessor stripe =
                new StripeAdapter(new Stripe());

        paypal.processPayment(2500);

        stripe.processPayment(4500);
    }
}