package Service;

import Repo.UserRepository;
import com.scaler.bookmyshow.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password, String name){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        Optional<User> userOptional = userRepository.findByEmail(email);
        if( userOptional.isPresent() ){
            throw new RuntimeException("User already exist with this email"+email);
        }
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(encryptedPassword);
        return userRepository.save(u);
    }

    public User login(String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if( userOptional.isEmpty() ){
            throw new RuntimeException("User does exist with this email"+email);
        }
        User u = userOptional.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if( bCryptPasswordEncoder.matches(password, u.getPassword()) ){
            return u;
        }
        throw new RuntimeException("Password is invalid");
    }

}
