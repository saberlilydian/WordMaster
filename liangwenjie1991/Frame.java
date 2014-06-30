package wordMaster;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	private static String[] array1 = {"背诵方式","选择第一个","输入单词","从上次开始"};
	private static JComboBox start = new JComboBox(array1);  //起始单词
	private static String[] propertyArray = {"词库","v","n","adj","adv","prep","int","conj","pron","num"};
	private static JComboBox propertyJComboBox = new JComboBox(propertyArray);  //起始单词
	//static String userName = "";
	private static String wordBase = "";
	private static JLabel label = new JLabel("");     //中文释义
	private static String word  = "";                 //英文单词
	private static int number  = 0;                 //背单词数量
	private static String input = "";    //输入单词
	private static JTextField jText = new JTextField(16);    //英文单词框
    
	private static int wrong = 0;    //错误单词数
	
	private static int addWrong = 0;    //错误单词数
	private static int addRight = 0;    //正确单词数
	private static int addNumber = 0;    //新增单词数
    
	public Frame(){
		
		//Boolean test = false;
		/**do{
			if(test)
				JOptionPane.showMessageDialog(null, "输入不合法！");
			wordBase = JOptionPane.showInputDialog("请选择词库（A-Z）：");
			wordBase = wordBase.toLowerCase();
			test = !wordBase.equals("a")&&!wordBase.equals("b")&&!wordBase.equals("c")&&!wordBase.equals("d")&&!wordBase.equals("e")&&!wordBase.equals("f")&&!wordBase.equals("g")
					&&!wordBase.equals("h")&&!wordBase.equals("i")&&!wordBase.equals("j")&&!wordBase.equals("k")&&!wordBase.equals("l")&&!wordBase.equals("m")&&!wordBase.equals("n")
					&&!wordBase.equals("o")&&!wordBase.equals("p")&&!wordBase.equals("q")&&!wordBase.equals("r")&&!wordBase.equals("s")&&!wordBase.equals("t")&&!wordBase.equals("u")
					&&!wordBase.equals("v")&&!wordBase.equals("w")&&!wordBase.equals("x")&&!wordBase.equals("y")&&!wordBase.equals("z");
		}while(test);**/
		
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p1.add(propertyJComboBox);
		p1.add(start);
		
		add(p1);
		
		JPanel p2 = new JPanel();
		JButton num = new JButton("背单词数量");   //背单词数量
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p2.add(num);
		add(p2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p3.add(new JLabel("中文释义："));
		add(p3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p4.add(label);
		add(p4);
				
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p5.add(new JLabel("请写出英文单词："));
		add(p5);
        
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
	    p6.add(jText);
	    add(p6);
		
	    JPanel p7 = new JPanel();
		JButton infor = new JButton("统计信息");   //统计信息
		p7.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p7.add(infor);
		add(p7);
	    
		JPanel p8 = new JPanel();
	    JButton nextWord = new JButton("下一个");   //“下一个”按钮
	    //JButton newWordBase = new JButton("重新选择词库");   //“重新选择词库”按钮
	    p8.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
	    p8.add(nextWord);
	    //p8.add(newWordBase);
	    add(p8);
	    
		infor.addActionListener(new InforActionListener());
		num.addActionListener(new NumActionListener());	
		
		start.addActionListener(new WordBaseActionListener());
		//start.setSelectedIndex(0);
		
		nextWord.addActionListener(new NextActionListener());
		propertyJComboBox.addActionListener(new NewWBActionListener());
	}
	
	public static JComboBox getJComboBox(){
		return start;
	}
	
	public static JComboBox getpropertyJComboBox(){
		return propertyJComboBox;
	}
	
	public static JTextField getJText(){
		return jText;
	}
	
	public static String getWordBase(){
		return wordBase;
	}
	
	public static void setWordBase(String myWordBase){
		wordBase = myWordBase;
	}
	
	public static void repain(String expla){
		label.setText(expla);
	}
	
	public static String getWord(){
		return word;
	}
	
	public static void setWord(String myWord){
		word = myWord;
	}
	
	public static int getNumber(){
		return number;
	}
	
	public static void setNumber(int myNumber){
		number = myNumber;
	}
	
	public static String getInput(){
		return input;
	}
	
	public static void setInput(String myInput){
		input = myInput;
	}
	
	public static int getWrong(){
		return wrong;
	}
	
	public static void setWrong(int myWrong){
		wrong = myWrong;
	}
	
	public static int getAddWrong(){
		return addWrong;
	}
	
	public static void setAddWrong(int myAddWrong){
		addWrong = myAddWrong;
	}
	
	public static int getAddRight(){
		return addRight;
	}
	
	public static void setAddRight(int myAddRight){
		addRight = myAddRight;
	}
	
	public static int getAddNumber(){
		return addNumber;
	}
	
	public static void setAddNumber(int myAddNumber){
		addNumber = myAddNumber;
	}
}
