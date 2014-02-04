
/**
 *
 * @author jbernard
 */
public class Ghost extends javax.swing.JFrame {


	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run() {
				new ghostgui().setVisible(true);
				
			}
		}); 
		
	}
	

}
