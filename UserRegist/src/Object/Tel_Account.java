package Object;

public class Tel_Account {
	private String tel;
	private String username;
	public Tel_Account(String tel,String username){
		this.tel=tel;
		this.username=username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String account) {
		this.username = account;
	}
}
