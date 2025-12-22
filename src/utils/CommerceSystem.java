package utils;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;

import product.Product;
import category.Category;

public class CommerceSystem {
    private Category category;

    // 시작화면 : 입력과 반복문(출력)
    public void start(){
        List<Product> products = category.getProducts();

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
