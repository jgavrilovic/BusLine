package boj.zlica.busline.models;

import lombok.Data;


@Data
public class User {
    private Long user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
