package product;

// Product` 클래스 생성하기
// 개별 상품을 관리하는 클래스입니다. 현재는 전자제품만 관리합니다.
// 클래스는 `상품명`, `가격`, `설명`, `재고수량` 필드를 갖습니다.
public class Product {
    // Step01-1 : main 함수에서 Product 클래스를 생성하여 상품 목록을 추가합니다.
    public String productName;
    public int price;
    public String description;
    public int stockQuantity;

    public Product(String productName, int price, String description, int stockQuantity) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }
}
