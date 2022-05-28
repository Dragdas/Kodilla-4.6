
import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.OrderHelper;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;


public class Main {

    public static void main(String[] args) {

        //MovieStore.challengeSolution();

        //AllegroSolutionRunner.runSolution();


        Order orderStakes = OrderHelper.generateSteakOrder();
        Order orderExtraFood = OrderHelper.generateExtraFoodOrder();
        Order orderHealthyPancakes = OrderHelper.generateHealthyShopOrder();
        Order orderGlutenFree = OrderHelper.generateGlutenFreeOrder();

        OrderHelper.executeOrderingProcess(orderStakes);
        OrderHelper.executeOrderingProcess(orderExtraFood);
        OrderHelper.executeOrderingProcess(orderHealthyPancakes);
        OrderHelper.executeOrderingProcess(orderGlutenFree);

    }



}
