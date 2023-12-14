import java.util.List;

public interface SubjectInterface {
    void addUser(String password, String user, String filePath);
    List<List<String>> getUsers(String filePath);
    boolean approveUser(String username, String password, String filepath);
    void editUser(String oldPassword, String oldUser, String newPassword, String newUser, String filePath);
}
