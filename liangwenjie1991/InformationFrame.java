package wordMaster;

import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class InformationFrame extends JFrame{
	public InformationFrame(String wordBase){
		setLayout(new GridLayout(3, 2, 50, 50));
		
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
		table.setRowHeight(31); 		
		add(table);
		
		int allNumber = fileFDL.getAllNum();
		int allRemembered = fileFDL.getAllRemembered();
		int allRight = fileFDL.getAllRight();
		int allWrong = fileFDL.getAllWrong();
		double allRightRate = 0;
		if(allRemembered==0)
			allRightRate = 0;
		else
			allRightRate = ((double)allRight)/allRemembered;
	
		String item1 = "����";
		String[] arrayStr1 = {"ȫ���ʿ����ѱ�����", "ȫ���ʿ���δ������"};
		double[] arrayDou1 = {allRemembered, allNumber-allRemembered}; 
		add(BarCharts.createPanel("ȫ���ʿ����ѱ���������", item1, arrayStr1, arrayDou1));
		
		String allRightRate2 = numF.format(allRightRate);
		double allRightRate3 = Double.parseDouble(allRightRate2.substring(0, allRightRate2.length()-1));
		
		String item2 = "������%";
		String[] arrayStr2 = {"ȫ���ʿ����ѱ�������ȷ", "ȫ���ʿ����ѱ����ʴ���"};
		double[] arrayDou2 = {allRightRate3, 100-allRightRate3}; 
		add(BarCharts.createPanel("ȫ���ʿ����ѱ�������ȷ��", item2, arrayStr2, arrayDou2));
		
		String[] arrayStr3 = {"��ǰ�ʿ��ѱ�������ȷ"+numF.format(rate), "��ǰ�ʿ��ѱ����ʴ���"+numF.format(1-rate)};
		int[] arrayInt3 = {correct, wrong};
		add(PieCharts.createPanel("��ǰ�ʿ����ѱ�������ȷ�����ı���", arrayStr3, arrayInt3));
		
		
		String[] arrayStr4 = {"ȫ���ʿ��ѱ�������ȷ"+numF.format(allRightRate), "ȫ���ʿ��ѱ����ʴ���"+numF.format(1-allRightRate)};
		int[] arrayInt4 = {allRight, allWrong};
		add(PieCharts.createPanel("ȫ���ʿ����ѱ�������ȷ�����ı���", arrayStr4, arrayInt4));
		
		double rememRate = ((double)num)/wordNum;
		
		String[] arrayStr5 = {"��ǰ�ʿ����ѱ�����"+numF.format(rememRate), "��ǰ�ʿ���δ������"+numF.format(1-rememRate)};
		int[] arrayInt5 = {num, wordNum-num};
		add(PieCharts.createPanel("��ǰ�ʿ����ѱ�����ռ��������", arrayStr5, arrayInt5));
		
		double allRememRate = ((double)allRemembered)/allNumber;
		
		String[] arrayStr6 = {"ȫ���ʿ����ѱ�����"+numF.format(allRememRate), "ȫ���ʿ���δ������"+numF.format(1-allRememRate)};
		int[] arrayInt6 = {allRemembered, allNumber-allRemembered};
		add(PieCharts.createPanel("ȫ���ʿ����ѱ�����ռ��������", arrayStr6, arrayInt6));
	}
	
}
