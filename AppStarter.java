import javax.swing.JFrame;

public class AppStarter {
	public static void main(String[] args) {
		OuterFrame outerFrame= new OuterFrame();  
		outerFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		outerFrame.setSize( 1200, 700); 
		outerFrame.setVisible( true ); 
	}
}