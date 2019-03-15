package com.bookstore.entities;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Nickname cannot be blank!")
    @Size(min=4, max=20, message = "Nickname size has to be in range <4,20>")
    @Column(name = "nickname")
    private String nickname;

    @NotNull(message = "Full name cannot be blank!")
    @Size(min=5, max=35, message = "Full name size has to be in range <5,35>")
    @Column(name = "fullname")
    private String fullUserName;

    @NotNull(message = "Nationality cannot be null!")
    @NotEmpty(message = "Photo URL cannot be blank!")
    @Column(name = "nationality")
    private String nationality;

    @NotNull(message = "Email cannot be blank!")
    @Email(message = "Email has wrong format")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Mobile number cannot be blank!")
    @Pattern(regexp="(^$|[0-9]{9})", message = "Mobile needs to contain exactly 9 digits")
    @Column(name = "mobile")
    private String mobile;

    private String formatted_mobile;

    @NotNull(message = "Age cannot be blank!")
    @Min(value = 1, message = "Minimum age is 1")
    @Column(name = "age")
    private int age;

    @NotNull(message = "Gender cannot be blank!")
    @Pattern(regexp = "male|female", message = "Two values are acceptable \'male\' or \'female\'")
    @Column(name = "sex")
    private String sex;

    @NotNull(message = "Photo URL cannot be null!")
    @NotEmpty(message = "Photo URL cannot be blank!")
    @URL(message = "Wrong URL format")
    @Column(name = "photo")
    private String photo;

    public User() {
    }

    public String getFormatted_mobile() {
        return formatted_mobile;
    }

    public void setFormatted_mobile(String formatted_mobile) {
        this.formatted_mobile = formatted_mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullUserName() {
        return fullUserName;
    }

    public void setFullUserName(String fullUserName) {
        this.fullUserName = fullUserName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String insertHyphens(String castedMobile) {
        return (castedMobile.substring(0, 3) + "-" + castedMobile.substring(3, 6) + "-" + castedMobile.substring(6));
    }

    public void formatMobileNumber() {
        this.setFormatted_mobile(insertHyphens(this.mobile));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", fullUserName='" + fullUserName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", formatted_mobile='" + formatted_mobile + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
