public interface UserService{
    User registerUser(User user);
    User getUserById(Long id);
    User findByEmail(String email);
}