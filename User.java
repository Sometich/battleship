package battleship;

import java.util.Scanner;

public class User {
    private int countHits;
    private int healthOfAircraft;
    private int[][] aircraft = new int[2][5];
    private int healthOfBattleship;
    private int[][] battleship = new int[2][4];
    private int healthOfSubmarine;
    private int[][] submarine = new int[2][3];
    private int healthOfCruiser;
    private int[][] cruiser = new int[2][3];
    private int healthOfDestroyer;
    private int[][] destroyer = new int[2][2];
    private boolean flagWinner = false;
    Scanner scanner = new Scanner(System.in);
    private String[][] board = new String[][]{{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " "},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};

    private String[][] copyBoard = new String[][]{{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " "},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}};

    public boolean isFlagWinner() {
        return flagWinner;
    }

    public int getCountHits() {
        return countHits;
    }

    public String[][] getBoard() {
        return board;
    }

    public String[][] getCopyBoard() {
        return copyBoard;
    }

    public User() {
        showBoard(board);
        enterGame();
    }

    public void showBoard(String[][] boardCopy) {
        for (String[] strings : boardCopy) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private boolean checkArray(int[][] coordinatesShip, int x, int y) {
        for(int i = 0; i < coordinatesShip[0].length; i++) {
            if (coordinatesShip[0][i] == x && coordinatesShip[1][i] == y) {
                return true;
            }
        }
        return false;
    }

    private void checkHit(int x, int y) {
        countHits++;
        if (checkArray(aircraft, x, y)) {
            healthOfAircraft--;
        } else if(checkArray(battleship, x, y)) {
            healthOfBattleship--;
        } else if(checkArray(submarine, x, y)) {
            healthOfSubmarine--;
        } else if(checkArray(cruiser, x, y)) {
            healthOfCruiser--;
        } else {
            healthOfDestroyer--;
        }
    }
    private void checkWinner() {
        if (countHits == 17) {
            flagWinner = true;
        } else if (healthOfDestroyer == 0) {
            System.out.println("You sank a ship! Specify a new target:");
            healthOfDestroyer = -1;
        } else if(healthOfCruiser == 0) {
            healthOfCruiser = -1;
            System.out.println("You sank a ship! Specify a new target:");
        } else if(healthOfSubmarine == 0) {
            healthOfSubmarine = -1;
            System.out.println("You sank a ship! Specify a new target:");
        } else if(healthOfBattleship == 0) {
            healthOfBattleship = -1;
            System.out.println("You sank a ship! Specify a new target:");
        } else if(healthOfAircraft == 0) {
            healthOfAircraft = -1;
            System.out.println("You sank a ship! Specify a new target:");
        } else {
            System.out.println("You hit a ship! Try again:");
        }
    }

    private void enterGame() {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        healthOfAircraft = 5;
        instalShip("Aircraft Carrier", 5, 1);
        showBoard(board);
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        healthOfBattleship = 4;
        instalShip("Battleship", 4, 2);
        showBoard(board);
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        healthOfSubmarine = 3;
        instalShip("Submarine", 3, 3);
        showBoard(board);
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        healthOfCruiser = 3;
        instalShip("Cruiser", 3, 4);
        showBoard(board);
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        healthOfDestroyer = 2;
        instalShip("Destroyer", 2, 5);
        showBoard(board);
    }

    private void instalShip(String name, int length, int arrayNumber) {
        while (true) {
            String coordinatesStart = scanner.next();
            String coordinatesEnd = scanner.next();
            System.out.println("> " + coordinatesStart + " " + coordinatesEnd);
            char[] arrayStart = coordinatesStart.toCharArray();
            char[] arrayEnd = coordinatesEnd.toCharArray();

            int x1;
            int x2;

            int y1 = arrayStart[0] % 10 == 4 ? 10 : (arrayStart[0] - 4) % 10;
            int y2 = arrayEnd[0] % 10 == 4 ? 10 : (arrayEnd[0] - 4) % 10;

            if (coordinatesStart.length() > 2) {
                x1 = 10;
            } else {
                x1 = Integer.parseInt(String.valueOf(arrayStart[1]));
            }
            if (coordinatesEnd.length() > 2) {
                x2 = 10;
            } else {
                x2 = Integer.parseInt(String.valueOf(arrayEnd[1]));
            }

            int count = -2;
            if (x1 > x2 && x1 - x2 + 1 != length && y1 == y2 || x2 > x1 && x2 - x1 + 1 != length && y1 == y2 ||
                    y1 > y2 && y1 - y2 + 1 != length && x1 == x2 || y2 > y1 && y2 - y1 + 1 != length && x1 == x2) {
                System.out.println("Error! Wrong length of the " + name + "! Try again:");
            } else if (y1 < y2 && x1 == x2) {
                for (int i = y1 - 1; i <= y2 + 1; i++) {
                    if (board[i][x1].equals("O") || board[i][x1 - 1].equals("O") || board[i][x1 + 1].equals("O")) {
                        count--;
                    } else {
                        count++;
                    }
                }
                if(count == length) {
                    int counter = 0;
                    for (int i = y1; i <= y2; i++) {
                        board[i][x1] = "O";
                        if (arrayNumber == 1) {
                            aircraft[0][counter] = x1;
                            aircraft[1][counter] = i;
                        } else if (arrayNumber == 2) {
                            battleship[0][counter] = x1;
                            battleship[1][counter] = i;
                        } else if(arrayNumber == 3) {
                            submarine[0][counter] = x1;
                            submarine[1][counter] = i;
                        } else if(arrayNumber == 4) {
                            cruiser[0][counter] = x1;
                            cruiser[1][counter] = i;
                        } else {
                            destroyer[0][counter] = x1;
                            destroyer[1][counter] = i;
                        }
                        counter++;
                    }
                    break;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else if (y1 > y2 && x1 == x2) {
                for (int i = y2 - 1; i <= y1 + 1; i++) {
                    if (board[i][x1].equals("O") || board[i][x1 - 1].equals("O") || board[i][x1 + 1].equals("O")) {
                        count--;
                    } else {
                        count++;
                    }
                }
                if(count == length) {
                    for (int i = y2; i <= y1; i++) {
                        board[i][x1] = "O";
                    }
                    break;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else if (y1 == y2 && x1 < x2) {
                for (int i = x1 - 1; i <= x2 + 1; i++) {
                    if (board[y1 + 1][i].equals("O") || board[y1 - 1][i].equals("O") || board[y1][i].equals("O")) {
                        count--;
                    } else {
                        count++;
                    }
                }
                if(count == length) {
                    for (int i = x1; i <= x2; i++) {
                        board[y1][i] = "O";
                    }
                    break;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else if (y1 == y2 && x2 < x1) {
                for (int i = x2 - 1; i <= x1  + 1; i++) {
                    if (board[y1 + 1][i].equals("O") || board[y1 - 1][i].equals("O") || board[y1][i].equals("O")) {
                        count--;
                    } else {
                        count++;
                    }
                }
                if(count == length) {
                    for (int i = x2; i <= x1; i++) {
                        board[y1][i] = "O";
                    }
                    break;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else {
                System.out.println("Error! Wrong ship location! Try again:");
            }
        }
    }

    public void hitShip() {
        while (true) {
            String coordinates = scanner.next();
            System.out.println("> " + coordinates);
            char[] arrayStart = coordinates.toCharArray();
            int x1;
            int y1;
            if (arrayStart[0] < 65 || arrayStart[0] > 74) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            } else {
                y1 = arrayStart[0] % 10 == 4 ? 10 : (arrayStart[0] - 4) % 10;
            }
            if(coordinates.length() > 3) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            } else if (coordinates.length() == 3) {
                String numberString = arrayStart[1] + "" + arrayStart[2];
                if (Integer.parseInt(numberString) == 10) {
                    x1 = 10;
                } else {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }
            } else {
                x1 = Integer.parseInt(String.valueOf(arrayStart[1]));
            }
            if (x1 >= 1 && x1 <= 10 && y1 >= 1 && y1 <= 10) {
                if (board[y1][x1].equals("X")) {
                    System.out.println("You hit a ship!");
                    break;
                } else if (board[y1][x1].equals("O")) {
                    board[y1][x1] = "X";
                    copyBoard[y1][x1] = "X";
                    checkHit(x1, y1);
                    checkWinner();
                    break;
                } else {
                    board[y1][x1] = "M";
                    copyBoard[y1][x1] = "M";
                    System.out.println("You missed!");
                    break;
                }
            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
    }

}
