package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import filesData.AllBooks;

public class Books {
	
	AllBooks b = new AllBooks();
	public int id = b.TheLastId()+1;
	public String title;
	public String details;
	public String publisher;
	public boolean isBorrowed = false;
	
	public void BorrowingBook(String id) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\Database\\Books.txt"));
			File file = new File(".\\Database\\tmp.txt");
			File oldFile = new File(".\\Database\\Books.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			String s = "";
			while((s=br.readLine()) != null) {
				String data[] = new String[5];
				data = s.split(",");
				if(data[0].equalsIgnoreCase(id)) {
					data[4] = "true";
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
}
