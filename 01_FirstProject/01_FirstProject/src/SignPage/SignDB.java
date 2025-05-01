package SignPage;

import java.util.Scanner;

import Game.StartGame;

public class SignDB {
    UserDAO userDAO = new UserDAO();
    private final Scanner sc = new Scanner(System.in);

    // 1. 로그인
    public void login() {
        StartGame sg = new StartGame();
        
        System.out.print("ID: ");
        String loginId = sc.next();
        System.out.print("PW: ");
        String loginPw = sc.next();

        if (userDAO.login(loginId, loginPw)) {
            System.out.println(">> 로그인 성공!");
            System.out.flush();
            while (true) {
                System.out.println("\n== 로그인 메뉴 ==");
                System.out.println("1. 로그아웃");
                System.out.println("2. 회원탈퇴");
                System.out.println("3. 닉네임 변경");
                System.out.println("4. 게임 시작");
                System.out.print("선택: ");
                String subChoice = sc.next();

                if (subChoice.equals("1")) {
                    System.out.println(">> 로그아웃되었습니다.");
                    break;
                } else if (subChoice.equals("2")) {
                    userDAO.deleteUser(loginId);
                    break; // 탈퇴 후 로그아웃
                } else if (subChoice.equals("3")) {
                    userDAO.updateName(loginId);
                    continue;
                } else if (subChoice.equals("4")) {
                    sg.startgame(loginId);
                }
            }
        } else {
            System.out.println(">> 로그인 실패. 아이디나 비밀번호를 확인하세요.");
        }
    }

    // 2. 회원가입
    public void signUp() {
        System.out.print("새 ID: ");
        String newId = sc.next();
        System.out.print("비밀번호: ");
        String newPw = sc.next();
        System.out.print("캐릭터명: ");
        String name = sc.next();

        userDAO.insertUser(newId, newPw, name);
    }

    // 3. 비밀번호 찾기
    public void resetPassword() {
        System.out.print("비밀번호를 변경할 ID 입력: ");
        String resetId = sc.next();
        System.out.print("새 비밀번호 입력: ");
        String newPassword = sc.next();

        userDAO.resetPassword(resetId, newPassword);
    }
}
