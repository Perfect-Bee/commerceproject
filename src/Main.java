import java.util.ArrayList;
import java.util.List;

import category.Category;
import product.Product;
import utils.CommerceSystem;

public class Main {
    public static void main(String[] args) {
        // 상위 : Category
        // 전자제품
        Category electronics = new Category("전자제품");
        electronics.addProduct(new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 10));
        electronics.addProduct(new Product("iPhone 15", 1350000, "Apple의 최신 스마트폰", 9));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋 노트북", 8));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 이어폰", 7));

        // 음료
        Category drinks = new Category("음료");
        drinks.addProduct(new Product("Cola", 2000, "북극곰이 좋아함", 6));
        drinks.addProduct(new Product("게토레이", 3000, "맛있음", 5));

        // 의류
        Category clothes = new Category("의류");
        clothes.addProduct(new Product("GUCCI", 45000, "비쌈", 4));
        clothes.addProduct(new Product("NIKE", 60000, "브이", 0));

        List<Category> categories = new ArrayList<>();
        categories.add(electronics);
        categories.add(drinks);
        categories.add(clothes);

        CommerceSystem system = new CommerceSystem(categories);
        system.start();
    }
}