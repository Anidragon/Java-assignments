
public class Student {
	
	//Fields-----------------------------------------------------------------------------------------------------
	private String name; 
	
	private int grade;
			
	private int pointsEarned;
    
	private int pointsTotal; 

	private String address;
	
	private int numAssignments;
    
	//CONSTRUCTORS-----------------------------------------------------------------------------------------------
	public Student(int grd, String nm, String adr) {
		
		grade = grd;
		
		name = nm;
		
		address = adr;
		
		numAssignments = 0;
		
	    pointsEarned = 0;
	    
	    pointsTotal = 0;
		
		
	}
	
	public Student(int grd, String nm, String adr, int numA, int pE, int pT) {
	    
		grade = grd;
		
		name = nm;
		
		address = adr;
		
		numAssignments = numA;
		
	    pointsEarned = pE;
	    
	    pointsTotal = pT;
	}
	
	
	//Getter_METHODS-----------------------------------------------------------------------------------------------------
	
	public int getGrade(){
		
		return grade;
	}
	
	public String getName(){
		
		return name;
	}
	
	public String getAddr(){
		
		return address;
	}
	
	
	public int getNumAssignments(){
		
		return numAssignments;
	}
	
	public int getPointsEarned(){
		
		return pointsEarned;
		
	}
	
	public int getPointsTotal(){
		
		return pointsTotal;
		
		
	}

	
	public String toString() {
		return "name:" + name + '\n' + "grade: " + grade +  '\n' +"pointsEarned: " + pointsEarned + '\n' + "pointsTotal: "
				+ pointsTotal + '\n' + " address: " + address + '\n' + ", numAssignments: " + numAssignments;
	}
	
	//Other methods
	
	public double averageGrade() {
		
		return 100*pointsEarned / pointsTotal;	
		
	}
	
	public void addAssignment(int assignmentPoints, int totalAssignmentPoints){
		
		numAssignments += 1;
		
		pointsEarned += assignmentPoints;
		
		pointsTotal += totalAssignmentPoints;
		
		}
	
	public void incrementGrade() {
		
		grade += 1;	
		
	}
	
    public void reset() {
    	
		
		grade = 0;
		
		name = "";
		
		address = "";
		
		numAssignments = 0;
		
	    pointsEarned = 0;
	    
	    pointsTotal = 0;
		
    	
    }
    
    public void setAdress(String adr) {
     
    	address = adr;
}
    
}
