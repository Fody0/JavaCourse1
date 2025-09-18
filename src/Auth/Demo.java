package Auth;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("You want to login(1) or register(2), input a number");

        Scanner sc = new Scanner(System.in);

        var users = Serializer.loadUsers("C:\\Users\\user\\Documents\\JavaCourse\\Java_1\\src\\Auth\\DBDTO.json");

        RegAuth reg_auth = new RegAuth(users);

        int num = sc.nextInt();

        if (num == 1 || num == 2) {
            System.out.println("Input your login:");
            var login = sc.next();
            System.out.println("Input your password:");
            var password = sc.next();
            MyUser user = new MyUser();
            user.login = login;
            user.password = password;
            sc.close();
            if (num == 1) {
                sc.close();
                if (reg_auth.Login(user)) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed");
                }
            } else if (num == 2) {
                user.login = login;
                user.password = password;
                if (reg_auth.Register(user)) {
                    System.out.println("Register Successful");
                } else {
                    System.out.println("Register Failed");
                }
            }
        }
        else {
            System.out.println("Wrong number");
        }

        sc.close();
    }
}
