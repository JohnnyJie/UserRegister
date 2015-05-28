package Object;

public class Person {
	private String name;
	private String id;
	private String email;
	private String phone;
	private String sex;
	public Person(String name,String id,String phone,String sex,String email){
		this.name=name;
		this.id=id;
		this.phone=phone;
		this.sex=sex;
		this.email=email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
