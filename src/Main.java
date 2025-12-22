import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 단위 콤마
import java.text.NumberFormat;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        // Step01-2 : main 함수에서 Product 클래스를 생성하여 상품 목록을 추가합니다.
        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        products.add(new Product("IPhone 16", 1350000, "Apple의 최신 스마트폰", 9));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 7));

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        // NumberFormat을 활용한 포맷 형식 선언
        NumberFormat nf = NumberFormat.getInstance();

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);

            // 테스트 변수에 포맷 형식 적용하여 출력(String)
            String productPriceComma = nf.format(p.price);

            // System.out.println(i+1 + ". " + p.productName + " | " + productcomma + " | " + p.description + " | " + p.stockQuantity + " | ");
            // printf(정수(%d). 15칸 중 왼쪽 정렬(-15)String(%s) | 10칸 중 오른쪽 정렬(10)String(%s)원 | 글자(String)
            System.out.printf(
                    "%d. %-15s | %10s원 | %s\n",
                    i + 1,
                    p.productName,
                    productPriceComma,
                    p.description
            );
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