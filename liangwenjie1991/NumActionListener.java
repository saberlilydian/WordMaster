package wordMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class NumActionListener implements ActionListener{
	private static FileFromDiskLoader fileFDL = new FileFromDiskLoader();
	
	public void actionPerformed(ActionEvent e){		
		String filePath = "dictionary.xml";
		String settingsPath = "settings.txt";
		
		String wordBase = Frame.getWordBase();  //�ʿ�
		JComboBox jcbo = Frame.getJComboBox();  
		int method = jcbo.getSelectedIndex();
		
		String numString = JOptionPane.showInputDialog("��ѡ�񱳵���������");
		int num = 0;  //����������
		try{
			num = Integer.parseInt(numString);
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "����������һ�����֣�");
		}
		
		Frame.setNumber(num);
				
		switch(method){
		    case 0:break;
		    case 1:fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, "startFromTheFirst", num);
		    	   
		    	   break;  //ѡ���һ�����ʿ�ʼ
			 	    
			case 2:String input =  Frame.getInput(); //���뵥�ʣ��ڴʿ��в��ң����Ҳ��������case0	 	    
			       fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, input, num);
			       if(Frame.getInput().equals("һ")){
			    	   jcbo.setSelectedIndex(1);			    	
			       }
			    	   
			 	   break;
			 	          
			case 3:fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, null, num);
			
				   break;  //ѡ����ϴα��еĵ��ʿ�ʼ
			 	   
		}
		Frame.setNumber(fileFDL.getNumber());
		//System.out.print(Frame.getNumber());
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
