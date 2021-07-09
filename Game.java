package battleship;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        User user1 = new User();
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
        System.out.println("...");
        User user2 = new User();
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
        while (true) {
            user1.showBoard(user2.getCopyBoard());
            System.out.println("------------");
            user1.showBoard(user1.getBoard());
            System.out.println("Player 1, it's your turn:");
            user2.hitShip();
            if (user2.isFlagWinner()) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                break;
            }
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();
            user2.showBoard(user1.getCopyBoard());
            System.out.println("------------");
            user2.showBoard(user2.getBoard());
            System.out.println("Player 2, it's your turn:");
            user1.hitShip();
            if (user1.isFlagWinner()) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                break;
            }
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();
        }
    }
}
