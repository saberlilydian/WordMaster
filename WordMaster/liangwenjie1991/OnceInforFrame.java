package wordMaster;

import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class OnceInforFrame extends JFrame{
	public OnceInforFrame(String wordBase, int number, int correct, int wrong, double rate){
		NumberFormat numF = NumberFormat.getPercentInstance();
		numF.setMinimumFractionDigits(2);		
		Object[][] cellData = {{"��ѡ�ʿ���", wordBase.toLowerCase()}, {"��ѡ��������", number}, {"��ȷ������", correct}, {"���󵥴���", wrong}, {"��ȷ��", numF.format(rate)}};
		String[] columnNames = {"", ""}; 
		JTable table = new JTable(cellData, columnNames);
		table.setRowHeight(30); 
		
		
		add(table);
	}
	
	/**public static void main(String[] args){
		OnceInforFrame frame = new OnceInforFrame("", 1, 1, 1, 1.0);
	    frame.setTitle("WordMaster");
	    frame.setLocation(450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,190);
	    frame.setVisible(true);
	}*/
}
