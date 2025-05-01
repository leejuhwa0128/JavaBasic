package Game;

import java.sql.SQLException;

public class Battle {

	public void battle(UserDTO player, String playerId) {
		GameDAO gameDAO = new GameDAO();
		MonsterDAO monsterDAO = new MonsterDAO();

		try {
			int stage = player.getStage();
			MonsterDTO monster = monsterDAO.getMonsterByStage(stage);

			if (monster == null) {
				System.out.println(">> 해당 스테이지에 해당하는 몬스터가 없습니다.");
				return;
			}

			// 스테이지에 따른 몬스터 능력치 증가
			double multiplier = 1.0;
			if (stage >= 11 && stage <= 20) {
				multiplier = 1.1;
			} else if (stage >= 21 && stage <= 30) {
				multiplier = 1.2;
			}

			int boostedHp = (int) (monster.getHp() * multiplier);
			int boostedStr = (int) (monster.getStr() * multiplier);
			int boostedCredit = (int) (monster.getCreditDrop() * multiplier);

			// 강화된 몬스터 객체 생성
			MonsterDTO boostedMonster = new MonsterDTO(monster.getName(), boostedHp, boostedStr, boostedCredit, stage);

			boolean playerWon = false;
			
		    MonsterPrinter.printMonsterBattleScreen(boostedMonster.getName());
			
			System.out.println("===== 전투 시작 =====");
			player.showStatus();
			System.out.println("====================");
			boostedMonster.showStatus();
			System.out.println("====================");

			while (player.isAlive() && boostedMonster.isAlive()) {
				System.out.println("\n>> " + player.getName() + " 의 턴!");
				 Thread.sleep(500); // 0.5초 대기
				boostedMonster.takeDamage(player.getStr());

				if (!boostedMonster.isAlive()) {
					System.out.println(boostedMonster.getName() + " 을(를) 처치했습니다!");
					System.out.println("획득한 크레딧: " + boostedMonster.getCreditDrop());
					player.addCredit(boostedMonster.getCreditDrop());

					System.out.println("현재 체력 : " + player.getHp());

					playerWon = true;
					break;
				}

				System.out.println("\n>> " + boostedMonster.getName() + " 의 턴!");
				 Thread.sleep(500); // 0.5초 대기
				player.PlayertakeDamage(boostedMonster.getStr());

				if (!player.isAlive()) {
					System.out.println(player.getName() + " 이(가) 쓰러졌습니다...");
				}
			}

			// 전투 결과 저장
			gameDAO.updateUserArmor(playerId, player.getCredit(), player.getArmor(), player.getHp());

			if (playerWon) {
				if (stage == 100) {
					gameDAO.updateMaxStage(playerId, stage);
					gameDAO.updateUserRanks();
					
					System.out.println("\n축하합니다! 100 스테이지를 모두 클리어하셨습니다!");
					System.out.println(">> 현재 랭킹: " + player.getRank() + "위");
					
					gameDAO.updateStage(playerId, 1); // 다음 전투를 1스테이지로
					gameDAO.updateUserArmor(playerId, player.getCredit(), 0, 100); // 갑옷 초기화, 체력 회복
					gameDAO.updateUserWeapon(playerId, 1000, 0, 10); // 무기 초기화

					System.out.println(">> 1스테이지부터 다시 도전해보세요!");
				} else {
					int nextStage = stage + 1;
					gameDAO.updateStage(playerId, nextStage);
					int max_hp = 100 + (player.getArmor() * 250);
					gameDAO.updateUserArmor(playerId, player.getCredit(), player.getArmor(), max_hp); // id, credit armor hp
					System.out.println(">> 스테이지 클리어! 다음 스테이지: " + nextStage);
					System.out.println(">> 현재 랭킹: " + player.getRank() + "위");
				}
			} else {
				// 최고 스테이지 저장
				try {
					gameDAO.updateMaxStage(playerId, stage);
				} catch (SQLException e) {
					System.out.println("최고 스테이지 갱신 중 오류 발생: " + e.getMessage());
					e.printStackTrace();
				}

				gameDAO.updateStage(playerId, 1);
				gameDAO.updateUserArmor(playerId, player.getCredit(), 0, 100); // 갑옷 초기화, 체력 회복
				gameDAO.updateUserWeapon(playerId, player.getCredit(), 0, 10); // 무기 초기화
				System.out.println(">> 전투 실패. 스테이지가 1로 초기화됩니다.");

				// 랭킹 갱신
				try {
					gameDAO.updateUserRanks();
				} catch (Exception e) {
					System.out.println("랭킹 갱신 중 오류 발생: " + e.getMessage());
					e.printStackTrace();
				}
			}

			System.out.println("===== 전투 종료 =====");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("전투 중 예외가 발생했습니다.");
		}
	}

}
