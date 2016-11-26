package payload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fileio {
	public static int[][] read(String path){
		ArrayList<String[]> al = new ArrayList<String[]>();

		try {
			File csv = new File(path);
			BufferedReader brf = new BufferedReader(new FileReader(csv));
			
			while(brf.ready()) {
				String line = brf.readLine();
				al.add(line.split(","));
			}
			brf.close();
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		String[][] array = new String[al.size()][];
		for (int i = 0; i < al.size(); i++) {
			array[i] = al.get(i);
		}
		
		int[][] ret = new int[array.length][array[0].length];
		for(int i = 0; i < array.length;i++){
			for(int j = 0; j < array[i].length;j++){
				ret[i][j] = Integer.parseInt(array[i][j]);
			}
		}
		return ret;
	}
	
}
