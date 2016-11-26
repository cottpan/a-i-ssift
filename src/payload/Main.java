package payload;

import java.util.Arrays;
import java.util.Random;

import library.Fileio;

public class Main {
	public static int JOB_N;
	public static int TIME_N;
	public final static long ITERATION = 5000000;
	public static int MEMBER;
	public static int[][] st_job;
	public static void main(String[] args) {	
		// Initialize data
		st_job = Fileio.read("data/st_job.csv");		

		JOB_N = st_job.length;
		TIME_N = st_job[0].length;
		int[][] job = library.Array.zeros(JOB_N,TIME_N);
		int[][] job_c = library.Array.zeros(JOB_N, TIME_N);

		
		People[] peo = People.read(Fileio.read("data/member.csv"));
		MEMBER = peo.length;
		int point = Point.getPoint(job, st_job);
		
		
		// Calculation
		Random random = new Random();
		for(long i = 0; i < ITERATION; i++){
			int j = random.nextInt(JOB_N);
			int k = random.nextInt(TIME_N);
			if(st_job[j][k] == 0){
				job[j][k] = 0;
			}
			else{
				int l;
				while(true){
					l=random.nextInt(MEMBER);
					if(peo[l].dep == st_job[j][k] || st_job[j][k] == 1)
						break;
				}
				job_c[j][k] = peo[l].id;
				int point_tmp = Point.getPoint(job_c, st_job);
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

}
