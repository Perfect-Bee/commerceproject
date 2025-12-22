package category;

import product.Product;

import java.util.ArrayList;
import java.util.List;

// Product 클래스를 관리함
// CommerceSystem 자료 -> Category로 이동
public class Category {
    List<Product> products = new ArrayList<>();
    public Category(){
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        products.add(new Product("IPhone 16", 1350000, "Apple의 최신 스마트폰", 9));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 7));
    }

    // getter 설정 : 외부에서 getProducts()로 products : 전자제품 꺼내쓸 수 있음
    public List<Product> getProducts() {
        return products;
    }
}
