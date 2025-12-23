package product;

public class Product {
    private String productName;
    private int price;
    private String description;
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
    public void setPrice(int price) {
        this.price = price;
    }

    // set 추가
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // 재고
    public int getstockQuantity(){
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
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