package com.bookstore.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "fullname")
    private String fullUserName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "email")
    private String email;

    /*might consider adding helper field that make
   string of mobile in format like xxx-xxx-xxx,
   or it might be done on the fly */
    @Column(name = "mobile")
    private int mobile;

    private String formatted_mobile;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

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

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
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
        String castedMobile = Integer.toString(this.mobile);
        this.setFormatted_mobile(insertHyphens(castedMobile));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", fullUserName='" + fullUserName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", formatted_mobile='" + formatted_mobile + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
