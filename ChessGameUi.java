import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class ChessGameUi extends JFrame{
    private Board board;

    public ChessGameUi(Board board){
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
        add(new Button());

        return chessBoardJPanel;
    }

}
