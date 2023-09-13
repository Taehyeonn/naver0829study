package bit701.day0913;

interface RemoteControl {
	
	//상수
	int MAX_VOLUME=10;
	int MIN_VOLUME=0;
	
	//추사메서드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//jdk에서 추가된 기능
	//디폴트 인스턴스 메서드-기능구현가능하다
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다");
		}
	}
	
}
class Television implements RemoteControl {
	private int volume;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		
	}
	
}



public class Book348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc=null;
		rc=new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
		//디폴트 메서드 호출
		
		rc.setMute(false);
		rc.setMute(true);
		
		RemoteControl rc2=null; //인터페이스라 생성할수없음;
		rc2.setMute(false);//반드시 구현하는 클래스가 있어야만 호출이 가능하다
	}

}
