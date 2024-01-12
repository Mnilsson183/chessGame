public class Knight extends Piece {
    
    public Knight(char side){
        super(side);
        this.setType('k');
    }
 
    public boolean isValidMove(int x, int y, int my_x, int my_y){
		if(Math.abs(my_x - x) == 2 ^ Math.abs(my_y - y) == 2){
			if(Math.abs(my_x - x) == 1 ^ Math.abs(my_y - y) == 1){
				return true;
			}
		}
		return false;
	}
}