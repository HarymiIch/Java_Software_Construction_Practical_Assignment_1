import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private List<Product> products;
    private double totalPrice;

    // Конструктор, який створює замовлення з кошика
    public Order(int orderId, Cart cart) {
        this.orderId = orderId;
        // Робимо копію списку товарів з кошика
        this.products = new ArrayList<>(cart.getProducts());
        this.totalPrice = cart.getTotalPrice();
    }
}