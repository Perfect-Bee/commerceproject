package customer;

public class Admin {

    // 수정불가
    private static final String PASSWORD = "admin123";

    // 비밀번호 검증
    public boolean authenticate(String inputPassword) {
        return PASSWORD.equals(inputPassword);
    }
}
