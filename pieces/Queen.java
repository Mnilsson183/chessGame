package pieces;
import board.Board;
public class Queen extends Piece{

	public Queen(char side){
		super(side, 'q');
	}

    @Override
    public boolean isValidMove(int my_row, int my_column, int end_row, int end_column, Board board) {
        return (isStraight(my_row, my_column, end_row, end_column) ^ isDiagonal(my_row, my_column, end_row, end_column)) && !isBlocked(my_row, my_column, end_row, end_column, board);
    }

    private boolean isDiagonal(int my_row, int my_column, int end_row, int end_column){
		int change_row = Math.abs(end_row - my_row);
		int change_column = Math.abs(end_column - my_column);
		return change_row == change_column;
	}

	private boolean isStraight(int my_row, int my_column, int end_row, int end_column){
		return (my_row == end_row) ^ (my_column == end_column);
	}

	public boolean isBlocked(int initialRow, int initialColumn, int finalRow, int finalColumn, Board board){
		if(isStraight(initialRow, initialColumn, finalRow, finalColumn)){
			if(initialRow < finalRow){
				for(int i = 1; i + initialRow < finalRow; i++){
					if(!board.isEmpty(initialRow + i, initialColumn)) return true;
				}
			} else if(initialRow > finalRow){
				for(int i = 1;  initialRow - i > finalRow; i++){
					if(!board.isEmpty(initialRow - i, initialColumn)) return true;
				}
	
			} else if(initialColumn < finalColumn){
				for(int i = 1; i + initialColumn < finalColumn; i++){
					if(!board.isEmpty(initialRow, initialColumn + i)) return true;
				}
			} else if(initialColumn > finalColumn){
				for(int i = 1;  initialColumn - i > finalColumn; i++){
					if(!board.isEmpty(initialRow, initialColumn - i)) return true;
				}
			}
			return false;
		} else if(isDiagonal(initialRow, initialColumn, finalRow, finalColumn)){
			int rowDiff = Math.abs(initialColumn - finalColumn);
            if(initialColumn > finalColumn){
                if(initialRow > finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn - i)) return true;
                    }
                } else if(initialRow < finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn - i)) return true;
                    }
                }
            } else if(initialColumn < finalColumn){
                if(initialRow > finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow - i, initialColumn + i)) return true;
                    }
                } else if(initialRow < finalRow){
                    for(int i = 1; i < rowDiff; i++){
                        if(!board.isEmpty(initialRow + i, initialColumn + i)) return true;
                    }
                }
            }
            return false;
		} else{
			return true;
		}
	}

}