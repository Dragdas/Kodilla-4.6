import com.kodilla.good.patterns.challenges.*;
import com.kodilla.good.patterns.challenges.cartlogic.Cart;
import com.kodilla.good.patterns.challenges.cartlogic.CartEntry;
import com.kodilla.good.patterns.challenges.products.Game;
import com.kodilla.good.patterns.challenges.products.Kapcie;

public class Main {

    public static void main(String[] args) {

        //MovieStore.challengeSolution();

        ProductOrderService productOrderService = new ProductOrderService();
        Order order = generateOrder();

        productOrderService.executeOrder(order);


    }

    private static Order generateOrder() {

        Client client = new Client("Obi One");
        Cart cart = new Cart();
        cart.addCartEntry(new CartEntry(new Game("SW: KoTOR"), 1  ));
        cart.addCartEntry(new CartEntry(new Kapcie("Kapcie babuszki"), 2  ));

        DeliveryDetails deliveryDetails = new DeliveryDetails("Tatooine");

        return new Order(client, cart, deliveryDetails);
    }

}
