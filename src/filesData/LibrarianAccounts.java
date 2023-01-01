package filesData;

import java.io.*;
import classes.Librarian;

public class LibrarianAccounts {
	
	public void SaveLibrarianAccount(Librarian librarian) {
		try {
		File file = new File(".\\Database\\LibrarianAccount.txt");
		PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
		pw.append(librarian.id+","+librarian.name+","+librarian.age+","+librarian.username+","+librarian.password+"\n");
		pw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean IsLibrarianExisting(String name) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[1].equalsIgnoreCase(name)) {
					br.close();
					return true;
				}
			}
			br.close();
			return false; 
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean IsPasswordUsernameExisting(String username, String password) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(username) && data[4].equals(password)) {
					br.close();
					return true;
				}
			}
			br.close();
			return false; 
		} catch (Exception ex) {
			return false;
		}
	}
	
	public String[][] ReadLibrarianAccount() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			String s = "";
			String AllData[][] = new String[TheNumberOfRows()][4];
			int i=0; 
			while((s=br.readLine()) != null) {
				String data[] = new String[4];
				data = s.split(",");
				for(int j=0; j<4; j++) {
					AllData[i][j] = data[j];
				}
				++i;
			}
			br.close();
			return AllData;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public void UpdateAgeLibrarianAccount(String age, String username) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\LibrarianAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(username)) {
					data[2] = age;
				}
				pw.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+"\n");
			}
			pw.close();
			br.close();
			oldFile.delete();
			file.renameTo(oldFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void UpdateUsernameLibrarianAccount(String newUsername, String username) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\LibrarianAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(username)) {
					data[3] = newUsername;
				}
				pw.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+"\n");
			}
			pw.close();
			br.close();
			oldFile.delete();
			file.renameTo(oldFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void UpdatePasswordLibrarianAccount(String Password, String user) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\LibrarianAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(user)) {
					data[4] = Password;
				}
				pw.append(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+"\n");
			}
			pw.close();
			br.close();
			oldFile.delete();
			file.renameTo(oldFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public int TheLastId() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			String s = "";
			int id = 99;
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				id = Integer.parseInt(data[0]);
			}
			br.close();
			return id;
		} catch (Exception ex) {
			return 99;
		}
	}
	
	public int TheNumberOfRows() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\LibrarianAccount.txt"));
			int row = 0;
			while(br.readLine() != null) {
				row = row+1;
			}
			br.close();
			return row;
		} catch (Exception ex) {
			return 0;
		}
	}
}
