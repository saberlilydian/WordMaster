package wordMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NextActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    
		FileFromDiskLoader fileFDL = NumActionListener.getFileFDL();
		JTextField jText = Frame.getJText();
		
		String input = jText.getText().toLowerCase().trim();
		String word = Frame.getWord();
		int num = Frame.getNumber();

		if(!input.equals(word)&&!(num==0)){
			JOptionPane.showMessageDialog(null, "错误！正确单词为："+word);
			Frame.setWrong(Frame.getWrong()+1);
		}
		
		String line = fileFDL.next();
		if(line.equals("完")&&!(num==0)){
			String wordBase = Frame.getWordBase();
			int wrong = Frame.getWrong();
			int correct = num - wrong;
			OnceInforFrame onceInforFrameFrame = new OnceInforFrame(wordBase, num, correct, wrong, ((double)correct)/num);
			onceInforFrameFrame.setTitle("本次统计信息");
			onceInforFrameFrame.setLocation(200, 300);
			onceInforFrameFrame.setSize(400,190);
			onceInforFrameFrame.setVisible(true);
			
			Frame.setNumber(0);
			Frame.setWrong(0);
			jText.setText("");
			Frame.repain("");
			Frame.setWord(null);
			return;
		}
		
		
	    String newWord = fileFDL.word(line);
		String expla = fileFDL.meaning(line);
			
	    Frame.repain(expla);
        Frame.setWord(newWord);
	    jText.setText("");	
    }
}
