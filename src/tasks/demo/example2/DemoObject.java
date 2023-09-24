package tasks.demo.example2;

public class DemoObject {
	
	int id = 0;
	int statusA = 0;
	int statusB = 0;
	int statusC = 0;
	int statusD = 0;
	
	public DemoObject(int id) {
		this.id = id;
	}
	
	
	
	public String toString() {
		//return "Statuses: " + statusA + ", " + statusB + ", " + statusC + ", " + statusD;
		return "" + id;
	}

}
