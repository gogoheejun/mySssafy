package w0127.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowEx1 extends Frame implements WindowListener{
	public WindowEx1(String title) {
		super(title);
		
		super.setBounds(200, 200, 400, 300);
		super.setVisible(true);
		super.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {	}
	@Override
	public void windowClosing(WindowEvent e) {	
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {	}
	@Override
	public void windowIconified(WindowEvent e) { }
	@Override
	public void windowDeiconified(WindowEvent e) {	}
	@Override
	public void windowActivated(WindowEvent e) { }
	@Override
	public void windowDeactivated(WindowEvent e) {	}
}
public class AwtEx1 {
	public static void main(String[] args) {
		new WindowEx1("내가 만든 윈도우");
	}
}
