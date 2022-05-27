import com.kodilla.good.patterns.challenges.allegro.*;
import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.product.NewYorkStrip;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.ProductDto;
import com.kodilla.good.patterns.challenges.food2door.product.Ribeye;
import com.kodilla.good.patterns.challenges.food2door.suppliers.FoodSupplier;
import com.kodilla.good.patterns.challenges.food2door.suppliers.SteakSupplier;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //MovieStore.challengeSolution();

        //AllegroSolutionRunner.runSolution();

        FoodSupplier supplier = new SteakSupplier();
        Order order = generateOrder(supplier);

        System.out.println( supplier.getStockInformation() );
        long orderId = supplier.process( order);
        System.out.println("Is order completed: " + supplier.isOrderCompleted(orderId));

    }

    private static Order generateOrder(FoodSupplier supplier) {
        return new Order(supplier, List.of(
                new ProductDto(new Ribeye(), 5),
                new ProductDto(new NewYorkStrip(), 2)
        ));
    }

}
