
import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.OrderHelper;
import com.kodilla.good.patterns.challenges.food2door.product.ExtraPopcorn;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.services.ServicesDto;


public class Main {

    public static void main(String[] args) {


        Product p1 = new ExtraPopcorn();
        Product p2 = p1;

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.equals(p2));


    }



}
