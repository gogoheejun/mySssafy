package w0127.awt;

import javax.swing.JFrame;

class WindowEx2 extends JFrame{
	public WindowEx2(String title) {
		super(title);
		
		super.setBounds(200, 200, 400, 300);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우 종료
	}
}
public class AwtEx2 {
	public static void main(String[] args) {
		new WindowEx2("내가 만든 윈도우2");
	}
}
