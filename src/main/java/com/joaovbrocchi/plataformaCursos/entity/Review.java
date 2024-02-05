package com.joaovbrocchi.plataformaCursos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="comment")
    private String comment;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name= "course_id")
    private Course course;
    public Review(){};
    public Review(String comment) {
        this.comment = comment;
    }


}
