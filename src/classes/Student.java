package classes;

import filesData.StudentAccounts;

public class Student extends Users{
	
	public boolean isDeleated = false;
	StudentAccounts sa = new StudentAccounts();
	public int id = sa.TheLastId()+1;
	
	@Override
	public void UpdateAccount(Users s) {
		this.age = s.age;
		this.password = s.password;
		this.username = s.username;
		
	}
	
	@Override
	public void CreateAccount(Users s) {
		this.name = s.name;
		this.age = s.age;
		this.password = s.password;
		this.username = s.username;
	}

}
