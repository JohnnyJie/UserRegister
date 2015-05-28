package UI;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Control.SignInSystem;
import Object.Account;
import Object.Person;

public class RegistFrame extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	private JPanel ground=new JPanel();
	private JTextField nameTextField = new JTextField();	
	private JTextField accountTextField = new JTextField();
	private JTextField psdTextField = new JTextField();
	private JTextField idTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JTextField telTextField = new JTextField();
	private JComboBox sexComboBox=new JComboBox(new String[] {"ÄÐ","Å®"});
	private JLabel nameLabel = new JLabel("ÐÕÃû:");
	private JLabel psdLabel = new JLabel("ÃÜÂë: ");
	private JLabel psdErroLabel = new JLabel("ÃÜÂëÊäÈë´íÎó");
	private JLabel accountLabel = new JLabel("ÕÊ»§Ãû: ");
	private JLabel accounErroLabel = new JLabel("ÕË»§ÃûÊäÈë´íÎó");
	private JLabel idLabel = new JLabel("Éí·ÝÖ¤: ");
	private JLabel sexLabel = new JLabel("ÐÔ±ð: ");
	private JLabel emailLabel = new JLabel("ÓÊÏä: ");
	private JLabel telLabel = new JLabel("ÊÖ»úºÅ: ");
	private JLabel telErroLabel = new JLabel("ÊÖ»úºÅÊäÈë´íÎó");
	
	
	private JButton changeButton=new JButton("È¡Ïû");
	private JButton confirmButton = new JButton("È·ÈÏ");
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RegistFrame inst = new RegistFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	private RegistFrame() {
		super();
		super.setContentPane(ground);
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
			setSize(600,600);
			
			ground.setLayout(null);
			ground.setBounds(0, 0, 600, 600);
			JLabel bgLabel=new JLabel();
			bgLabel.setIcon( new ImageIcon("lib/bg.jpg"));
			bgLabel.setBounds(0,0,600,600);
			
			accountLabel.setBounds(150, 50, 100, 80);
			accountLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			psdLabel.setBounds(150, 100, 100, 80);
			psdLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			nameLabel.setBounds(150, 150, 100, 80);
			nameLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			idLabel.setBounds(150, 200, 100, 80);
			idLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			sexLabel.setBounds(150, 250, 100, 80);
			sexLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			emailLabel.setBounds(150, 300, 100, 80);
			emailLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			telLabel.setBounds(150, 350, 350, 80);
			telLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
			
			accountTextField.setBounds(230, 75, 180, 35);
			psdTextField.setBounds(230, 125, 180, 35);
			nameTextField.setBounds(230, 175, 180, 35);
			idTextField.setBounds(230, 225, 180, 35);
			emailTextField.setBounds(230, 325, 180, 35);
			telTextField.setBounds(230, 375, 180, 35);
			telTextField.addKeyListener(new VoteElectKeyListener());

			sexComboBox.setBounds(230, 275, 80, 35);
			
			changeButton.setBounds(130, 450, 80, 40);
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
			confirmButton.setBounds(230, 450, 80, 40);
			confirmButton.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					method();
				}

				public void method(){
					Account acc=new Account(accountTextField.getText(),psdTextField.getText());
					Person per=new Person(nameTextField.getText(),idTextField.getText(),telTextField.getText(),
							sexComboBox.getSelectedItem().toString(),emailTextField.getText());
					//System.out.println(acc.get);
					SignInSystem sys=new SignInSystem();
					if(checkEmail(emailTextField.getText())){
						if(sys.saveAccount(acc, per)){
							System.out.println("´´½¨³É¹¦");
							LookupFrame.main(per,acc);
							setVisible(false);
						}else{
							System.out.println("´´½¨Ê§°Ü");
						}
					}
					else{
						System.out.println("ÓÊÏä¸ñÊ½´íÎó");
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
			
			
			ground.add(accountLabel);
			ground.add(psdLabel);
			ground.add(accountTextField);
			ground.add(psdTextField);
			ground.add(telLabel);
			ground.add(telTextField);
			ground.add(nameLabel);
			ground.add(nameTextField);
			ground.add(idLabel);
			ground.add(idTextField);
			ground.add(sexLabel);
			ground.add(sexComboBox);
			ground.add(emailLabel);
			ground.add(emailTextField);
			ground.add(emailTextField);
			ground.add(emailTextField);
			ground.add(confirmButton);
			ground.add(changeButton);
			ground.add(bgLabel);
			
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public class VoteElectKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyChar = e.getKeyChar();
			if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

			} else {
				e.consume();
			}
		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
	public static boolean checkEmail(String email){
        boolean flag = false;
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
}
