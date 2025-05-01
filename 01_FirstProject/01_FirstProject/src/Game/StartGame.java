package Game;

import java.util.Scanner;

import SignPage.SignDB;

// 게임 시작
public class StartGame {
	private GameDAO dao = new GameDAO();
	Scanner sc = new Scanner(System.in);
	SignDB signdb = new SignDB();

	// 시작 화면 출력
	public void start() {
		while (true) {
			System.out.println("\n== 회원 가입 ==");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 비밀번호 찾기");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택: ");
			System.out.flush();
			String choice = sc.next();

			switch (choice) {
			case "1":
				signdb.login(); // 1. 로그인
				break;
			case "2":
				signdb.signUp(); // 2. 회원가입
				break;
			case "3":
				signdb.resetPassword(); // 3. 비밀번호 변경
				break;
			case "0": // 0. 프로그램 종료
				System.out.println(">> 프로그램을 종료합니다.");
				sc.close();
				return;
			default:
				System.out.println(">> 잘못된 입력입니다. 다시 선택해주세요.");
				break;
			}

		}
	}

	// USER 정보 출력
	public void user_Info(String id) {
		UserDTO user = dao.getUserInfo(id);
		System.out.flush();
	    System.out.println("┌───────────────────────────────┐");
	    System.out.println("│         [ 캐릭터 정보 ]        \t│");
	    System.out.println("├───────────────────────────────┤");
	    System.out.printf("│ %-8s:  %-15s \t│\n", "이름", user.getName());
	    System.out.printf("│ %-8s:  %-15d \t│\n", "힘", user.getStr());
	    System.out.printf("│ %-8s:  %-15d \t│\n", "체력", user.getHp());
	    System.out.printf("│ %-8s:  %-15d \t│\n", "무기 레벨", user.getSword());
	    System.out.printf("│ %-8s:  %-15d \t│\n", "갑옷 레벨", user.getArmor());
	    System.out.printf("│ %-8s:  %-15d \t│\n", "골드", user.getCredit());
	    System.out.printf("│ %-8s:  %-15d \t│\n", "스테이지", user.getStage());
	    System.out.println("└───────────────────────────────┘");
	    System.out.flush();
	}

	// 로그인 후 4.게임시작 누르면 실행
	public void startgame(String id) {
		UserDTO user = dao.getUserInfo(id);
		if (user == null) {
			System.out.println(">> 캐릭터 정보를 찾을 수 없습니다.");
			return;
		}

		user_Info(id);
		// 게임 시작 메뉴
		Enchant enc = new Enchant();
		Battle bt = new Battle();
		while (true) {
			System.out.println("┌────────────────────────────────┐");
			System.out.printf ("│         == Stage %-3d ==        │\n", user.getStage());
			System.out.println("├────────────────────────────────┤");
			System.out.println("│ 1. 전투                    \t │");
			System.out.println("│ 2. 강화                    \t │");
			System.out.println("│ 3. 랭킹 확인               \t │");
			System.out.println("│ 0. 저장하기                \t │");
			System.out.println("└────────────────────────────────┘");

			System.out.print("선택: ");
			String choice = sc.next();

			if (choice.equals("1")) {
				System.out.println(">> 전투를 선택했습니다!");
				user = dao.getUserInfo(id);
				UserDTO player = new UserDTO(user.getName(), user.getCredit(), 
						user.getSword(), user.getStr(),
						user.getArmor(), user.getHp(), user.getStage(), user.getRank());

				bt.battle(player, id);

				user = dao.getUserInfo(id);
				user_Info(id);
				continue;

			} else if (choice.equals("2")) { // 강화 로직
				while (true) {
					user = dao.getUserInfo(id);
					System.out.println("┌────────────────────────────────┐");
					System.out.printf("│         == 강화 메뉴 ==        \t │\n");
					System.out.println("├────────────────────────────────┤");
					System.out.printf("│ 현재 크레딧 : %-10d       \t │\n", user.getCredit());
					System.out.printf("│ 1. 무기 강화(50%%) : %-5d   \t │\n", user.getSword());
					System.out.printf("│ 2. 방어구 강화(50%%) : %-5d   \t │\n", user.getArmor());
					System.out.println("│ 3. 목표까지 강화(50%)        \t │");
					System.out.println("│ 0. 그만두기               \t │");
					System.out.println("└────────────────────────────────┘");
					System.out.print("선택: ");
					String enhanceChoice = sc.next();
					
					if (enhanceChoice.equals("1")) {
						System.out.println("현재 강화 : " + user.getSword());
						enc.enhanceWeapon(id); // 무기 강화
					} else if (enhanceChoice.equals("2")) {
						System.out.println("현재 강화 : " + user.getArmor());
						enc.enhanceArmor(id); // 방어구 강화
					} else if(enhanceChoice.equals("3")) {
						System.out.println("┌────────────────────────────────┐");
						System.out.printf("│         == 연속 강화 메뉴 ==    \t │\n");
						System.out.println("├────────────────────────────────┤");
						System.out.printf("│ 현재 크레딧 : %-10d       \t │\n", user.getCredit());
						System.out.printf("│ 1. 무기 강화(50%%) : %-5d   \t │\n", user.getSword());
						System.out.printf("│ 2. 방어구 강화(50%%) : %-5d   \t │\n", user.getArmor());
						System.out.println("│ 0. 그만두기               \t │");
						System.out.println("└────────────────────────────────┘");
						System.out.print("선택: ");
						String targetChoice = sc.next();
			            
			            if (targetChoice.equals("1")) { // 무기 강화 목표 설정
			            	System.out.println("현재 강화 : " + user.getSword());
			                System.out.print("몇 강까지 강화하시겠습니까? : ");
			                int targetLevel = sc.nextInt();
			                enc.enhanceWeaponRepeat(id, targetLevel); // 무기 목표 강화
			            } else if (targetChoice.equals("2")) { // 방어구 강화 목표 설정
			            	System.out.println("현재 강화 : " + user.getArmor());
			                System.out.print("몇 강까지 강화하시겠습니까? : ");
			                int targetLevel = sc.nextInt();
			                enc.enhanceArmorRepeat(id, targetLevel); // 방어구 목표 강화
			            } else if(enhanceChoice.equals("0")) {
							System.out.println(">> 강화 메뉴를 종료하고 이전으로 돌아갑니다.");
							user_Info(id); // 강화 종료 후 정보 출력
							break;
							} else {
			                System.out.println("❗ 잘못된 입력입니다.");
			            }
					} else if (enhanceChoice.equals("0")) {
						System.out.println(">> 강화 메뉴를 종료하고 이전으로 돌아갑니다.");
						user_Info(id); // 강화 종료 후 정보 출력
						break;
					} else {
						System.out.println("❗ 잘못된 입력입니다. 다시 선택하세요.");
					}
				}
			}else if (choice.equals("3")) {
					
					System.out.println("현재 랭킹 : " +user.rank);

			} else if (choice.equals("0")) { // 저장
				saveGame(id);
				System.out.println(">> 게임 상태가 저장되었습니다. 로그인 메뉴로 돌아갑니다.");
				user_Info(id);
				break;
			} else {
				System.out.println("❗ 잘못된 입력입니다. 다시 선택하세요.");
			}
		}
	}

	// 게임 저장
	public void saveGame(String id) {
		UserDTO user = dao.getUserInfo(id);
		if (user != null) {
			System.out.println("저장된 캐릭터 상태:");
			user_Info(id);
		}
	}
}
