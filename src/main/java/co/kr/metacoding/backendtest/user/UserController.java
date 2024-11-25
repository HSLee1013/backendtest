package co.kr.metacoding.backendtest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserResponse.SaveDTO saveUser(@Valid @RequestBody UserRequest.SaveDTO saveDTO, Errors errors) {
        return userService.saveUser(saveDTO);
    }

    @GetMapping("/users/{id}")
    public UserResponse.GetDTO getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("/users/{id}")
    public UserResponse.UpdateDTO updateUser(@PathVariable Integer id, @Valid @RequestBody UserRequest.UpdateDTO updateDTO, Errors errors) {
        return userService.updateUser(id, updateDTO);
    }
}
