package Control;
import java.util.ArrayList;
import DAO.*;
import Object.*;
import java.io.*; 
public class AdaminSystem {
	private Account_TelDAO atDAO=new Account_TelDAO();
	private AccountInfoDAO aiDAO=new AccountInfoDAO();
	private PersonInfoDAO piDAO=new PersonInfoDAO();
	String url ="psd.txt";
	private String getPsd;
	public Boolean login(String psd){
		getPsd = null;
		 try {
             String encoding="GBK";
             File file=new File(url);
             if(file.isFile() && file.exists()){ 
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String line;
                 while((line = bufferedReader.readLine()) != null){
                     System.out.println(line+"!!");
                     getPsd=line;
                 }
                 read.close();
                 if(getPsd.equals(psd)) return true;
             }else{
            	 System.out.println("找不到指定的文件");
             }
		 } catch (Exception e) {
			 System.out.println("读取文件内容出错");
			 e.printStackTrace();
		 }


		return false;
	}
	public ArrayList<Tel_Account> getTelAccount(){
		return atDAO.getAccount_TelList();
	}
	
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> personList=new ArrayList<Person>();
		ArrayList<Tel_Account> list=getTelAccount();
		for(int i=0;i<list.size();i++){
			personList.add(piDAO.getPersonByPhone(list.get(i).getTel()));
		}
		return personList;
	}
	
	public ArrayList<Account> getAccountList(){
		ArrayList<Account> accountList=new ArrayList<Account>();
		ArrayList<Tel_Account> list=getTelAccount();
		for(int i=0;i<list.size();i++){
			accountList.add(aiDAO.getAccountByName(list.get(i).getUsername()));
		}
		return accountList;
	}
	
	public String[][] getAllInf(){
		ArrayList<Tel_Account> list=new ArrayList<Tel_Account>();
		String username;
		String phone;
		Person person;
		Account account;
		list=getTelAccount();
		String[][] o=new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			username=list.get(i).getUsername();
			phone=list.get(i).getTel();
			System.out.println("username:"+username+"phone:"+phone+"i"+i);
			account=aiDAO.getAccountByName(username);
			person=piDAO.getPersonByPhone(phone);
			System.out.println("account:"+account.getKey()+"//"+account.getUsername());
			System.out.println("person:"+person.getName()+"//:"+person.getEmail()+"//"+person.getPhone());
			o[i][0]=account.getUsername();
			o[i][1]=account.getKey();
			o[i][2]=person.getName();
			o[i][3]=person.getId();
			o[i][4]=person.getSex();
			o[i][5]=person.getPhone();
			o[i][6]=person.getEmail();
			
		}
		return o;
	}

}
