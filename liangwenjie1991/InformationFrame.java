package wordMaster;

import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class InformationFrame extends JFrame{
	public InformationFrame(String wordBase){
		NumberFormat numF = NumberFormat.getPercentInstance();
		numF.setMinimumFractionDigits(2);		
		
		String settingsPath = "settings.txt";
		
		Properties proper = new Properties(Frame.getWordBase().charAt(0), settingsPath); 
		int index = proper.getIndex();
		int num = proper.getNumber();
		int correct = proper.getRight();
		int wrong = proper.getWrong();
		double rate = 0;
		if(num==0)
			rate = 0;
		else
			rate = ((double)correct)/num;
		
		Object[][] cellData = {{"词库名", wordBase.toUpperCase()}, {"词库单词总数", index}, {"已背单词数", num}, {"正确单词数", correct}, {"错误单词数", wrong}, {"正确率", numF.format(rate)}};
		String[] columnNames = {"", ""}; 
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(30); 		
		add(table);
	}
}
