package pokemon;

import pokemon.Overr;

public class Lee extends Overr{

	public int cnt;
	public Lee(String name) {
		this.name = name;
		race = "Leesanghae";
		age = 0;
		power = 150;
		energy = 200;
		cnt = 0;
		System.out.println("이상해가 만들어졌습니다.");
	}
	
	@Override
	public void eat() {
		energy += 15;
		cnt++;
		aging();
	}

	@Override
	public void sleep() {
		energy += 5;
		cnt++;
		aging();
	}

	@Override
	public void exercise() {
		energy -= 10;
		power += 10;
	}

	@Override
	public void aging() {
		if(cnt >= 3) {
			age++;
			cnt = 0;
		}
	}

	@Override
	public void attack() {
		energy -= 15;
		power += 20;
		
	}
	
}
