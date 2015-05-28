package UI;

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

import Object.Account;
import Object.Person;

public class LookupFrame extends javax.swing.JFrame {

	private JPanel ground=new JPanel();
	private JTextField nameTextField = new JTextField();	
	private JTextField accountTextField = new JTextField();
	private JTextField idTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JTextField telTextField = new JTextField();
	private JTextField sexComboBox=new JTextField();
	private JLabel titleLabel = new JLabel("²é¿´ÕË»§");
	private JLabel nameLabel = new JLabel("ÐÕÃû:");
	private JLabel accountLabel = new JLabel("ÕÊ»§Ãû: ");
	private JLabel idLabel = new JLabel("Éí·ÝÖ¤: ");
	private JLabel sexLabel = new JLabel("ÐÔ±ð: ");
	private JLabel emailLabel = new JLabel("ÓÊÏä: ");
	private JLabel telLabel = new JLabel("ÊÖ»úºÅ: ");
	
	private JButton confirmButton = new JButton("ÍË³ö");
	
	public static void main(final Person person,final Account acc) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LookupFrame inst = new LookupFrame(person,acc);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	private LookupFrame(Person person,Account acc) {
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
			
			titleLabel.setBounds(220, 30, 160, 80);
			titleLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,32));
			accountLabel.setBounds(150, 100, 100, 80);
			accountLabel.setFont(new java.awt.Font("Î¢ÈíÑÅºÚ",0,20));
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
			
			accountTextField.setBounds(230, 125, 180, 35);
			accountTextField.setText(acc.getUsername());
			accountTextField.setEditable(false);
			nameTextField.setBounds(230, 175, 180, 35);
			nameTextField.setText(person.getName());
			nameTextField.setEditable(false);
			idTextField.setBounds(230, 225, 180, 35);
			idTextField.setText(person.getId());
			idTextField.setEditable(false);
			emailTextField.setBounds(230, 325, 180, 35);
			emailTextField.setText(person.getEmail());
			emailTextField.setEditable(false);
			telTextField.setBounds(230, 375, 180, 35);
			telTextField.setText(person.getPhone());
			telTextField.setEditable(false);
			sexComboBox.setBounds(230, 275, 80, 35);
			sexComboBox.setText(person.getSex());
			sexComboBox.setEditable(false);
			confirmButton.setBounds(230, 450, 80, 40);
			confirmButton.addMouseListener(new MouseListener(){

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
			
			
			ground.add(titleLabel);
			ground.add(accountLabel);
			ground.add(accountTextField);
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
			ground.add(bgLabel);
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
}
