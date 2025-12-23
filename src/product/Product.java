package product;

public class Product {
    private final String productName;
    private final int price;
    private final String description;
    private int stockQuantity;

    public Product(String productName, int price, String description, int stockQuantity) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }

    // 이름
    public String getProductName(){
        return productName;
    }
    // 가격
    public int getPrice() {
        return price;
    }
    // 설명(이건 쓸 일이 있나)
    public String getDescription(){
        return description;
    }
    // 재고
    public int getstockQuantity(){
        return stockQuantity;
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

    // 재고 확인
    public boolean isOutOfStock() {
        return stockQuantity <= 0;
    }

    // 재고 감소 (주문 확정 시)
    public void decreaseStock(int quantity) {
        if (stockQuantity < quantity) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        stockQuantity -= quantity;
    }
}