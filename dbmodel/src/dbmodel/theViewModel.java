 package dbmodel;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class theViewModel extends JFrame {
	
	     String QrCode;
	    
		private JButton showBtn = new JButton("show");
	    private JTextField totalTxt= new JTextField("0");
	    private JTextField discountTotalTxt= new JTextField("0");
	    private JTextField discountTxt= new JTextField("0");
	     theViewModel(){
	    	 
	    	 
	    	         JPanel showPanel = new JPanel();
	    	         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	         this.setSize(400, 300);
	    	         showPanel.add(showBtn);
	    	         
	    	         totalTxt.setPreferredSize( new Dimension( 200, 24 ) );
	    	         showPanel.add(totalTxt);
	    	        
	    	         discountTotalTxt.setPreferredSize( new Dimension( 200, 24 ) );
	    	         showPanel.add(discountTotalTxt);
	    	        
	    	         discountTxt.setPreferredSize( new Dimension( 200, 24 ) );
	    	         showPanel.add(discountTxt);
	    	         
	    	         this.add(showPanel);
	    	         this.setVisible(true);

	     }
	  


	     /*
	public boolean getResult(ResultSet result) throws SQLException {
		if (result.next()) {
			return true;
		}
		return false;
		while ( result.next() ) {
			int id = result.getInt("id");
			String  name = result.getString("name");
			int age  = result.getInt("age");
			String  address = result.getString("address");
			float salary = result.getFloat("salary");
			System.out.println( "ID = " + id );
			System.out.println( "NAME = " + name );
			System.out.println( "AGE = " + age );
			System.out.println( "ADDRESS = " + address );
			System.out.println( "SALARY = " + salary );
			System.out.println();
		}
	}
		 */
		
        void addCalculateListener(ActionListener listenForCalcButton){
		  
	  
	          showBtn.addActionListener(listenForCalcButton);
 
		      }



	public void displayErrorMessage(String string) {
		
		  JOptionPane.showMessageDialog(this, string);

	}
	
	public int getComfirm() {
	 JFrame frame = new JFrame();
	 String[] options = new String[3];
	 options[0] = new String("Yes");
	 options[1] = new String("Create One");
	 options[2] = new String("Cancel");
	 int result= JOptionPane.showOptionDialog(frame.getContentPane(),"Qr Code Exist?","Title", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
	  
	 System.out.println(result);

	   
		return result;
	}
	public String getQrCode() {
		return JOptionPane.showInputDialog("Please input qr code: ");
		
		
	}


	 public double getTotal() {
			return Double.parseDouble(totalTxt.getText());
		}

	public void setDiscountTotal(double discountTotal) {
		discountTotalTxt.setText(Double.toString(discountTotal));

		
	}



	public void setDiscount(double discount) {
		discountTxt.setText(Double.toString(discount));
		
	}
	
}
