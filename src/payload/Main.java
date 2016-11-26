package payload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	public final static int JOB_N = 20;
	public final static int TIME_N = 85;
	public final static long ITERATION = 5000000;
	public final static int MEMBER = 14;
	public static int[][] is_job;
	public static int[][] st_dep;
	public static void main(String[] args) {
		is_job = new int[JOB_N][TIME_N];
		st_dep = new int[JOB_N][TIME_N];
				
		is_job = Fileio.read("data/is_job.csv");
		st_dep = Fileio.read("data/st_dep.csv");		

		int[][] job = new int[JOB_N][TIME_N];
		for(int i = 0; i < job.length; i++){
			Arrays.fill(job[i], 0);
		}
		
		int[][] job_c = new int[JOB_N][TIME_N];
		for(int i = 0; i < job_c.length; i++){
			Arrays.fill(job_c[i], 0);
		}
		//int[][] job_c = job.clone();
		People[] peo = new People[MEMBER];
		int point = calc2(job);
		peo[0] = new People(1,101);
		peo[1] = new People(2,101);
		peo[2] = new People(3,101);
		peo[3] = new People(4,102);
		peo[4] = new People(5,102);
		peo[5] = new People(6,103);
		peo[6] = new People(7,103);
		peo[7] = new People(8,103);
		peo[8] = new People(9,103);
		peo[9] = new People(10,103);
		peo[10] = new People(11,101);
		peo[11] = new People(12,102);
		peo[12] = new People(13,102);
		peo[13] = new People(14,102);
		
		Random random = new Random();
		for(long i = 0; i < ITERATION; i++){
			int j = random.nextInt(JOB_N);
			int k = random.nextInt(TIME_N);
			if(is_job[j][k] == 0){
				job[j][k] = 0;
			}
			else{
				int l;
				while(true){
					l=random.nextInt(MEMBER);
					if(peo[l].dep == st_dep[j][k] || st_dep[j][k] == 1)
						break;
				}
				job_c[j][k] = peo[l].id;
				int point_tmp = calc2(job_c);
				if(point < point_tmp){
					job[j][k] = peo[l].id;
					point = point_tmp;
				}
			}
			if(i %100000 ==0)
				System.out.println(point);
		}
		//System.out.println(Arrays.deepToString(job));
		for(int i = 0; i < job.length; i++){
			System.out.println(Arrays.toString(job[i]));
		}
	}
	private static int calc(int[][] job_c) {
		int point = 0;
		for(int i = 0; i < JOB_N;i++){
			for(int j = 0 ; j < TIME_N; j++){
				if(is_job[i][j] == 0 && job_c[i][j] != 0){
					point-=100;
				}
				if(is_job[i][j] != 0 && job_c[i][j] == 0){
					point-=10;
				}
			}
		}
		return point;
	}
	private static int calc2(int[][] job_c) {
		int point = 0;
		for(int i=0; i < JOB_N; i++){
			int j=0;
			while(j < TIME_N){
				while(j < TIME_N && job_c[i][j] == 0){
					if(is_job[i][j] != 0)
						point-=50;
					j++;
				}
				if(j < TIME_N && is_job[i][j]==0 && job_c[i][j] != 0){
					point-=150;
					j++;
					continue;
				}
				if(j >= TIME_N){
					continue;
				}
				int temp = job_c[i][j];
				int counter = 0;
				while(j < TIME_N && temp == job_c[i][j]){
					counter++;
					j++;
				}
				switch(counter){
				case 1:{point-=40;break;}
				case 2:{point-=30;break;}
				case 3:{point-=20;break;}
				case 4:{break;}
				case 5:{point+=20;break;}
				case 6:{point+=50;break;}
				case 7:{point+=50;break;}
				case 8:{point-=15;break;}
				case 9:{point-=30;break;}
				case 10:{point-=70;break;}
				case 11:{point-=120;break;}
				default:{point-=150;break;}
				}
			}
		}
		return point;
	}

}
