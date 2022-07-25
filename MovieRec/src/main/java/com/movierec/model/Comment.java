package com.movierec.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;


    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
