package pet.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.petshop.entity.User;
import pet.petshop.repository.UserRepository;

@Service
@Transactional
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User ur) {
        userRepository.save(ur);
    }

    public User get(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllByEmailContain(String email) {
        return userRepository.findAllByEmailContaining(email);
    }

}
