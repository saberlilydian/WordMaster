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
	
	private static String[] array1 = {"���з�ʽ","ѡ���һ��","���뵥��","���ϴο�ʼ"};
	private static JComboBox start = new JComboBox(array1);  //��ʼ����
	private static String[] propertyArray = {"�ʿ�","v","n","adj","adv","prep","int","conj","pron","num"};
	private static JComboBox propertyJComboBox = new JComboBox(propertyArray);  //��ʼ����
	//static String userName = "";
	private static String wordBase = "";
	private static JLabel label = new JLabel("");     //��������
	private static String word  = "";                 //Ӣ�ĵ���
	private static int number  = 0;                 //����������
	private static String input = "";    //���뵥��
	private static JTextField jText = new JTextField(16);    //Ӣ�ĵ��ʿ�
    
	private static int wrong = 0;    //���󵥴���
	
	private static int addWrong = 0;    //���󵥴���
	private static int addRight = 0;    //��ȷ������
	private static int addNumber = 0;    //����������
    
	public Frame(){
		
		//Boolean test = false;
		/**do{
			if(test)
				JOptionPane.showMessageDialog(null, "���벻�Ϸ���");
			wordBase = JOptionPane.showInputDialog("��ѡ��ʿ⣨A-Z����");
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
		JButton num = new JButton("����������");   //����������
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p2.add(num);
		add(p2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p3.add(new JLabel("�������壺"));
		add(p3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p4.add(label);
		add(p4);
				
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p5.add(new JLabel("��д��Ӣ�ĵ��ʣ�"));
		add(p5);
        
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
	    p6.add(jText);
	    add(p6);
		
	    JPanel p7 = new JPanel();
		JButton infor = new JButton("ͳ����Ϣ");   //ͳ����Ϣ
		p7.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		p7.add(infor);
		add(p7);
	    
		JPanel p8 = new JPanel();
	    JButton nextWord = new JButton("��һ��");   //����һ������ť
	    //JButton newWordBase = new JButton("����ѡ��ʿ�");   //������ѡ��ʿ⡱��ť
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
