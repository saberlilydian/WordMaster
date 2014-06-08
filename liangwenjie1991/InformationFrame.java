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
		
		Object[][] cellData = {{"词库名", wordBase.toUpperCase()}, {"词库单词总数", wordNum}, {"已背单词数", num}, {"正确单词数", correct}, {"错误单词数", wrong}, {"正确率", numF.format(rate)}};
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
	
		String item1 = "数量";
		String[] arrayStr1 = {"全部词库中已背单词", "全部词库中未背单词"};
		double[] arrayDou1 = {allRemembered, allNumber-allRemembered}; 
		add(BarCharts.createPanel("全部词库中已背单词数量", item1, arrayStr1, arrayDou1));
		
		String allRightRate2 = numF.format(allRightRate);
		double allRightRate3 = Double.parseDouble(allRightRate2.substring(0, allRightRate2.length()-1));
		
		String item2 = "比例：%";
		String[] arrayStr2 = {"全部词库中已背单词正确", "全部词库中已背单词错误"};
		double[] arrayDou2 = {allRightRate3, 100-allRightRate3}; 
		add(BarCharts.createPanel("全部词库中已背单词正确率", item2, arrayStr2, arrayDou2));
		
		String[] arrayStr3 = {"当前词库已背单词正确"+numF.format(rate), "当前词库已背单词错误"+numF.format(1-rate)};
		int[] arrayInt3 = {correct, wrong};
		add(PieCharts.createPanel("当前词库中已背单词正确与错误的比例", arrayStr3, arrayInt3));
		
		
		String[] arrayStr4 = {"全部词库已背单词正确"+numF.format(allRightRate), "全部词库已背单词错误"+numF.format(1-allRightRate)};
		int[] arrayInt4 = {allRight, allWrong};
		add(PieCharts.createPanel("全部词库中已背单词正确与错误的比例", arrayStr4, arrayInt4));
		
		double rememRate = ((double)num)/wordNum;
		
		String[] arrayStr5 = {"当前词库中已背单词"+numF.format(rememRate), "当前词库中未背单词"+numF.format(1-rememRate)};
		int[] arrayInt5 = {num, wordNum-num};
		add(PieCharts.createPanel("当前词库中已背单词占单词总数", arrayStr5, arrayInt5));
		
		double allRememRate = ((double)allRemembered)/allNumber;
		
		String[] arrayStr6 = {"全部词库中已背单词"+numF.format(allRememRate), "全部词库中未背单词"+numF.format(1-allRememRate)};
		int[] arrayInt6 = {allRemembered, allNumber-allRemembered};
		add(PieCharts.createPanel("全部词库中已背单词占单词总数", arrayStr6, arrayInt6));
	}
	
}
