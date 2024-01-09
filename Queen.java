public class Queen extends Piece{

	public Queen(char side){
		super(side);
	}

    @Override
    public boolean isValidMove(int x, int y, int my_x, int my_y) {
        return isStraight(x, y, my_x, my_y) ^ isDiagonal(x, y, my_x, my_y);
    }

    private boolean isDiagonal(int x, int y, int my_x, int my_y){
		int change_x = x - my_x;
		int change_y = y - my_y;
		return change_x == change_y;
	}

	private boolean isStraight(int x, int y, int my_x, int my_y){
		return (my_x == x) ^ (my_y == y);
	}

}