package wordMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class WordBaseActionListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		String filePath = "dictionary.xml";
		String settingsPath = "settings.txt";
		
		String word = "";
	    String expla = "";
		
		String wordBase = Frame.getWordBase();
		JComboBox jcbo = Frame.getJComboBox();
		int method = jcbo.getSelectedIndex();
		
		switch(method){
		
		    case 0:break;
	 	    case 1:FileFromDiskLoader fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, "startFromTheFirst", 0);	   
	 	           String line = fileFDL.next();
	 	    	   word = fileFDL.word(line);
	 	    	   expla = fileFDL.meaning(line);
	 	           break;  //选择第一个单词开始，将第一个单词赋给word
	 	    
	 	    case 2:String input = JOptionPane.showInputDialog("输入单词：").toLowerCase().trim();  //输入单词，在词库中查找，查找不到则进入case0	 
	 	           Frame.setInput(input);
	 	           /**if(!input.substring(0, 1).equals(wordBase)){
	 	        	  JOptionPane.showMessageDialog(null, "输入不合法！");
	 	              jcbo.setSelectedIndex(0);
	 	           }**/
	 	           break;
	 	          
	 	    case 3:break;  //选择从上次背诵的单词开始
	 	   
	 	}
		Frame.repain(expla);
	    Frame.setWord(word);
    }
}
