import utils.CommerceSystem;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        CommerceSystem system = new CommerceSystem();
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