import main.java.User;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 2:17 2021/5/23
 * @Desc:
 */
public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        // Test for setter
        user.setName("John");
        // Test for getter
        System.out.println(user.getName());
    }
}