package pokemon;

public abstract class Overr {
	public String race;		// 종족
	public String name;		// 캐릭터 이름
	public int age;			// 나이
	public int power;		// 파워
	public int energy;		// 에너지
	
	public Overr() {
		System.out.println("Overr 클래스");
	}
	
	public abstract void eat();			// 밥먹기
	public abstract void sleep();		// 잠자기
	public abstract void exercise();	// 운동하기
	public abstract void aging();		// 나이값 증가
	public abstract void attack();		// 공격
	
	public void print() {				// 현재 캐릭터 상태값 출력
		System.out.println("age: " + age);
		System.out.println("power: " + power);
		System.out.println("energy: " + energy);
		
	}
}
