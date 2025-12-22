package product;

public class Product {
    private final String productName;
    private final int price;
    private final String description;
    private final int stockQuantity;

    public Product(String productName, int price, String description, int stockQuantity) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }

    public String getProduct() {
        return String.format(
                "%-15s | %,8d원 | %s",
                productName,
                price,
                description
        );
    }

    // 재고량 포함
    public String getStockQuantity() {
        return String.format(
                "%-15s | %,8d원 | %s | 재고: %d개",
                productName,
                price,
                description,
                stockQuantity
        );
    }
}