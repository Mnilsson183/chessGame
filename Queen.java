public class Queen extends Piece{

	public Queen(char side){
		super(side);
		this.setType('q');
	}

    @Override
    public boolean isValidMove(int row, int column, int my_row, int my_column) {
        return isStraight(row, column, my_row, my_column) ^ isDiagonal(row, column, my_row, my_column);
    }

    private boolean isDiagonal(int row, int column, int my_row, int my_column){
		int change_row = row - my_row;
		int change_column = column - my_column;
		return change_row == change_column;
	}

	private boolean isStraight(int row, int column, int my_row, int my_column){
		return (my_row == row) ^ (my_column == column);
	}

}