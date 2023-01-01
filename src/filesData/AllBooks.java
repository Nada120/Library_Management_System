package filesData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import classes.Books;

public class AllBooks {
	  
	public void SaveBooks(Books book) {
		try {
		File file = new File(".\\Database\\Books.txt");
		PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
		pw.append(book.id+","+book.title+","+book.details+","+book.publisher+","+book.isBorrowed+"\n");
		pw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String[][] ReadAllBooks() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\Books.txt"));
			String s = "";
			String AllData[][] = new String[TheNumberOfRows()][4];
			int i=0; 
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
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
	
	public boolean IsBorrowedBook(String id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\Books.txt"));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[0].equalsIgnoreCase(id) && data[4].equalsIgnoreCase("true")) {
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
	
	public int TheNumberOfRows() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\Books.txt"));
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
	
	public int TheLastId() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\Books.txt"));
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
	
}
