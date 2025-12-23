package customer;

import product.Product;

import java.util.List;
import java.util.ArrayList;
// 장바구니
public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    // 바구니 빈거 확인
    public boolean isEmpty() {
        return products.isEmpty();
    }

    // 상품 추가 매서드
    public void addProduct(Product product) {
        products.add(product);
    }

    // 상품 총 금액 계산 매서드
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // 결제 후 장바구니 비우기
    public void clear() {
        products.clear();
    }

    // 장바구니 상품 조회 (읽기 전용)
    public List<Product> getProducts() {
        return products;
    }

}
