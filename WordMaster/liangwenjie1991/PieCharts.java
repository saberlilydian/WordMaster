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

    // 生成显示图表的面板
    public static JPanel createPanel(String title, String[] array1, int[] array2){
    	JFreeChart jfreechart = createChart(title, createDataset(array1, array2));
        return new ChartPanel(jfreechart);
    }
   
   // 生成饼图数据集对象
   public static PieDataset createDataset(String[] array1, int[] array2){
	   DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
	   for(int i=0;i<array1.length;i++){
		   defaultpiedataset.setValue(array1[i], array2[i]);
	   }
	   return defaultpiedataset;
   }
   
   //生成图表主对象JFreeChart
   public static JFreeChart createChart(String title, PieDataset piedataset){
	   //定义图表对象
       JFreeChart jfreechart = ChartFactory.createPieChart(title, piedataset, true, true, false);
       //获得图表显示对象
       //PiePlot pieplot = (PiePlot)jfreechart.getPlot();
       //设置图表标签字体
       //pieplot.setLabelFont(new Font("SansSerif",Font.BOLD,12));
       //pieplot.setNoDataMessage("No data available");
       //pieplot.setCircular(true);
       //pieplot.setLabelGap(0.01D);//间距
     
       return jfreechart;
   }
   
   public static void main(String[] args){
	   InformationFrame inforFrame = new InformationFrame("a");
	   
	   String[] arrayStr = {"总共", "kkk"};
	   int[] arrayInt = {12, 14};
	   
	   
	   inforFrame.add(PieCharts.createPanel("统计信息", arrayStr, arrayInt));
	   
	   inforFrame.setTitle("统计信息");
	   inforFrame.setLocation(200, 300);
	   inforFrame.setSize(400, 228);
	   inforFrame.setVisible(true);
   } 
  
}