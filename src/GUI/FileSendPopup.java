package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FileSendPopup {

	private JFrame popup;
	private JButton yes;
	private JButton no;
	private JLabel text;
	private  int choice;
	
	public FileSendPopup(){
		JPanel content = new JPanel();
		int choice = 0;
		popup = new JFrame("FILE SENDING...");
		popup.setSize(250, 150);
		popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popup.setResizable(false);
		yes = new JButton("YES");
		no = new JButton("NO");
		text = new JLabel("Do you accept file ?");
		
		text.setPreferredSize(new Dimension(230, 50));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		
		yes.setPreferredSize(new Dimension(100,50));
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setChoice(1);
				popup.dispose();				
			}
		});
		
		no.setPreferredSize(new Dimension(100,50));
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setChoice(-1);
				popup.dispose();
			}
		});
		
		content.add(text);
		content.add(yes);
		content.add(no);	
		popup.setContentPane(content);		
		popup.setVisible(true);
	}

	public  int isChoice() {
		return choice;
	}

	public  void setChoice(int choice) {
		this.choice = choice;
	}
	
	
	
}
