package payload;

public class People {
	public int id;
	public int dep;
	public int id(){
		return id;
	}
	public People(int id,int dep){
		this.id = id;
		this.dep = dep;
	}
	public String toString(){
		String ret = String.valueOf(id) + "," + String.valueOf(dep);
		return ret;
	}
	public static People[] read(int[][] data){
		if(data[0].length != 2)
			throw new IllegalArgumentException();
		
		People[] ret = new People[data.length];
		for(int i = 0; i < data.length; i++){
			ret[i] = new People(data[i][0], data[i][1]);
		}
		
		return ret;
	}
}
