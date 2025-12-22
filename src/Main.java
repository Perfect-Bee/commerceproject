import java.util.Scanner;

import utils.CommerceSystem;
import category.Category;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        // Category 타입의 변수 category 생성 : category로 Category 생성자 실행 가능
        // Category.java에서 products가 채워짐
        Category category = new Category();

        // CommerceSystem 타입의 변수 system 생성
        // category 객체를 매개변수로 전달
        // system으로 commerceSystem(Category 타입의 변수 category) 생성자 실행됨
        CommerceSystem system = new CommerceSystem(category);
        system.start();

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