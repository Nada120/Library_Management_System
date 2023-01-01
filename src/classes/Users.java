package classes;

public abstract class Users {
	public String name;
	public int age;
	public String username;
	public String password;
	
	public abstract void CreateAccount(Users user);
	public abstract void UpdateAccount(Users user);
}
