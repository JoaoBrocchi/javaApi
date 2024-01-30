package com.joaovbrocchi.crudDemo.entity;

import jakarta.persistence.*;
import org.springframework.orm.jpa.vendor.Database;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtube_channel;

    @Column(name = "hobby")
    private String hobby;
    @OneToOne(mappedBy = "InstructorDetail",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    InstructorDetail(){};

    public InstructorDetail(String youtube_channel, String hobby) {

        this.youtube_channel = youtube_channel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube_chanel() {
        return youtube_channel;
    }

    public void setYoutube_chanel(String youtube_chanel) {
        this.youtube_channel = youtube_chanel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtube_chanel='" + youtube_channel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
