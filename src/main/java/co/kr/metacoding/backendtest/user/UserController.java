package co.kr.metacoding.backendtest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserResponse.SaveDTO saveUser(@RequestBody UserRequest.SaveDTO saveDTO) {
        return userService.saveUser(saveDTO);
    }

    @GetMapping("/users/{id}")
    public UserResponse.GetDTO getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("/users/{id}")
    public UserResponse.UpdateDTO updateUser(@PathVariable Integer id, @RequestBody UserRequest.UpdateDTO updateDTO) {
        return userService.updateUser(id, updateDTO);
    }
}
