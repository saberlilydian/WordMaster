package wordMaster;

import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class InformationFrame extends JFrame{
	public InformationFrame(String wordBase){
		NumberFormat numF = NumberFormat.getPercentInstance();
		numF.setMinimumFractionDigits(2);		
		Object[][] cellData = {{"词库名", wordBase.toUpperCase()}, {"词库单词总数", 100}, {"已背单词数", 100}, {"正确单词数", 100}, {"错误单词数", 100}, {"正确率", numF.format(1)}};
		String[] columnNames = {"", ""}; 
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(30); 		
		add(table);
	}
}
