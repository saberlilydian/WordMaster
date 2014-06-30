package wordMaster;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class BarCharts extends ApplicationFrame
{
    public BarCharts(String title){
        super(title);
    }    
    
    public static JPanel createPanel(String title, String item, String[] array1, double[] array2){
    	JFreeChart jfreechart = createChart(title, item, createDataset(array1, array2));
        return new ChartPanel(jfreechart); //��chart�������Panel�����ȥ��ChartPanel���Ѽ̳�Jpanel
    }
    
    public static CategoryDataset createDataset(String[] array1, double[] array2){ //������״ͼ���ݼ�
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i<array1.length;i++){
  		   dataset.setValue(array2[i], array1[i], array1[i]);
  	    }
        return dataset;
    }
    
    public static JFreeChart createChart(String title, String item, CategoryDataset dataset){ //�����ݼ�����һ��ͼ��
        JFreeChart chart=ChartFactory.createBarChart(title, "", item, dataset, PlotOrientation.VERTICAL, true, true, false); //����һ��JFreeChart
        //chart.setTitle(new TextTitle("ĳ��˾��֯�ṹͼ",new Font("����",Font.BOLD+Font.ITALIC,20)));//�����������ñ��⣬�滻��hi������
        //CategoryPlot plot=(CategoryPlot)chart.getPlot();//���ͼ���м䲿�֣���plot
        //CategoryAxis categoryAxis=plot.getDomainAxis();//��ú�����
        //categoryAxis.setLabelFont(new Font("΢���ź�",Font.BOLD,12));//���ú���������
        return chart;
    }
    
    
    /**public static void main(String[] args){
    	Frame Frame = new Frame();
 	   
 	    String[] arrayStr = {"�ܹ�", "kkk"};
 	    int[] arrayInt = {12, 14};
 	   
 	   
 	    Frame.add(BarCharts.createPanel("ͳ����Ϣ", "sss", arrayStr, arrayInt));
 	   
 	    Frame.setTitle("ͳ����Ϣ");
 	    Frame.setLocation(200, 300);
 	    Frame.setSize(400, 228);
 	    Frame.setVisible(true);
        
    }*/
}