public class kadai09 {
	public static void main(String[] args) {
		Dog pochi = new Dog();
		pochi.print();
		
		pochi.roudou();
		pochi.print();
		
		pochi.roudou();
		pochi.print();
		
		pochi.roudou();
		pochi.print();
		
		pochi.shokuji();
		pochi.print();
		
		pochi.shokuji();
		pochi.print();
	}
}

class Dog {
	private DogState myState;
	public Dog() {
		myState = TanoshiiState.getInstance();
	}
	public void roudou() {
		myState.tukareta(this);
	}
	public void shokuji() {
		myState.tabeta(this);
	}
	public void changeState(DogState d) {
		myState = d;
	}
	public void print() {
		System.out.print("���݁A�킽���́u");
		System.out.print( myState.toString() );
		System.out.println("�v�ł��B");
	}
}

abstract class DogState {
	public abstract void tukareta(Dog yobidashimoto); //��ꂽ!
	public abstract void tabeta(Dog yobidashimoto); //�H�ׂ�!
}

class TanoshiiState extends DogState {
	private static TanoshiiState s = new TanoshiiState();
	private TanoshiiState() {}
	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		moto.changeState(FutsuuState.getInstance());
	}
	public void tabeta(Dog moto) { // �Ȃɂ����Ȃ�
	}
	public String toString() {
		return "�y�������";
	}
}

class FutsuuState extends DogState {
	private static FutsuuState s = new FutsuuState();
	private FutsuuState() {}
	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		moto.changeState(IrairaState.getInstance());
	}
	public void tabeta(Dog moto) {
		moto.changeState(TanoshiiState.getInstance());
	}
	public String toString() {
		return "���ʏ��";
	}
}

class IrairaState extends DogState {
	private static IrairaState s = new IrairaState();
	private IrairaState() {}
	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		moto.changeState(NeteruState.getInstance());
	}
	public void tabeta(Dog moto) {
		moto.changeState(TanoshiiState.getInstance());
	}
	public String toString() {
		return "���炢����";
	}
}

class NeteruState extends DogState {
	private static NeteruState s = new NeteruState();
	private NeteruState() {}
	public static DogState getInstance() {
		return s;
	}
	public void tukareta(Dog moto) {
		// �Ȃɂ����Ȃ�
	}
	public void tabeta(Dog moto) {
		moto.changeState(TanoshiiState.getInstance());
	}
	public String toString() {
		return "�Q�Ă���";
	}
}