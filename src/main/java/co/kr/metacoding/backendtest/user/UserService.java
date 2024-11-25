package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse.SaveDTO saveUser(UserRequest.SaveDTO saveDTO) {
        User user = saveDTO.toEntity();
        userRepository.insert(user);
        return new UserResponse.SaveDTO(user);
    }

    public UserResponse.GetDTO getUser(Integer id) {
        User user = userRepository.findById(id);
        return new UserResponse.GetDTO(user);
    }

    @Transactional
    public UserResponse.UpdateDTO updateUser(Integer id, UserRequest.UpdateDTO updateDTO) {
        User user = userRepository.findById(id);
        user.setName(updateDTO.getName());
        return new UserResponse.UpdateDTO(user);
    }
}
