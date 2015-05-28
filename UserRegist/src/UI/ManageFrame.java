package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Control.AdaminSystem;


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
public class ManageFrame extends javax.swing.JFrame {
	private JPanel ground=new JPanel();
	private JButton changeButton = new JButton("”√ªßµ«¬Ω");
	private JButton confirmButton = new JButton("µ«¬Ω");
	private JTextField psdTextField = new JTextField();
	private JLabel psdLabel = new JLabel("π‹¿Ì‘±√‹¬Î: ");
	private AdaminSystem admin=new AdaminSystem();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageFrame inst = new ManageFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public ManageFrame() {
		super("π‹¿Ì‘±µ«¬Ω");
		super.setContentPane(ground);
		try {
			//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
			super.setSize(700, 350);

			ground.setLayout(null);
			ground.setBounds(0, 0, 700, 350);
			
			{
				
				JLabel bgLabel=new JLabel();
				bgLabel.setIcon( new ImageIcon("lib/bg.jpg"));
				bgLabel.setBounds(0,0,700,350);
				
				psdLabel.setBounds(153, 100, 127, 80);
				psdLabel.setFont(new java.awt.Font("Œ¢»Ì—≈∫⁄",0,20));
				
				
					
				psdTextField.setText("«Î ‰»Î√‹¬Î");
				psdTextField.setBounds(280, 125, 180, 35);
				
				confirmButton.setBounds(413, 224, 106, 34);
				confirmButton.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						method();
					}

					public void method(){
						if(admin.login(psdTextField.getText())){
							AllUserFrame.main(null);
							setVisible(false);
							
						}else{
							System.out.println("π‹¿Ì‘±√‹¬Î¥ÌŒÛ");
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
				changeButton.setBounds(538, 224, 106, 34);
				changeButton.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						method();
					}

					public void method(){
						UserFrame.main(null);
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
				
			
				ground.add(psdLabel);
				ground.add(psdTextField);
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
