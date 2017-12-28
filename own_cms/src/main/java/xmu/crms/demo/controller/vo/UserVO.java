package xmu.crms.demo.controller.vo;

import java.math.BigInteger;

import xmu.crms.demo.entity.School;

public class UserVO {
    private BigInteger id;
    private String type;
    private String name;
    private String number;
    private String phone;
    private String email;
    private String gender;
    private School school;
    private String title;
    private String avatar;

    public UserVO(){}

    public UserVO(BigInteger id, String type, String name, String number, String phone, String email, String gender, School school, String title, String avatar) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.number = number;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.school = school;
        this.title = title;
        this.avatar = avatar;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", type=" + type + ", name=" + name + ", number=" + number + ", phone=" + phone
				+ ", email=" + email + ", gender=" + gender + ", school=" + school + ", title=" + title + ", avatar="
				+ avatar + "]";
	}
}
