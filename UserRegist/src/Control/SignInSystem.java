package Control;

import DAO.AccountInfoDAO;
import DAO.Account_TelDAO;
import DAO.PersonInfoDAO;
import Object.Account;
import Object.Person;
import Object.Tel_Account;

public class SignInSystem {
	private Account account;
	private Person person;
	private Account_TelDAO atDAO=new Account_TelDAO();
	private AccountInfoDAO aiDAO=new AccountInfoDAO();
	private PersonInfoDAO piDAO=new PersonInfoDAO();
	
	public Person getPersonByPhone(String phone){
		
		return piDAO.getPersonByPhone(phone);
	}
	
	public String getPhoneByUserName(String name){
		return atDAO.getTelByAccount(name);
	}
	
	public void savaAccountInfo(Account acc){
		if(!usernameIsExite(acc.getUsername())){
			aiDAO.createAccount(acc);
		}else{
			System.out.println("账号存在");
		}
		
	}
	public Boolean usernameIsExite(String name){
		if(aiDAO.getAccountByName(name)!=null){
			System.out.println("usernameIsExite："+aiDAO.getAccountByName(name).getUsername()+aiDAO.getAccountByName(name).getKey());
			return true;
		}else {
			System.out.println("usernameIsExite：null");
			return false;
		}
	}
	public void savaPersontInfo(Person per){
		if(!telIsExite(per.getPhone())){
			piDAO.createPerson(per);
		}else{
			System.out.println("用户存在");
		}
		
	}
	public Boolean telIsExite(String tel){
		if(piDAO.getPersonByPhone(tel)!=null){
			System.out.println("telIsExite：not null");
			return true;
		}else  {
			System.out.println("telIsExite：null");
			return false;
		}
	}
	public void saveTelPersonInfo(Tel_Account ta){
		atDAO.createTelAccount(ta);
	}
	
	public Boolean saveAccount(Account acc,Person per){
		Tel_Account mid=new Tel_Account(per.getPhone(),acc.getUsername());
		
		if(!usernameIsExite(acc.getUsername())&&!telIsExite(per.getPhone())){
			System.out.println("savaAccount:"+per.getPhone()+"name:"+acc.getUsername());
			
			savaPersontInfo(per);
			savaAccountInfo(acc);
			saveTelPersonInfo(mid);
			return true;
		}else return false;
	}
	public Boolean signIn(Account acc){
		if(usernameIsExite(acc.getUsername())){
			if(acc.getKey().equals((aiDAO.getAccountByName(acc.getUsername()).getKey()))){
				System.out.println(aiDAO.getAccountByName(acc.getUsername()).getUsername());
				return true;
			}else {
				System.out.println("erro1");
				return false;
			}
		}else{
			System.out.println("erro2");
			return false;
		}
	}
}
