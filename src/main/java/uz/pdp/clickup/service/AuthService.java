package uz.pdp.clickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.clickup.entity.User;
import uz.pdp.clickup.entity.enums.SystemRoleName;
import uz.pdp.clickup.payload.ApiResponse;
import uz.pdp.clickup.payload.RegisterDTO;
import uz.pdp.clickup.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public ApiResponse registerUser(RegisterDTO registerDTO) {
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            return new ApiResponse("Bunday User mavjud", false);
        }
        User user  = new User(
                registerDTO.getFullName(),
                registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()),
                SystemRoleName.SYSTEM_USER
        );
        userRepository.save(user);
        return null;
    }

}
