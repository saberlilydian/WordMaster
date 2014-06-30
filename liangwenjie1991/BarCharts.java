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
        return new ChartPanel(jfreechart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
    }
    
    public static CategoryDataset createDataset(String[] array1, double[] array2){ //创建柱状图数据集
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i<array1.length;i++){
  		   dataset.setValue(array2[i], array1[i], array1[i]);
  	    }
        return dataset;
    }
    
    public static JFreeChart createChart(String title, String item, CategoryDataset dataset){ //用数据集创建一个图表
        JFreeChart chart=ChartFactory.createBarChart(title, "", item, dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
        //chart.setTitle(new TextTitle("某公司组织结构图",new Font("宋体",Font.BOLD+Font.ITALIC,20)));//可以重新设置标题，替换“hi”标题
        //CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
        //CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
        //categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,12));//设置横坐标字体
        return chart;
    }
    
    
    /**public static void main(String[] args){
    	Frame Frame = new Frame();
 	   
 	    String[] arrayStr = {"总共", "kkk"};
 	    int[] arrayInt = {12, 14};
 	   
 	   
 	    Frame.add(BarCharts.createPanel("统计信息", "sss", arrayStr, arrayInt));
 	   
 	    Frame.setTitle("统计信息");
 	    Frame.setLocation(200, 300);
 	    Frame.setSize(400, 228);
 	    Frame.setVisible(true);
        
    }*/
}