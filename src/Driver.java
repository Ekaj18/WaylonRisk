import javax.swing.JFrame;


public class Driver extends JFrame {

	
	public Driver(){
        super("Risk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RiskBoard window = new RiskBoard();
        getContentPane().add(window);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Driver newGame = new Driver();
    }
}
