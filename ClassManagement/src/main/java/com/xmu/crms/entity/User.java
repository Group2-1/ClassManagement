package com.xmu.crms.entity;

/**
 * user
 * @author lingyun
 *
 */
public class User {
	
	private Integer id;
	
	private String type;
	
	private String number;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private Gender gender;
	
	private School school;
	
	private String title;
	
	private String password;
	
	private String unionId;
	
	private String avatar;


    public enum Gender{

        UNKNOWN(0, "unknown"),
        MALE(1, "male"),
        FEMALE(2, "female");

        private int value;

        private String description;

        Gender(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return this.description;
        }
        
    }
	
	public User(Integer id, String name) {
		this.id = id;
		this.type = null;
		this.name = name;
		this.number = null;
		this.phone = null;
		this.email = null;
		this.gender = null;
		this.password = null;
		this.school = null;
		this.title = null;
		this.unionId = null;
		this.avatar = null;
		
	}

	public User(Integer id, String number, String name) {
		this.id = id;
		this.type = null;
		this.name = name;
		this.number = number;
		this.phone = null;
		this.email = null;
		this.gender = null;
		this.password = null;
		this.school = null;
		this.title = null;
		this.unionId = null;
		this.avatar = null;
		
	}


	public User(int id, String type, String number, String name, String phone, String email, String avatar,
			Gender gender, School school){
		this.id = id;
		this.type = type;
		this.name = name;
		this.number = number;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.password = null;
		this.school = school;
		this.title = null;
		this.unionId = null;
		this.avatar = avatar;
		
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
