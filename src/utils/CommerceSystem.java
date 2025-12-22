package utils;

import category.Category;
import product.Product;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private final List<Category> categories;
    private final Scanner scanner = new Scanner(System.in);

    public CommerceSystem(List<Category> categories) {
        this.categories = categories; // 제품 종류(상위 개념)
    }

    public void start() {
        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");

            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
            if (input < 1 || input > categories.size()) continue; // 무시

            showCategory(categories.get(input - 1));
        }
    }

    // getter로 뺴온 상위 개념 이름 : category.getCategoryName()
    private void showCategory(Category category) {
        System.out.println("\n[ " + category.getCategoryName() + " 카테고리 ]");

        // 상위 개념 이름의 리스트를 products라 하자.(이름category.getCategoryName() 때고 내용물category.getProductsList())
        List<Product> products = category.getProductsList();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getProduct());
        }
        System.out.println("0. 뒤로가기");

        int input = scanner.nextInt();

        if (input == 0) return;
        if (input < 1 || input > products.size()) return;

        System.out.println("선택한 상품: " + products.get(input - 1).getStockQuantity());

    }
}
