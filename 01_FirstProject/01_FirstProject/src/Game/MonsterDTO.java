package Game;

public class MonsterDTO {
	String name;
	int hp;
	int str;
	int creditDrop;
	int stage;

	public MonsterDTO(String name, int hp, int str, int creditDrop, int stage) {
		this.name = name;
		this.hp = hp;
		this.str = str;
		this.creditDrop = creditDrop;
		this.stage = stage;
	}

	// Getter
	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getStr() {
		return str;
	}

	public int getCreditDrop() {
		return creditDrop;
	}

	public int getStage() {
		return stage;
	}

	// 전투 중 데미지 처리
	public void takeDamage(int damage) {
		hp -= damage;
		if (hp < 0)
			hp = 0;
		System.out.println(">> " + name + " 이(가) " + damage + "의 데미지를 입었습니다! (남은 HP: " + hp + ")");
	}

	// 상태 출력
	public void showStatus() {
		System.out.println("[몬스터]\t이름:\t" + name + "\t|\t체력:\t" + hp + "\t|\t공격력:\t" + str + "\t|\t보상 credit:\t" + creditDrop);
	}

	// 생존 여부
	public boolean isAlive() {
		return hp > 0;
	}
}
