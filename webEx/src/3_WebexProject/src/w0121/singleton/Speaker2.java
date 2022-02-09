package w0121.singleton;

public class Speaker2 {
	private static Speaker2 speaker;
	private int volume;
	
	private Speaker2() {
		volume=5;
	}
	
	public static Speaker2 getInstance() {
		if(speaker==null) {
			speaker=new Speaker2();
		}
		return speaker;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
