package Auth;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Serializer {


    public static void saveUsers(List<MyUser> users, String filename) {
        Properties props = new Properties();

        for (int i = 0; i < users.size(); i++) {
            MyUser user = users.get(i);
            props.setProperty("user." + i + ".login", user.login);
            props.setProperty("user." + i + ".password", user.password);
        }

        try (OutputStream output = new FileOutputStream(filename)) {
            props.store(output, "Users data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MyUser> loadUsers(String filename) {
        List<MyUser> users = new ArrayList<>();
        Properties props = new Properties();

        try (InputStream input = new FileInputStream(filename)) {
            props.load(input);

            int i = 0;
            while (props.containsKey("user." + i + ".login")) {
                MyUser user = new MyUser();
                user.login = props.getProperty("user." + i + ".login");
                user.password = props.getProperty("user." + i + ".password");
                users.add(user);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

}
