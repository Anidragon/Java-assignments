
public class StudentMain {

	public static void main(String[] args) {
		
		Student student = new Student(5, "Mr", "Hot's-ville Mars", 5, 1000, 500);
		
		Student student2 = new Student(12, "Ellis", "cold's-ville Neptune");
		
		//Student1 test
		System.out.println(student.getAddr());
		
		System.out.println(student.getPointsEarned());
		
		System.out.println(student.getGrade());
		
		System.out.println(student.getName());
		
		System.out.println(student.getNumAssignments());
		
		System.out.println(student.getPointsEarned());
		
		System.out.println(student.getPointsTotal());
		
		//Student2 test
		System.out.println(student2.getAddr());
		
		System.out.println(student2.getPointsEarned());
		
		System.out.println(student2.getGrade());
		
		System.out.println(student2.getName());
		
		System.out.println(student2.getNumAssignments());
		
		System.out.println(student2.getPointsEarned());
		
		System.out.println(student2.getPointsTotal());
		
		
		//Student1 stats manipulation
		
		student.incrementGrade();
		
		student.addAssignment(1, 90);
		
		System.out.println(student.averageGrade());
		
		//Student2 stats manipulation
		
		student2.reset();
		
		
		//toString:
		
		System.out.println(student.toString());
		
		System.out.println('\n');
		
		System.out.println(student2.toString());
		
		
		
		
		
		
		

	}

}
