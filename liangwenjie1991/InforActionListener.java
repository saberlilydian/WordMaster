package wordMaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InforActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		String wordBase = Frame.getWordBase();
		InformationFrame inforFrame = new InformationFrame(wordBase);
		inforFrame.setTitle("统计信息");
		inforFrame.setLocation(20, 20);
		inforFrame.setSize(1300, 700);
		inforFrame.setVisible(true);
    }
}
