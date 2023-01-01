package filesData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import classes.Student;

public class StudentAccounts {
	
	public void SaveStudentAccount(Student student) {
		try {
		File file = new File(".\\Database\\StudentAccount.txt");
		PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
		pw.append(student.id+","+student.name+","+student.age+","+student.username+","+student.password+","+student.isDeleated+"\n");
		pw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String[][] ReadStudentAccount() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			String s = "";
			String AllData[][] = new String[TheNumberOfRows()][4];
			int i=0; 
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
				data = s.split(",");
				if(data[5].equals("false")) {
					for(int j=0; j<4; j++) {
						AllData[i][j] = data[j];
					}
				}
				
				++i;
			}
			br.close();
			return AllData;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public boolean IsStudentExisting(String name) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
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
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
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
	
	public boolean IsStudentDeleted(String username, String password) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(username) && data[4].equals(password) && data[5].equalsIgnoreCase("true")) {
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
	
	public void UpdateAgeStudentAccount(String age, String username) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\StudentAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(username)) {
					data[2] = age;
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
	
	public void UpdateUsernameStudentAccount(String username, String oldusername) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\StudentAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(oldusername)) {
					data[3] = username;
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
	
	public void UpdatePasswordStudentAccount(String Password, String username) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\StudentAccount.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
				data = s.split(",");
				if(data[3].equalsIgnoreCase(username)) {
					data[4] = Password;
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
	
	public int TheLastId() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
			String s = "";
			int id = 99;
			while((s=br.readLine()) != null) {
				String data[] = new String[6];
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
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\StudentAccount.txt"));
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
