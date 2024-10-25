import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WordCounter extends JFrame {
	
	private JTextArea textArea;
	private JButton	countButton;
	private JLabel wordCountLabel;
	
	public WordCounter() {
		setTitle("Word Counter");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textArea=new JTextArea();
		countButton=new JButton("Count Words");
		wordCountLabel=new JLabel("Word Count:0");
		
		countButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String text=textArea.getText();
				int wordCount=countWords(text);
				wordCountLabel.setText("Word Count : "+ wordCount);
			} 
		});
		
		setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(wordCountLabel, BorderLayout.NORTH);
	}
			private int countWords(String text) {
				if(text.isEmpty()) {
					return 0;
			}
				String words[]=text.trim().split("\\s+");
				return words.length;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new WordCounter().setVisible(true);
			}
		});

	}

}
