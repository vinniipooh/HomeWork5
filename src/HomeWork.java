import java.util.Random;
import java.util.Scanner;

/**
 * Created by Александр on 02.04.2017.
 */
public class HomeWork {
    private static char array[][] = new char[3][3];
    private static byte PCwin = 0, PClose = 0, User1win = 0, User2win = 0, User1lose = 0, User2lose = 0;

    private static int user = 0, pc = 0;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    private static void Table() {
        String border = " -------------";
        String vertical = " | ";

        System.out.println(border);
        System.out.println(vertical + array[0][0] + vertical + array[0][1] + vertical + array[0][2] + vertical);
        System.out.println(border);
        System.out.println(vertical + array[1][0] + vertical + array[1][1] + vertical + array[1][2] + vertical);
        System.out.println(border);
        System.out.println(vertical + array[2][0] + vertical + array[2][1] + vertical + array[2][2] + vertical);
        System.out.println(border);
    }

    private static void Statistic() {

        String line = "----------------------------------------------";
        String vertical = " | ";

        System.out.println("          " + vertical + "\tИгрок 1" + vertical + "\tИгрок 2" + vertical + "\tPC\t" + vertical);
        System.out.println(line);
        System.out.println("Победы    " + vertical + "\t  " + User1win + "\t   " +
                vertical + "\t  " + User2win + "    " + vertical + "\t" + PCwin + "\t" + vertical);
        System.out.println(line);
        System.out.println("Поражения " + vertical + "\t  " + User1lose + "\t   " +
                vertical + "\t  " + User2lose + "    " + vertical + "\t" + PClose + "\t" + vertical);
        System.out.println(line);
    }

    private static boolean check(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 'X' && array[i][1] == 'X' && array[i][2] == 'X') {
                user++;
                return true;
            }
            if (array[i][0] == 'O' && array[i][1] == 'O' && array[i][2] == 'O') {
                pc++;
                return true;

            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[0][j] == 'X' && array[1][j] == 'X' && array[2][j] == 'X') {
                    user++;
                    return true;

                }
                if (array[0][j] == 'O' && array[1][j] == 'O' && array[2][j] == 'O') {
                    pc++;
                    return true;

                }
            }
        }
        if (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X') {
            user++;
            return true;

        }
        if (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O') {
            pc++;
            return true;

        }

        if (array[2][0] == 'X' && array[1][1] == 'X' && array[0][2] == 'X') {
            user++;
            return true;

        }
        if (array[2][0] == 'O' && array[1][1] == 'O' && array[0][2] == 'O') {
            pc++;
            return true;

        }
        return false;
    }

    public static void main(String args[]) {

        int x = 0, y = 0;
        byte win = 0;
        boolean flag = true;
        byte choice = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ' ';
            }
        }


        for (; choice != 4; ) {
            System.out.println("Выюерите режим:\n1)Против PC\n2)Против другого игрока\n3)Статистика\n4)Для выхода");
            choice = scanner.nextByte();

            switch (choice) {
                case 1:
                    System.out.println("До скольки побед раунд: ");
                    win = scanner.nextByte();

                    for (; ; ) {//вся игра
                        flag = true;

                        for (; flag; ) { //для одного раунда
                            Table();

                            System.out.println("Выберите строку и столбец:");
                            x = scanner.nextInt();
                            y = scanner.nextInt();

                            if (array[x - 1][y - 1] == ' ') {// проверка правильности ввода

                                array[x - 1][y - 1] = 'X';

                                for (; ; ) { // проверка правильности ввода компьютера
                                    x = random.nextInt(3);
                                    y = random.nextInt(3);
                                    if (array[x][y] == ' ') {
                                        array[x][y] = 'O';
                                        break;
                                    } else continue;
                                }

                                if (check(array)) {
                                    System.out.println("Раунд заакончен. ");
                                    System.out.println("Игрок 1: " + user + "\nPC: " + pc);
                                    flag = false;

                                    for (int i = 0; i < array.length; i++) {
                                        for (int j = 0; j < array[i].length; j++) {
                                            array[i][j] = ' ';
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Неправельный выбор, повторите.");
                                continue;
                            }
                        }

                        if (pc == win) {
                            pc = 0;
                            user = 0;
                            PCwin++;
                            User1lose++;
                            break;
                        } else if (user == win) {
                            pc = 0;
                            user = 0;
                            PClose++;
                            User1win++;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Выберите количевство побед: ");
                    win = scanner.nextByte();

                    for (; ; ) {
                        flag = true;

                        for (; flag; ) {
                            Table();

                            System.out.println("Игрок 1 выберите строку и столбец:");
                            x = scanner.nextInt();
                            y = scanner.nextInt();

                            if (array[x - 1][y - 1] == ' ') {
                                array[x - 1][y - 1] = 'X';

                                if (check(array)) {
                                    System.out.println("Раунд окончен. ");
                                    System.out.println("Игрок 1: " + user + "\nИгрок 2: " + pc);
                                    flag = false;

                                    for (int i = 0; i < array.length; i++) {
                                        for (int j = 0; j < array[i].length; j++) {
                                            array[i][j] = ' ';
                                        }
                                    }
                                    break;
                                }

                                for (; ; ) {
                                    Table();

                                    System.out.println("Игрок 2 выберите строку и столбец:");
                                    x = scanner.nextInt();
                                    y = scanner.nextInt();

                                    if (array[x - 1][y - 1] == ' ') {
                                        array[x - 1][y - 1] = 'O';
                                        break;
                                    } else {
                                        System.out.println("Неправельный выбор, повторите.");
                                        continue;
                                    }
                                }

                                if (check(array)) {
                                    System.out.println("Раунд окончен. ");
                                    System.out.println("Игрок 1: " + user + "\nИгрок 2: " + pc);
                                    flag = false;

                                    for (int i = 0; i < array.length; i++) {
                                        for (int j = 0; j < array[i].length; j++) {
                                            array[i][j] = ' ';
                                        }
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("Неправельный выбор, повторите.");
                                continue;
                            }
                        }

                        if (pc == win) {
                            pc = 0;
                            user = 0;
                            User2win++;
                            User1lose++;
                            break;
                        } else if (user == win) {
                            pc = 0;
                            user = 0;
                            User2lose++;
                            User1win++;
                            break;
                        }

                    }
                    break;
                case 3:
                    Statistic();
                default:
                    break;
            }
            if (choice == 2) {
                System.out.println(pc > user ? "Игрок 2 победил" : "Игрок 1 победил.");
            }
            if (choice == 1)
                System.out.println(pc > user ? "PC победил" : "Игрок 1 победил.");
        }
    }
}