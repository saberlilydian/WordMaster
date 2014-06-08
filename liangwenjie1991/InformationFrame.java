package wordMaster;

import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class InformationFrame extends JFrame{
	public InformationFrame(String wordBase){
		NumberFormat numF = NumberFormat.getPercentInstance();
		numF.setMinimumFractionDigits(2);		
        
		String filePath = "dictionary.txt";
		String settingsPath = "settings.txt";
		
		FileFromDiskLoader fileFDL = new FileFromDiskLoader(filePath, settingsPath, wordBase, null, 0);
		
		Properties proper = new Properties(wordBase.charAt(0), settingsPath); 
		//int index = proper.getIndex();
		
		int correct = proper.getRight();
		int wrong = proper.getWrong();
		int num = correct + wrong;
		int wordNum = fileFDL.getWordBankNum(wordBase);
		double rate = 0;
		if(num==0)
			rate = 0;
		else
			rate = ((double)correct)/num;
		
		Object[][] cellData = {{"�ʿ���", wordBase.toUpperCase()}, {"�ʿⵥ������", wordNum}, {"�ѱ�������", num}, {"��ȷ������", correct}, {"���󵥴���", wrong}, {"��ȷ��", numF.format(rate)}};
		String[] columnNames = {"", ""}; 
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(30); 		
		add(table);
	}
}
