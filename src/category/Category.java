package category;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final String categoryName;
    private final List<Product> products;

    // 상위 개념, product
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }

    // 상품 추가
    public void addProduct(Product product) {
        products.add(product);
    }

    // 카테고리 이름 반환
    public String getCategoryName() {
        return categoryName;
    }

    // 상품 리스트 반환
    public List<Product> getProductsList() {
        return products;
    }
}
