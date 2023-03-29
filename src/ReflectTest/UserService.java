package ReflectTest;

public class UserService {
    public boolean login(String userName,String password){
        if("admin".equals(userName)&&"123".equals(password)){
            return true;
        }
        else
            return false;
    }
}
