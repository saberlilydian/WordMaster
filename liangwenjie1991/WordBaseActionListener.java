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
	 	           break;  //ѡ���һ�����ʿ�ʼ������һ�����ʸ���word
	 	    
	 	    case 2:String input = JOptionPane.showInputDialog("���뵥�ʣ�").toLowerCase().trim();  //���뵥�ʣ��ڴʿ��в��ң����Ҳ��������case0	 
	 	           Frame.setInput(input);
	 	           /**if(!input.substring(0, 1).equals(wordBase)){
	 	        	  JOptionPane.showMessageDialog(null, "���벻�Ϸ���");
	 	              jcbo.setSelectedIndex(0);
	 	           }**/
	 	           break;
	 	          
	 	    case 3:break;  //ѡ����ϴα��еĵ��ʿ�ʼ
	 	   
	 	}
		Frame.repain(expla);
	    Frame.setWord(word);
    }
}
