package boj.zlica.busline.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

//TODO: izmeni naziv tabele
@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "uid", nullable = false, unique = true)
    private String uid;

    //zar ovo nije kako se kolona da se zove u bazi?
    @NotNull
    @Pattern(regexp = "^([A-Z])([a-z]+)$", message = "Format imena je pogresan")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^([A-Z])([a-z]+)$", message = "Format prezimena je pogresan")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Format emaila je pogresan")
    @Column(name = "email")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z][a-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Format passworda je pogresan")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity(){}


}

