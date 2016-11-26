package library;

import java.util.Arrays;

public class Array {
	public static int[][] zeros(int row, int column){
		int[][] ret = new int[row][column];
		for(int i = 0; i < ret.length; i++){
			Arrays.fill(ret[i], 0);
		}
		return ret;
	}
	public static int[][] ones(int row, int column){
		int[][] ret = new int[row][column];
		for(int i = 0; i < ret.length; i++){
			Arrays.fill(ret[i], 1);
		}
		return ret;
	}
	
}
