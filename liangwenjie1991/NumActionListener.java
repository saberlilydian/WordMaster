package wordMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class NumActionListener implements ActionListener{
	private static FileFromDiskLoader fileFDL = new FileFromDiskLoader();
	
	public void actionPerformed(ActionEvent e){		
		String filePath = "dictionary.txt";
		String settingsPath = "settings.txt";
		
		String wordBase = Frame.getWordBase();  //词库字母
		JComboBox jcbo = Frame.getJComboBox();  
		int method = jcbo.getSelectedIndex();
		
		String numString = JOptionPane.showInputDialog("请选择背单词数量：");
		int num = 0;  //背单词数量
		try{
			num = Integer.parseInt(numString);
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "请重新输入一个数字！");
		}
		
		Frame.setNumber(num);
				
		switch(method){
		    case 0:fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, wordBase, num);
		    	   
		    	   break;  //选择第一个单词开始
			 	    
			case 1:String input =  Frame.getInput(); //输入单词，在词库中查找，查找不到则进入case0	 	    
			       fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, input, num);
			       if(Frame.getInput().equals("一")){
			    	   jcbo.setSelectedIndex(0);			    	
			       }
			    	   
			 	   break;
			 	          
			case 2:fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, null, num);
			
				   break;  //选择从上次背诵的单词开始
			 	   
		}
		
        String line = fileFDL.next();
		
		String word = fileFDL.word(line);
		String expla = fileFDL.meaning(line);
		
		Frame.repain(expla);
	    Frame.setWord(word);
    }
	
	public static FileFromDiskLoader getFileFDL(){
		return fileFDL;
	}
}
