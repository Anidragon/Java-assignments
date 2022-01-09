
public class Test {

	public static void main(String[] args) {
		
		CompSciCheckerBoard Board = new CompSciCheckerBoard();
		
		System.out.println(Board.toString());
		
		CompSciChecker testPiece = Board.getPiece(3, 7);
		CompSciChecker testPiece2 = Board.getPiece(4, 2);
		Board.makeMove(testPiece, 3, 6);
		
		System.out.println(Board.toString());
		
		Board.makeMove(testPiece, 4, 5);
		System.out.println(Board.toString());
		
		Board.makeMove(testPiece, 4, 4);
		System.out.println(Board.toString());
		Board.makeMove(testPiece, 4, 3);
		System.out.println(Board.toString());
		Board.makeMove(testPiece2, 4, 4);
		System.out.println(Board.toString());
		Board.makeMove(testPiece, 4, 4);
		System.out.println(Board.toString());
		Board.makeMove(testPiece2, 2, 6);
		System.out.println(Board.toString());
	}

}
