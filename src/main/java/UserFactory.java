package main.java;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 16:35 2021/5/22
 * @Desc: We use simple factory
 */
public class UserFactory {
    public static User createUser(String type) {
        if (type.equals("admin")) {
            return new Administrator();
        } else if (type.equals("director")) {
            return new Directors();
        } else {
            return new Staff();
        }
    }
}
