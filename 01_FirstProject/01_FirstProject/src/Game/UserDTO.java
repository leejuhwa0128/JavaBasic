package Game;

public class UserDTO {
	String name;
	int credit;
	int sword;
	int str;
	int armor;
	int hp;
	int stage;
	int rank;
	// 생성자
	public UserDTO(String name, int credit, int sword, int str, int armor, int hp, int stage, int rank) {
		this.name = name;
		this.credit = credit;
		this.sword = sword;
		this.str = str;
		this.armor = armor;
		this.hp = hp;
		this.stage = stage;
		this.rank = rank;
	}

	// Getter 메소드들
	public String getName() {
		return name;
	}

	public int getCredit() {
		return credit;
	}

	public int getSword() {
		return sword;
	}

	public int getStr() {
		return str;
	}

	public int getArmor() {
		return armor;
	}

	public int getHp() {
		return hp;
	}

	public int getStage() {
		return stage;
	}
	
	public int getRank() {
		return rank;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public void showStatus() {
		System.out.println("[유저]\t이름:\t" + name + "\t|\t체력:\t" + hp + "\t|\t공격력:\t" + str);
	}

	public void addCredit(int amount) {
		credit += amount;
	}

	public void PlayertakeDamage(int damage) {
		hp -= damage;
		if (hp < 0)
			hp = 0;
		System.out.println(name + " 이(가) " + damage + " 데미지를 입었습니다! [남은 체력: " + hp +"]");
	}

	// 플레이어가 살아 있는지 여부
	public boolean isAlive() {
		return hp > 0;
	}
}
