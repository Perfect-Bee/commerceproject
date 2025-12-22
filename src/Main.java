import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 단위 콤마
import java.text.NumberFormat;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    // Step01-1 : main 함수에서 Product 클래스를 생성하여 상품 목록을 추가합니다.
    public static class Product {
        public String productName;
        public int price;
        public String description;
        public int stockQuantity;

        // `Product` 객체 생성을 통해 `상품명`, `가격`, `설명`, `재고수량`을 세팅합니다.
        //  키워드: `new`
        public Product(String productName, int price, String description, int stockQuantity) {
            this.productName = productName;
            this.price = price;
            this.description = description;
            this.stockQuantity = stockQuantity;
        }
    }
    public static void main(String[] args) {
        // Step01-2 : List를 선언하여 여러 Product을 추가합니다.
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        products.add(new Product("IPhone 16", 1350000, "Apple의 최신 스마트폰", 10));

        // NumberFormat을 활용한 포맷 형식 선언
        NumberFormat nf = NumberFormat.getInstance();
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            // 테스트 변수에 포맷 형식 적용하여 출력(String)
            String productcomma = nf.format(p.price);
            System.out.println(i+1 + ". " + p.productName + " | " + productcomma + " | " + p.description + " | ");
        }
        System.out.println("0. 종료 | 프로그램 종료");

        // 입력
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == 0) {
            System.out.println("커머스 플랫폼을 종료합니다.");
        } else {
            System.out.println("선택한 번호: " + input);
        }

        scanner.close();
    }
}