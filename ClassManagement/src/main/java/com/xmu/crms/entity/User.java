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
            this.setValue(value);
            this.description = description;
        }

        @Override
        public String toString() {
            return this.description;
        }

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
        
    }
	

	public User(Integer id, String type, String number, String name, String phone, String email, Gender gender,
			School school, String title, String password, String unionId, String avatar) {
		super();
		this.id = id;
		this.type = type;
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.school = school;
		this.title = title;
		this.password = password;
		this.unionId = unionId;
		this.avatar = avatar;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String type, String number, String name) {
	this.id = id;
	this.type = type;
	this.number = number;
	this.name = name;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
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
