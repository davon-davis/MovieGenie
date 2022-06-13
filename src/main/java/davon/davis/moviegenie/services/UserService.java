package davon.davis.moviegenie.services;

import davon.davis.moviegenie.Users;
import davon.davis.moviegenie.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public Users addUser(String username) {
        return userRepository.save(new Users(username));
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> updateUserInterest(Long id, String newInterest) {
        Optional<Users> userToUpdate = userRepository.findById(id);

        if(userToUpdate.isPresent()) {
            userToUpdate.get().setInterest(newInterest);
            userRepository.save(userToUpdate.get());
            return userToUpdate;
        }
        return userToUpdate;
    }
}
