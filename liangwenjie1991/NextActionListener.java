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
		String wordBase = Frame.getWordBase();
		String settingsPath = "settings.txt";
        
		String filePath = "dictionary.xml";
		String recordPath = "record.txt";
		
		PropertyValue proValue = new PropertyValue(filePath, recordPath);
		int status = proValue.getStatus(word);
		Properties proper = new Properties(wordBase, settingsPath); 
		
		int index = fileFDL.getIndex();
		
		//int addNumber = Frame.getAddNumber();
		int addRight = Frame.getAddRight();
		int addWrong = Frame.getAddWrong();
		
		if(!input.equals(word)&&!(num==0)){
			JOptionPane.showMessageDialog(null, "错误！正确单词为："+word);
			Frame.setWrong(Frame.getWrong()+1);
			
			int[] array1 = {2};
			String[] array2 = {word};
			
			if(status==0){
				proValue.setStatus(array1, array2);
				//Frame.setAddNumber(++addNumber);
				Frame.setAddWrong(++addWrong);
			}
				
		}
		else if(!(num==0)){
			int[] array1 = {1};
			String[] array2 = {word};
			proValue.setStatus(array1, array2);
			
			if(status==0){
				//Frame.setAddNumber(++addNumber);
				Frame.setAddRight(++addRight);
			}
			else if(status==2){
				Frame.setAddRight(++addRight);
				Frame.setAddWrong(--addWrong);
			}
			
		}
		
		String line = fileFDL.next();
		if(line.equals("完")&&!(num==0)){
			
			int wrong = Frame.getWrong();
			int correct = num - wrong;
			OnceInforFrame onceInforFrameFrame = new OnceInforFrame(wordBase, num, correct, wrong, ((double)correct)/num);
			onceInforFrameFrame.setTitle("本次统计信息");
			onceInforFrameFrame.setLocation(200, 300);
			onceInforFrameFrame.setSize(400,190);
			onceInforFrameFrame.setVisible(true);
			//System.out.println("LLL"+proper.getWrong());
			//System.out.println("DDD"+Frame.getAddWrong());
			//System.out.println("old Right"+proper.getRight());
			//System.out.println("new Right"+Frame.getAddRight());
			//Frame.getAddWrong()
			proper.build(index, num, proper.getRight()+Frame.getAddRight(), proper.getWrong()+Frame.getAddWrong());
			
			Frame.setNumber(0);
			Frame.setWrong(0);
			jText.setText("");
			Frame.repain("");
			Frame.setWord(null);
			
			Frame.setAddNumber(0);
			Frame.setAddRight(0);
			Frame.setAddWrong(0);
			
			return;
		}
		
	    String newWord = fileFDL.word(line);
		String expla = fileFDL.meaning(line);
			
	    Frame.repain(expla);
        Frame.setWord(newWord);
	    jText.setText("");	
    }
}
