package ua.sukhyna.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.sukhyna.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        if (userRepository.findUserByLogin(login).isPresent()){
//            return new UserDetailsImpl(userRepository.findUserByLogin(login).get());
//        } throw new IllegalArgumentException("User not found");
//    }
        return new
                UserDetailsImpl(userRepository.findUserByLogin(login)
                .orElseThrow(IllegalArgumentException::new));
    }
}
