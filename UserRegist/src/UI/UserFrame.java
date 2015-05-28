package UI;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Control.SignInSystem;
import Object.Account;
import Object.Person;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UserFrame extends javax.swing.JFrame {
	private JPanel ground=new JPanel();
	private JTextField nameTextField = new JTextField();	
	private JButton changeButton = new JButton("π‹¿Ì‘±µ«¬Ω");
	private JButton confirmButton = new JButton("µ«¬Ω");
	private JButton registButton = new JButton("◊¢≤·");
	private JTextField psdTextField = new JTextField();
	private JLabel nameLabel = new JLabel("”√ªß√˚:");
	private JLabel psdLabel = new JLabel("√‹¬Î: ");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UserFrame inst = new UserFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public UserFrame() {
		super("µ«¬Ω");
		super.setContentPane(ground);
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			super.setSize(700, 350);

			ground.setLayout(null);
			ground.setBounds(0, 0, 700, 350);
			
			{
				JLabel bgLabel=new JLabel();
				bgLabel.setIcon( new ImageIcon("lib/bg.jpg"));
				bgLabel.setBounds(0,0,700,350);
				
				nameLabel.setBounds(180, 50, 100, 80);
				nameLabel.setFont(new java.awt.Font("Œ¢»Ì—≈∫⁄",0,20));
				
				psdLabel.setBounds(180, 100, 100, 80);
				psdLabel.setFont(new java.awt.Font("Œ¢»Ì—≈∫⁄",0,20));
				
				nameTextField.setText("«Î ‰»Î”√ªß√˚");
				nameTextField.setBounds(280, 77, 180, 35);
					
				psdTextField.setText("«Î ‰»Î√‹¬Î");
				psdTextField.setBounds(280, 125, 180, 35);
				
				registButton.setBounds(300, 224, 80, 34);
				registButton.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						method();
					}

					public void method(){
						RegistFrame.main(null);
						setVisible(false);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				
				confirmButton.setBounds(413, 224, 80, 34);
				confirmButton.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						method();
					}

					public void method(){
						Account acc=new Account(nameTextField.getText(),psdTextField.getText());
						SignInSystem sys=new SignInSystem();
						if(sys.signIn(acc)){
							Person per=sys.getPersonByPhone(sys.getPhoneByUserName(acc.getUsername()));
							LookupFrame.main(per,acc);
							setVisible(false);
						}else{
							System.out.println("’À∫≈√‹¬Î¥ÌŒÛ");
						}
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				changeButton.setBounds(520, 224,106, 34);
				changeButton.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						method();
					}

					public void method(){
						ManageFrame.main(null);
						setVisible(false);
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				
				ground.add(nameLabel);
				ground.add(psdLabel);
				ground.add(nameTextField);
				ground.add(psdTextField);
				ground.add(registButton);
				ground.add(confirmButton);
				ground.add(changeButton);
				ground.add(bgLabel);
			}
			

		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
