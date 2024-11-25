package co.kr.metacoding.backendtest.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class UserRequest {

    @Data
    public static class SaveDTO {
        @NotBlank
        private String name;

        public User toEntity() {
            return new User(null, name);
        }
    }

    @Data
    public static class UpdateDTO {
        @NotBlank
        private String name;
    }
}
