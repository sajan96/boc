package swing1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_access.MySQLConnection;
import tools.CSVGenerator;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class testswing extends JFrame {

	private JPanel contentPane;
	private MySQLConnection con;
	private CSVGenerator csvGen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testswing frame = new testswing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public testswing() throws IOException {
		con=new MySQLConnection();
		csvGen=new CSVGenerator("C:\\Users\\sajan\\Documents\\boc\\result.csv");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("type here");
		textArea.setBounds(250, 83, 325, 111);
		contentPane.add(textArea);
		JButton btnNewButton = new JButton("RUN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textArea.getText();
				try {
//					ResultSet res=con.getResultSetByQuery(con.TEST_QUERY);
					ResultSet res=con.getResultSetByQuery(text);
					csvGen.generateCSV(res);
					
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, " "+text);
			}
		});
		btnNewButton.setBounds(473, 333, 85, 69);
		contentPane.add(btnNewButton);
	}
}
