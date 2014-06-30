package wordMaster;

import javax.swing.JPanel; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class PieCharts extends ApplicationFrame{
	public PieCharts(String title){
		super(title);
    }

    // ������ʾͼ������
    public static JPanel createPanel(String title, String[] array1, int[] array2){
    	JFreeChart jfreechart = createChart(title, createDataset(array1, array2));
        return new ChartPanel(jfreechart);
    }
   
   // ���ɱ�ͼ���ݼ�����
   public static PieDataset createDataset(String[] array1, int[] array2){
	   DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
	   for(int i=0;i<array1.length;i++){
		   defaultpiedataset.setValue(array1[i], array2[i]);
	   }
	   return defaultpiedataset;
   }
   
   //����ͼ��������JFreeChart
   public static JFreeChart createChart(String title, PieDataset piedataset){
	   //����ͼ�����
       JFreeChart jfreechart = ChartFactory.createPieChart(title, piedataset, true, true, false);
       //���ͼ����ʾ����
       //PiePlot pieplot = (PiePlot)jfreechart.getPlot();
       //����ͼ���ǩ����
       //pieplot.setLabelFont(new Font("SansSerif",Font.BOLD,12));
       //pieplot.setNoDataMessage("No data available");
       //pieplot.setCircular(true);
       //pieplot.setLabelGap(0.01D);//���
     
       return jfreechart;
   }
   
   public static void main(String[] args){
	   InformationFrame inforFrame = new InformationFrame("a");
	   
	   String[] arrayStr = {"�ܹ�", "kkk"};
	   int[] arrayInt = {12, 14};
	   
	   
	   inforFrame.add(PieCharts.createPanel("ͳ����Ϣ", arrayStr, arrayInt));
	   
	   inforFrame.setTitle("ͳ����Ϣ");
	   inforFrame.setLocation(200, 300);
	   inforFrame.setSize(400, 228);
	   inforFrame.setVisible(true);
   } 
  
}