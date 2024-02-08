package tests.piecesTests;

import board.Board;

public class Knight {

    private char[][] testBoardSchema  = {
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {'k', 'k', 'k', ' ', ' ', ' ', ' ', ' '},
        {'k', 'k', 'k', ' ', ' ', ' ', ' ', ' '},
        {'k', 'k', 'k', ' ', ' ', ' ', ' ', ' '},
    };
    Board testBoard = new Board(testBoardSchema);
    
    
}
