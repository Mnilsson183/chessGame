package ui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Board;

import java.awt.*;

public class ChessGameGuiJFrame extends JFrame{
    private Board board;

    public ChessGameGuiJFrame(Board board){
        super("Chess Game");
        this.board = board;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JPanel chessBoardJPanel = createBoardJPanel();
        add(chessBoardJPanel);
        setVisible(true);
    }

    private JPanel createBoardJPanel(){
        JPanel chessBoardJPanel = new JPanel(new GridLayout(8, 8));
        
        for(int row = 0; row < 8; row++){
            for(int column = 0; column < 8; column++){
                JButton tileButton = createTileButton(row, column);
                chessBoardJPanel.add(tileButton);
            }
        }

        return chessBoardJPanel;
    }

    private JButton createTileButton(int row, int column){
        JButton button = new JButton();
        button.setBackground((row + column) % 2 == 0 ? Color.white : Color.BLACK);
        button.addActionListener(e -> handleTileClick(row, column));
        return button;
    }

    private void handleTileClick(int row, int column){
        
    }

    public boolean renderChessBoard(Board board){

    }

}
