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
        
		String filePath = "dictionary.txt";
		String recordPath = "";
		
		PropertyValue proValue = new PropertyValue(filePath, recordPath);
		int status = proValue.getStatus(word);
		
		if(!input.equals(word)&&!(num==0)){
			JOptionPane.showMessageDialog(null, "������ȷ����Ϊ��"+word);
			Frame.setWrong(Frame.getWrong()+1);
			
			int[] array1 = {2};
			String[] array2 = {word};
			
			if(status==0)
				proValue.setStatus(array1, array2);
		}
		else{
			int[] array1 = {1};
			String[] array2 = {word};
			proValue.setStatus(array1, array2);
		}
		
		String line = fileFDL.next();
		if(line.equals("��")&&!(num==0)){
			String wordBase = Frame.getWordBase();
			int wrong = Frame.getWrong();
			int correct = num - wrong;
			OnceInforFrame onceInforFrameFrame = new OnceInforFrame(wordBase, num, correct, wrong, ((double)correct)/num);
			onceInforFrameFrame.setTitle("����ͳ����Ϣ");
			onceInforFrameFrame.setLocation(200, 300);
			onceInforFrameFrame.setSize(400,190);
			onceInforFrameFrame.setVisible(true);
			
			Frame.setNumber(0);
			Frame.setWrong(0);
			jText.setText("");
			Frame.repain("");
			Frame.setWord(null);
			
			X x = new X();
			X.setLastWord(wordBase, word);
			
			return;
		}
		
		
	    String newWord = fileFDL.word(line);
		String expla = fileFDL.meaning(line);
			
	    Frame.repain(expla);
        Frame.setWord(newWord);
	    jText.setText("");	
    }
}
