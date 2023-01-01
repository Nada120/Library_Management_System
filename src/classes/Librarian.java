package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import filesData.LibrarianAccounts;

public class Librarian extends Users{
	LibrarianAccounts la = new LibrarianAccounts();
	public int id = la.TheLastId()+1;
	
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
	
	public void DeleteStudent(String id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\StudentAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
				data = s.split(",");
				if(data[0].equalsIgnoreCase(id)) {
					data[5] = "true";
				}
				pw.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+"\n");
			}
			pw.close();
			br.close();
			oldFile.delete();
			file.renameTo(oldFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
