package wordMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JComboBox;
import javax.swing.JComboBox;
//import javax.swing.JOptionPane;

public class NewWBActionListener  implements ActionListener{
	public void actionPerformed(ActionEvent e){		
		/**Boolean test = false;
		String newWB = "";
		do{
			if(test)
				JOptionPane.showMessageDialog(null, "输入不合法！");
			newWB = JOptionPane.showInputDialog("请选择词库（A-Z）：");
			newWB = newWB.toLowerCase();
			test = !newWB.equals("a")&&!newWB.equals("b")&&!newWB.equals("c")&&!newWB.equals("d")&&!newWB.equals("e")&&!newWB.equals("f")&&!newWB.equals("g")
					&&!newWB.equals("h")&&!newWB.equals("i")&&!newWB.equals("j")&&!newWB.equals("k")&&!newWB.equals("l")&&!newWB.equals("m")&&!newWB.equals("n")
					&&!newWB.equals("o")&&!newWB.equals("p")&&!newWB.equals("q")&&!newWB.equals("r")&&!newWB.equals("s")&&!newWB.equals("t")&&!newWB.equals("u")
					&&!newWB.equals("v")&&!newWB.equals("w")&&!newWB.equals("x")&&!newWB.equals("y")&&!newWB.equals("z");
		}while(test);
		
		Frame.setWordBase(newWB);	**/
		
		
		String newWB = "";
		
		JComboBox jcbo = Frame.getpropertyJComboBox();
		if(jcbo.getSelectedIndex()!=0){
			newWB = jcbo.getSelectedItem().toString();
			Frame.setWordBase(newWB);
		}
		
		//System.out.println(Frame.getWordBase().equals("n"));
	}
}
