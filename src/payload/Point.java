package payload;

public class Point {
	public static int JOB_N;
	public static int TIME_N;
	public static int getPoint(int[][] job, int[][] st_job){
		int point = 0;
		JOB_N = job.length;
		TIME_N = job[0].length;
		
		for(int i=0; i < JOB_N; i++){
			int j=0;
			while(j < TIME_N){
				while(j < TIME_N && job[i][j] == 0){
					if(st_job[i][j] != 0)
						point-=50;
					j++;
				}
				if(j < TIME_N && st_job[i][j]==0 && job[i][j] != 0){
					point-=150;
					j++;
					continue;
				}
				if(j >= TIME_N){
					continue;
				}
				int temp = job[i][j];
				int counter = 0;
				while(j < TIME_N && temp == job[i][j]){
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
