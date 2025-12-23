package utils;

import category.Category;
import customer.ShoppingCart;
import product.Product;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private final List<Category> categories;
    private final Scanner scanner = new Scanner(System.in);
    private final ShoppingCart shoppingCart;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories; // 제품 종류(상위 개념)
        this.shoppingCart = new ShoppingCart(); // 장바구니 생성
    }

    public void start() {
        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");

            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            if (!shoppingCart.isEmpty()){showShoppingCart();}


            int input = scanner.nextInt();

            // 0. 종료 아래 : 장바구니 비어있으면 안보여주고.
            // 뭐 있으면 출력

            if (input == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            // 장바구니 확인
            if (!shoppingCart.isEmpty() && input == categories.size() + 1) {
                showShoppingCartDetail();
                continue;
            }

            // 주문 취소
            if (!shoppingCart.isEmpty() && input == categories.size() + 2) {
                shoppingCart.clear();
                System.out.println("주문이 취소되었습니다.");
                continue;
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

        Product selectedProduct = products.get(input - 1);

        // 상품 출력
        System.out.println("선택한 상품:");
        System.out.println(selectedProduct.getStockQuantity());

        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인    2. 취소");

        int choice = scanner.nextInt();

        if (choice == 1) {
            shoppingCart.addProduct(selectedProduct);
            System.out.println(selectedProduct.getProductName() + "가 장바구니에 추가되었습니다.");
        }
    }
    // 추가된 상품 확인
    // 장바구니가 비어있지 않으면(ShoppingCart.isEmpty) 출력
    public void showShoppingCart() {
//        if (shoppingCart.isEmpty()) {
//            System.out.println("장바구니가 비어 있습니다.");
//            return;
//        }
        System.out.println("[ 주문 관리 ]");
        System.out.println((categories.size()+1) + ". 장바구니 확인  | 장바구니를 확인한 후 종료합니다.");
        System.out.println((categories.size()+2) + ". 주문 취소      | 진행중인 주문을 취소합니다.");
    }

    // showShoppingCart에서 장바구니 확인 누르면 나옴
    private void showShoppingCartDetail() {
        System.out.println("\n[ 장바구니 내역 ]");

        List<Product> cartProducts = shoppingCart.getProducts();
        for (int i = 0; i < cartProducts.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + cartProducts.get(i).getProduct()
            );
        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.printf("%,d원\n", shoppingCart.getTotalPrice());
    }
}
