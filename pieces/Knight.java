package pieces;
public class Knight extends Piece {
    
    public Knight(char side){
        super(side);
        this.setType('k');
    }
 
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column){
		if(Math.abs(my_row - end_row) == 2 ^ Math.abs(my_column - end_column) == 2){
			if(Math.abs(my_row - end_row) == 1 ^ Math.abs(my_column - end_column) == 1){
				return true;
			}
		}
		return false;
	}

	public boolean isBlocked(){
		return false;
	}
}