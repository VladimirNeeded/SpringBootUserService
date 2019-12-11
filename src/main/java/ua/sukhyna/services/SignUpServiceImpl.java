package ua.sukhyna.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.sukhyna.model.forms.UserForm;
import ua.sukhyna.model.Role;
import ua.sukhyna.model.State;
import ua.sukhyna.model.User;
import ua.sukhyna.repository.UserRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User userForSave = new User(userForm.getName(), userForm.getSurname(), userForm.getLogin(), hashPassword, Role.USER, State.ACTIVE);
        userRepository.save(userForSave);
    }
}
