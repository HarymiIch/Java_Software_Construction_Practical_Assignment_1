import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Product> catalog = new ArrayList<>();
    private static List<Order> orderHistory = new ArrayList<>();

    public static void main(String[] args) {
        // --- 1. Наповнення каталогу ---
        Category electronics = new Category(1, "Електроніка");
        Category clothes = new Category(2, "Одяг");

        Product phone = new Product(101, "iPhone 14", 999.99, "Смартфон Apple", electronics);
        Product laptop = new Product(102, "MacBook Air", 1200.50, "Ноутбук Apple", electronics);
        Product tshirt = new Product(103, "Футболка", 25.00, "Бавовняна футболка", clothes);

        catalog.add(phone);
        catalog.add(laptop);
        catalog.add(tshirt);

        // --- 2. Робота з кошиком ---
        Cart cart = new Cart();
        cart.addProduct(phone);
        cart.addProduct(laptop);
        cart.addProduct(tshirt);

        System.out.println("Товарів у кошику спочатку: " + cart.getProducts().size());

        // Видалення товару
        cart.removeProduct(tshirt);
        System.out.println("Товарів у кошику після видалення: " + cart.getProducts().size());

        // --- 3. Оформлення замовлення та історія ---
        Order order1 = new Order(1, cart);
        orderHistory.add(order1);
        cart.clear();

        System.out.println("\nЗамовлення №" + order1.getOrderId() + " створено на суму: " + order1.getTotalPrice());

        // --- 4. Пошук товарів ---
        System.out.println("\n--- Результати пошуку 'iPhone' ---");
        List<Product> searchByName = searchByName("iPhone");
        for (Product p : searchByName) {
            System.out.println(p);
        }

        System.out.println("\n--- Результати пошуку за категорією 'Електроніка' ---");
        List<Product> searchByCategory = searchByCategory("Електроніка");
        for (Product p : searchByCategory) {
            System.out.println(p);
        }

        // --- 5. Історія замовлень ---
        System.out.println("\n--- Історія замовлень ---");
        for (Order order : orderHistory) {
            System.out.println("Замовлення №" + order.getOrderId() + ", Сума: " + order.getTotalPrice());
        }
    }

    public static List<Product> searchByName(String query) {
        List<Product> result = new ArrayList<>();
        for (Product product : catalog) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public static List<Product> searchByCategory(String categoryName) {
        List<Product> result = new ArrayList<>();
        for (Product product : catalog) {
            if (product.getCategory() != null &&
                    product.getCategory().getName().equalsIgnoreCase(categoryName)) {
                result.add(product);
            }
        }
        return result;
    }
}