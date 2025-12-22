package utils;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;

import product.Product;

public class CommerceSystem {
    List<Product> products = new ArrayList<>();
    // products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
    // products.add(new Product("IPhone 16", 1350000, "Apple의 최신 스마트폰", 9));
    // products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8));
    // products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 7));
    // 생성자는 클래스 안에서 선언해야 함 <<< 주의! 아무생각 없이 옮기지 말기
    public CommerceSystem(){
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        products.add(new Product("IPhone 16", 1350000, "Apple의 최신 스마트폰", 9));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 8));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 7));
    }

    // 시작화면 : 입력과 반복문(출력)
    public void start(){
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
    }
}
