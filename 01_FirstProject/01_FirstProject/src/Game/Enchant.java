package Game;

import java.util.Random;

public class Enchant {
	private GameDAO gameDAO = new GameDAO(); // 게임 관련 DB 작업을 담당하는 DAO
	private Random rand = new Random();      // 강화 성공 여부를 결정할 랜덤 객체
	
	// 무기 강화 메소드
	public void enhanceWeapon(String id) {
		UserDTO user = gameDAO.getUserInfo(id);
		if (user == null) {
			System.out.println("❗ 사용자 정보를 찾을 수 없습니다.");
			return;
		}

		int credit = user.getCredit();
		int sword = user.getSword();
		int str = user.getStr();

		final int final_sword = 0; // 기본 무기 강화 수치
		final int final_str = 10; // 기본 힘 수치(수정? : 스테이지마다 올라갈지말지)

		if (credit < 1) { // 강화 크레딧 부족
			System.out.println("크레딧이 부족합니다. (남은 크레딧: " + credit + ")");
			return;
		}
		boolean success = rand.nextBoolean(); // 50퍼 확률(true or false)

		if (success) { // 강화 성공시 TRUE
			sword++;
			str += 10;
			gameDAO.updateUserWeapon(id, credit, sword, str);
			System.out.println(">> 강화 성공! Sword +1 (현재 수치: sword+" + sword + ")");
			System.out.println("공격력 : " + str);
			
		} else { // 강화 실패시 FALSE
			sword = final_sword;
			str = final_str;
			gameDAO.updateUserWeapon(id, credit, sword, str);
			System.out.println(">> 무기 강화 실패... 무기 초기화! (현재 수치: " + sword + ")");
			System.out.println("공격력 : " + str);
		}
		// 크레딧 소모
		credit--;
		// 정보 업데이트
		gameDAO.updateUserWeapon(id, credit, sword, str);
		user = gameDAO.getUserInfo(id);
	}

	// 방어구 강화 메소드
	public void enhanceArmor(String id) {
		UserDTO user = gameDAO.getUserInfo(id);
		if (user == null) {
			System.out.println("❗ 사용자 정보를 찾을 수 없습니다.");
			return;
		}

		int credit = user.getCredit();
		int armor = user.getArmor();
		int hp = user.getHp();

		final int final_armor = 0; // 기본 방어구 강화 수치
		final int final_hp = 100; // 기본 hp 수치(수정? : 스테이지마다 올라갈지말지)

		if (credit < 1) { // 강화 크레딧 부족
			System.out.println("크레딧이 부족합니다. (남은 크레딧: " + credit + ")");
			return;
		}
		boolean success = rand.nextBoolean(); // 50% 확률 (TRUE OR FALSE)

		if (success) { // 성공 TRUE
			armor++;
			hp += 250;
			System.out.println(">> 강화 성공! Armor +1 (현재 수치: " + armor + ")");
			System.out.println("체력 : " + hp);
		} else { // 실패 FALSE
			armor = final_armor;
			hp = final_hp;
			System.out.println(">> 방어구 강화 실패... 방어구 초기화! (현재 수치: " + armor + ")");
			System.out.println("체력 : " + hp);
		}
		
		// 크레딧 소모
		credit--;
		// 정보 업데이트
		
		gameDAO.updateUserArmor(id, credit, armor, hp);
		user = gameDAO.getUserInfo(id);
	}

	// 무기 강화 반복
	public void enhanceWeaponRepeat(String id, int targetLevel) {
	    UserDTO user = gameDAO.getUserInfo(id);
	    if (user == null) {
	        System.out.println("❗ 사용자 정보를 찾을 수 없습니다.");
	        return;
	    }

	    int credit = user.getCredit();
	    int sword = user.getSword();
	    int str = user.getStr();
	    int initialCredit = credit; // 초기 크레딧 저장
	    final int baseSword = 0; // 무기 기본 수치
	    final int baseStr = 10;  // 힘 기본 수치
	    
	    if (credit < 1) { // 크레딧 부족
	        System.out.println("크레딧이 부족합니다.");
	        return;
	    }

	    System.out.println(">> 무기 강화가 시작됩니다!");

	    while (sword < targetLevel && credit > 0) {
	        System.out.println("현재 무기 레벨: " + sword);

	        boolean success = rand.nextBoolean(); // 50% 확률 (성공/실패)
	        if (success) {
	            sword++;
	            str += 10;
	            System.out.println(">> 무기 강화 성공! Sword +1 (현재 수치: " + sword + ")");
	            System.out.println("공격력 : " + str);
	        } else {
	            System.out.println(">> 무기 강화 실패... 무기 초기화!");
	            sword = baseSword;
	            str = baseStr;
	        }

	        // 크레딧 소모
	        credit--;
	        gameDAO.updateUserWeapon(id, credit, sword, str); // 무기 정보 업데이트
	        
	        try {
	            Thread.sleep(500); // 0.5초 대기
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        user = gameDAO.getUserInfo(id); // 업데이트된 사용자 정보 가져오기
	        credit = user.getCredit();

	        if (credit < 1) {
	            System.out.println(">> 크레딧이 부족하여 강화가 종료됩니다.");
	            break;
	        }
	    }
	    int consumedCredit = initialCredit - credit;
	    System.out.println(">> 강화 완료! 최종 무기 레벨: " + sword);
	    System.out.println(">> 소모된 크레딧: " + consumedCredit);
	    
	    System.out.println(">> 강화 완료! 최종 무기 레벨: " + sword);
	}
	
	
	public void enhanceArmorRepeat(String id, int targetLevel) {
	    UserDTO user = gameDAO.getUserInfo(id);
	    if (user == null) {
	        System.out.println("❗ 사용자 정보를 찾을 수 없습니다.");
	        return;
	    }

	    int credit = user.getCredit();
	    int armor = user.getArmor();
	    int hp = user.getHp();
	    int initialCredit = credit; // 초기 크레딧 저장
	    final int baseArmor = 0; // 무기 기본 수치
	    final int baseHp = 10;  // 힘 기본 수치
	    
	    if (credit < 1) { // 크레딧 부족
	        System.out.println("크레딧이 부족합니다.");
	        return;
	    }

	    System.out.println(">> 방어구 강화가 시작됩니다!");

	    while (armor < targetLevel && credit > 0) {
	        System.out.println("현재 방어구 레벨: " + armor);

	        boolean success = rand.nextBoolean(); // 50% 확률 (성공/실패)
	        if (success) {
	            armor++;
	            hp += 250;
	            System.out.println(">> 방어구 강화 성공! Armor +1 (현재 수치: " + armor + ")");
	            System.out.println("체력 : " + hp);
	        } else {
	        	System.out.println(">> 방어구 강화 실패... 방어구 초기화!");
	            armor = baseArmor;
	            hp = baseHp;
	        }

	        // 크레딧 소모
	        credit--;
	        gameDAO.updateUserArmor(id, credit, armor, hp); // 방어구 정보 업데이트
	        
	        try {
	            Thread.sleep(500); // 0.5초 대기
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        user = gameDAO.getUserInfo(id); // 업데이트된 사용자 정보 가져오기
	        credit = user.getCredit();

	        if (credit < 1) {
	            System.out.println(">> 크레딧이 부족하여 강화가 종료됩니다.");
	            break;
	        }
	    }
	    
	    int consumedCredit = initialCredit - credit;
	    System.out.println(">> 강화 완료! 최종 방어구 레벨: " + armor);
	    System.out.println(">> 소모된 크레딧: " + consumedCredit);
	    
	    System.out.println(">> 강화 완료! 최종 방어구 레벨: " + armor);
	}
	
}
