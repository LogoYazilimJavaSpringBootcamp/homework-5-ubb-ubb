package com.movierec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userDetails")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @NotBlank
    private String username;


    @NotEmpty
    @Email
    private String mail;

    @Size(min = 8, max = 64, message = "Password must be 8-64 char long")
    private String password;

    @OneToMany
    private List<Movie> movieList;

    @Column
    private LocalDateTime subscriptionEndDate = LocalDateTime.now();

    @Column
    private Status status = Status.FREE;

    @Column
    private Integer remaining = 3;

}
