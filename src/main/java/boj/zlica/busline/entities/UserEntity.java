package boj.zlica.busline.entities;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "uid", nullable = false, unique = true)
    private String uid;

    //zar ovo nije kako se kolona da se zove u bazi?
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserEntity(){}


}

