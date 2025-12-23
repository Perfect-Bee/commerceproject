package utils;

import category.Category;
import customer.ShoppingCart;
import product.Product;
// 관리자
import customer.Admin;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private final List<Category> categories;
    private final Scanner scanner = new Scanner(System.in);
    private final ShoppingCart shoppingCart;
    private final Admin admin = new Admin();


    public CommerceSystem(List<Category> categories) {
        this.categories = categories; // 제품 종류(상위 개념)
        this.shoppingCart = new ShoppingCart(); // 장바구니 생성
    }

    // 메인화면
    public void start() {
        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");

            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
            }

            System.out.println("0. 종료");
            // 값을 유동성 있게 하고 싶은데, 그러면 주문관리랑 겹침.
            System.out.println("6. 관리자 모드");

            if (!shoppingCart.isEmpty()){showShoppingCart();}


            int input = scanner.nextInt();

            if (input == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            // 관리자 모드
            if (input == 6) {
                enterAdminMode();
                continue;
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
    // 카테고리 + 주문내역
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
            if (selectedProduct.isOutOfStock()) {
                System.out.println("재고가 부족하여 장바구니에 담을 수 없습니다.");
                return;
            }

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
        
        // 결제란
        System.out.println("1. 주문 확정    2. 메인으로 돌아가기");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            completeOrder();
        }
    }

    private void completeOrder() {
        List<Product> cartProducts = shoppingCart.getProducts();

        for (Product product : cartProducts) {
            product.decreaseStock(1); // 🔥 여기서 재고 감소
        }

        int totalPrice = shoppingCart.getTotalPrice();
        shoppingCart.clear();

        System.out.println("주문이 완료되었습니다!");
        System.out.printf("총 금액: %,d원\n", totalPrice);
    }

    // 관리자 관련 로직
    // 관리자 비밀번호 체크 : enterAdminMode
    private void enterAdminMode() {
        // 비번 실패 제한
        int attempts = 0;
        // 3회
        while (attempts < 3) {
            System.out.print("관리자 비밀번호를 입력해주세요: ");
            String inputPassword = scanner.next();

            // 비밀번호 검증
            if (admin.authenticate(inputPassword)) {
                System.out.println("관리자 인증 성공!");
                adminMenu();
                return;
            } else {
                attempts++;
                System.out.println("비밀번호가 틀렸습니다. (" + attempts + "/3)");
            }
        }

        System.out.println("비밀번호 입력 3회 실패. 메인 메뉴로 돌아갑니다.");
    }

    // 관리자 메뉴 출력
    private void adminMenu() {
        while (true) {
            // 이건 for 필요 없음. 고정 매뉴:)
            System.out.println("\n[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("4. 전체 상품 현황");
            System.out.println("0. 메인으로 돌아가기");

            int input = scanner.nextInt();

            if (input == 0) {
                return;
            }

            // 숫자에 맞는 기능 추가

        }
    }
}
