package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Control.AdaminSystem;
import Object.Tel_Account;

public class AllUserFrame extends javax.swing.JFrame {
	ArrayList<Tel_Account> list;
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	private JTable table;
	private Object[][] o;
	private TableModel tableModel;
	private Dimension a;
	private JScrollPane scrollPane;
	private JPanel groundPanel=new JPanel();
	private JButton changeBtn=new JButton("退出");

	AdaminSystem admin=new AdaminSystem();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AllUserFrame inst = new AllUserFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	private  AllUserFrame()  {
		super();
		super.setContentPane(groundPanel);
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
			setSize(600, 600);
			setLayout(null);
			o=admin.getAllInf();
			
		    groundPanel.setLayout(null);
		    groundPanel.setOpaque(false);
		    JLabel bgLabel=new JLabel();
			bgLabel.setIcon( new ImageIcon("lib/bg.jpg"));
			bgLabel.setBounds(0,0,600,600);
			
		    groundPanel.setBounds(0, 0, 600, 600);
		    changeBtn.setBounds(250, 40, 100, 40);
		    changeBtn.addMouseListener(new MouseListener(){

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
		    a=new Dimension();
		    
		    tableModel = 
					new DefaultTableModel(o,new String[] {"账户","密码","姓名","ID","性别", "电话","EMail"  });
		    table = new JTable();
		    table.setModel(tableModel);
		    table.setBackground(new Color(255,255,255));
			a=new Dimension();
			a.height=450;
			a.width=500;
			table.setPreferredScrollableViewportSize(a);
			table.setEnabled(false);
			table.setBackground(new Color(255,255,255));
			table.setOpaque(false);
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(table);
			scrollPane.setBounds(50,100,500,450);
			scrollPane.setVisible(true);
			scrollPane.setBackground(new Color(255,255,255,80));
			scrollPane.setOpaque(false);
			
			groundPanel.add(scrollPane);
			groundPanel.add(changeBtn);
			groundPanel.add(bgLabel);
			groundPanel.setPreferredSize(new Dimension(600, 600));


			
			
			
			
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
