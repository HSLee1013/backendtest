package co.kr.metacoding.backendtest.user;

import lombok.Data;

public class UserResponse {
    @Data
    public static class SaveDTO {
        private Integer id;

        public SaveDTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class GetDTO {
        private Integer id;
        private String name;

        public GetDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private String name;

        public UpdateDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}
