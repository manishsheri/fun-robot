package elecage.fun_robot.test;
import java.awt.*;
import java.awt.event.*;
public class ButtonListener implements ActionListener {
	Frame frm = null;
	public ButtonListener() {
		
	}
	public ButtonListener(Frame value) {
		frm = value;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		if(arg0.getActionCommand() == "»¡°£»ö") {
			frm.setBackground(Color.red);
		}
		else
			frm.setBackground(Color.blue);
	}
	
}
