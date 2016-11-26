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
}
