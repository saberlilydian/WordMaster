package wordMaster;

import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class InformationFrame extends JFrame{
	public InformationFrame(String wordBase){
		NumberFormat numF = NumberFormat.getPercentInstance();
		numF.setMinimumFractionDigits(2);		
		Object[][] cellData = {{"�ʿ���", wordBase.toUpperCase()}, {"�ʿⵥ������", 100}, {"�ѱ�������", 100}, {"��ȷ������", 100}, {"���󵥴���", 100}, {"��ȷ��", numF.format(1)}};
		String[] columnNames = {"", ""}; 
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(30); 		
		add(table);
	}
}
