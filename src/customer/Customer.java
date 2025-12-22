package customer;

public class Customer {
    private String customerName;    // 이름
    private String customerEmail;   // 이메일
    private String customerGrade;   // 등급 (예: 일반, VIP)

    // 생성자
    public Customer(String name, String email, String grade) {
        customerName = name;
        customerEmail = email;
        customerGrade = grade;
    }

    // getter 메서드들
    public String getName() {
        return customerName;
    }

    public String getEmail() {
        return customerEmail;
    }

    public String getGrade() {
        return customerGrade;
    }
}
