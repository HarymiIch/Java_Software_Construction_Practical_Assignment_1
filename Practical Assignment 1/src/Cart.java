import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Product> products = new ArrayList<>();

    // Додавання товару
    public void addProduct(Product product) {
        this.products.add(product);
    }

    // Додайте можливість видалення товарів з кошика (за об'єктом)
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    // Видалення товару за його ID
    public void removeProductById(int productId) {
        this.products.removeIf(product -> product.getId() == productId);
    }

    // Очищення кошика після створення замовлення
    public void clear() {
        this.products.clear();
    }

    // Підрахунок загальної суми
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}