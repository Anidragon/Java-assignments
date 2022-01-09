	/*
	 * A CompSciCheckerBoard represents a playing board for a 
	 * CompSciChecker game.  In this game a board is 8x8 and starts 
	 * with black and white CompSciChecker pieces.  The fields
	 * numWhitePieces and numBlackPieces track the appropriate 
	 * number of pieces for either side.  There are 12 white 
	 * pieces starting at the top left square and fill every other space
	 * on the board for the first three rows.  No two white pieces 
	 * should be directly adjacent to start.  The same is true of the
	 * 12 black pieces but they start at the bottom right and fill the
	 * bottom three rows.  the pieces may move one place in any
	 * direction, forwards, backwards, left, right or diagonal.  The
	 * pieces may "jump" an opposing player in any direction as well.
	 * 
	 */
public class CompSciCheckerBoard 
{
	
	private CompSciChecker[][] board;
	private int numWhitePieces;
	private int numBlackPieces;
	
	
	
	/*
	 * Create a Constructor for the CompSciCheckerBoard
	 * Once created the board should look like this:
	 * 
	 *  _ _ _ _ _ _ _ _
	 * |W   W   W   W  |
	 * |  W   W   W   W|
	 * |W   W   W   W  |
	 * |               |
	 * |               |
	 * |  B   B   B   B|
	 * |B   B   B   B  |
	 * |_ B _ B _ B _ B|
	 * 
	 * Empty Spaces have a value of null
	 * 
	 * 
	 */
	
	public CompSciCheckerBoard()
	{
		board = new CompSciChecker[8][8]; 

	for(int j = 0; j < 8 ; j++) {	
	for(int i = 0; i < 8 ; i++) {
		if(j < 3) {
			if(j == 0 || j == 2) {
		
		if ((i - 1)%2 != 0) {
		CompSciChecker checker = new CompSciChecker("W", i, j);
		board[j][i] = checker;
	    
		}
		
			}
		else if((i - 1)%2 == 0 ) 
		{
			CompSciChecker checker = new CompSciChecker("W", i, j);
			board[j][i] = checker;
		}
		}
		
		
		else if (j > 4) {
			if(j == 5 || j == 7) {
			
				if ((i)%2 != 0) {
				CompSciChecker checker = new CompSciChecker("B", i, j);
				board[j][i] = checker;
				
				}
			}
				
				else if((i)%2 == 0) 
				{
				CompSciChecker checker = new CompSciChecker("B", i, j);
				board[j][i] = checker;
				}
				
	
		}
		else {
			board[j][i] = null;
		}
	}
	
	}
	
	}
	
	
	
	/*
	 * Next you will write the method isValidMove which will
	 * take a CompSciChecker piece and a new x and y value
	 * and determine if the move to the new space is legal.
	 * 
	 * A CompSciChecker piece can move one space in any direction
	 * including diagonally, so long as the space is not occuppied.
	 * 
	 * A CompSciChecker piece can move two spaces in any direction
	 * ONLY IF there is an opposing piece being "jumped" and the new
	 * space is not occupied.
	 * 
	 * write the method isValidMove.  return true if the desired move
	 * is valid and false if it is not.
	 */
	
	public boolean isValidMove (CompSciChecker piece, int newX, int newY)
	{
		int currentX = piece.getX();
		int currentY = piece.getY();
		
		if(newX == currentX && newY == currentY) {
			return false;
		}
		else if(newX < 0) {
			return false;
		}
		else if(newX > 7) {
			return false;
		}
		else if(newY < 0) {
			return false;
		}
		else if(newY > 7 ) {
			return false;
		}
		else if( board[newY][newX] == null) {
			
		//south
		 if(currentY + 1 == newY && currentX == newX  ) {
			 return true;
		 }
		 //south west
		 else if(currentY + 1 == newY && currentX - 1 == newX  ) {
			 return true;
		 }
		 //west
		 else if(currentY == newY && currentX - 1 == newX  ) {
			 return true;
		 }
		 //north west
		 else if(currentY - 1 == newY && currentX - 1 == newX  ) {
			 return true;
		 }
		 //north
		 else if(currentY - 1 == newY && currentX == newX  ) {
			 return true;
		 }
		 //north east
		 else if(currentY - 1 == newY && currentX + 1 == newX  ) {
			 return true;
		 }
		 //east
		 else if(currentY == newY && currentX + 1 == newX  ) {
			 return true;
		 }
		 //south east
		 else if(currentY + 1 == newY && currentX + 1 == newX  ) {
			 return true;
		 }
		 else if(currentY + 2 == newY && currentX == newX && board[currentY + 1][currentX] != null && board[currentY + 1][currentX].getColor() != piece.getColor()  ) {
			 return true;
		 }
		 else if(currentY + 2 == newY && currentX - 2 == newX && board[currentY + 1][currentX - 1] != null && board[currentY + 1][currentX - 1].getColor() != piece.getColor()) {
			 return true;
		 }
		 else if(currentY == newY && currentX - 2 == newX && board[currentY][currentX - 1] != null && board[currentY][currentX - 1].getColor() != piece.getColor() ) {
			 return true;
		 }
		 else if(currentY - 2 == newY && currentX - 2 == newX && board[currentY - 1][currentX - 1] != null &&  board[currentY - 1][currentX - 1].getColor() != piece.getColor()) {
			 return true;
		 }
		 else if(currentY - 2 == newY && currentX == newX && board[currentY - 1][currentX] != null && board[currentY - 1][currentX].getColor() != piece.getColor() ) {
			 return true;
		 }
		 else if(currentY - 2 == newY && currentX + 2 == newX && board[currentY - 1][currentX + 1] != null && board[currentY - 1][currentX + 1].getColor() != piece.getColor() ) {
			 return true;
		 }
		 else if(currentY == newY && currentX + 2 == newX && board[currentY][currentX + 1] != null && board[currentY][currentX + 1].getColor() != piece.getColor() ) {
			 return true;
		 }
		 else if(currentY + 2 == newY && currentX + 2 == newX && board[currentY + 1][currentX + 1] != null && board[currentY + 1][currentX + 1].getColor() != piece.getColor()  ) {
			 return true;
		 }
		
		}
	    else if(board[newY][newX] != null) {
			 return false;
		}
		
		return false;
		
	}



	//public boolean isValidMove(CompSciChecker piece, int newX, int newY)
	{
		//TODO  PART B   GitterDone!!
	}
	
	
	/*
	 * Finally you will write the method makeMove.  This method will
	 * take a CompSciChecker piece and a new x and y as arguments.  
	 * move the desired piece ONLY IF the move is valid.  If an opposing
	 * piece is "jumped" remove it from the board and update the
	 * appropriate field.
	 * 
	 */
	
	public void makeMove(CompSciChecker piece, int newX, int newY)
	{
		int currentX = piece.getX();
		int currentY = piece.getY();
		if(isValidMove(piece, newX, newY) && ((currentY + 2 == newY && currentX + 2 == newX) || (currentY == newY && currentX + 2 == newX) || (currentY - 2 == newY && currentX + 2 == newX) || (currentY - 2 == newY && currentX == newX) || (currentY - 2 == newY && currentX - 2 == newX) || (currentY == newY && currentX - 2 == newX) || (currentY + 2 == newY && currentX - 2 == newX) || (currentY + 2 == newY && currentX == newX))) 
		{
			 if(currentY + 2 == newY && currentX + 2 == newX) {
				 board[currentY + 1][currentX + 1] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else if(currentY + 2 == newY && currentX == newX) {
				 board[currentY + 1][currentX] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else if(currentY + 2 == newY && currentX -2 == newX) {
				 board[currentY + 1][currentX - 1 ] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else if(currentY == newY && currentX - 2 == newX) {
				 board[currentY][currentX - 1] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else if(currentY - 2 == newY && currentX - 2 == newX) {
				 board[currentY - 1][currentX - 1] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else if(currentY - 2 == newY && currentX == newX) {
				 board[currentY - 1][currentX] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else if(currentY - 2 == newY && currentX + 2 == newX) {
				 board[currentY - 1][currentX + 1] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
			 else {
				 board[currentY][currentX + 1] = null;
				 board[newY][newX] = piece;
				 board[currentY][currentX] = null;
				 piece.setX(newX);
				 piece.setY(newY);
			 }
		}
		else if(isValidMove(piece, newX, newY)) {
			 board[newY][newX] = piece;
			 board[currentY][currentX] = null;
			 piece.setX(newX);
			 piece.setY(newY);
		}
	}
	
	



	
	/**
	 * 
	 * @param x x coordinate of board
	 * @param y y coordinate of board
	 * @return the piece at (x,y) or null if no piece
	 *         is located at (x,y)
	 */
	public CompSciChecker getPiece(int x, int y)
	{
		return board[y][x];
	}
	
	/**
	 * 
	 * @return the field board
	 */
	public CompSciChecker[][] getBoard()
	{
		return board;
	}
	
	
	/**
	 * returns a string representation of the board
	 */
	public String toString()
	{
		String str = "  _ _ _ _ _ _ _ _\n";
		for(int i = 0; i<board.length; i++)
		{
			str+= i + "|";
			for(int j = 0; j<board[i].length; j++)
			{
				if(board[i][j] != null)
					str+=board[i][j].getColor();
				else
				{
					if(i<board.length-1) str+=" ";
					else str+= "_";
				}
				if(j<board[i].length-1) str+= " ";
			}
			str+="|\n";
		}
		str+= "  0 1 2 3 4 5 6 7\n";
		return str;
	}
	
	
	
	
	

}
