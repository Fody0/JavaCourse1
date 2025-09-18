package Auth;

import java.util.List;

public class RegAuth {
    List<MyUser> users;

    public RegAuth(List<MyUser> users) {
        this.users = users;
    }

    public boolean Register(MyUser user) {
        users.add(user);

        Serializer.saveUsers(users, "C:\\Users\\user\\Documents\\JavaCourse\\Java_1\\src\\Auth\\DBDTO.json");

        return true;
    }

    public boolean Login(MyUser user) {
        for (int i = 0; i < users.size(); i++) {
            if(user.login.equals(users.get(i).login)){
                return true;
            }
        }
        return false;
    }
}
