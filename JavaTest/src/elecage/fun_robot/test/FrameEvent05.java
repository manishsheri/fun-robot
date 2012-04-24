package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;


public class FrameEvent05 extends Frame implements ActionListener {
	TextField txtContent;
	TextArea txtState;
	Button btnAppend;
	
	
	public FrameEvent05() throws HeadlessException {
		setLayout(new BorderLayout());
		txtContent = new TextField(20);
		txtState = new TextArea();
		btnAppend = new Button("Ãß    °¡");
		
		this.add(txtContent, BorderLayout.NORTH);
		this.add(txtState, BorderLayout.CENTER);
		this.add(btnAppend, BorderLayout.SOUTH);
		
		btnAppend.addActionListener(this);
		
		setSize(400, 300);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(txtContent.getText() !="") {
			txtState.append(txtContent.getText() + "\n");
			txtContent.setText("");
		}

	}

}
