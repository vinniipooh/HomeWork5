import java.util.Random;
import java.util.Scanner;

/**
 * Created by Александр on 07.04.2017.
 */
public class Tic_tac_toe_v02 {
    //Добавлен лёгкий ввод и больше ООП :)

    private static byte PCwin = 0, PClose = 0, User1win = 0, User2win = 0, User1lose = 0, User2lose = 0;// счётчик побед общих
    private static int winner = 0;

    private static int x = 0, y = 0;//координаты для лёгкого ввода

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);


    private static char[][] ResetArray(char ar[][]) {
        char symbol = '1';
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = symbol;
                symbol++;
            }
        }
        return ar;
    }

    private static void Table(char ar[][]) {
        String border = " -------------";
        String vertical = " | ";

        System.out.println(border);
        System.out.println(vertical + ar[0][0] + vertical + ar[0][1] + vertical + ar[0][2] + vertical);
        System.out.println(border);
        System.out.println(vertical + ar[1][0] + vertical + ar[1][1] + vertical + ar[1][2] + vertical);
        System.out.println(border);
        System.out.println(vertical + ar[2][0] + vertical + ar[2][1] + vertical + ar[2][2] + vertical);
        System.out.println(border);
    }

    private static boolean WinCheck(char[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i][0] == 'X' && ar[i][1] == 'X' && ar[i][2] == 'X') {
                winner = 1;
                return true;
            }
            if (ar[i][0] == 'O' && ar[i][1] == 'O' && ar[i][2] == 'O') {
                winner = 2;
                return true;

            }
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[0][j] == 'X' && ar[1][j] == 'X' && ar[2][j] == 'X') {
                    winner = 1;
                    return true;

                }
                if (ar[0][j] == 'O' && ar[1][j] == 'O' && ar[2][j] == 'O') {
                    winner = 2;
                    return true;

                }
            }
        }
        if (ar[0][0] == 'X' && ar[1][1] == 'X' && ar[2][2] == 'X') {
            winner = 1;
            return true;

        }
        if (ar[0][0] == 'O' && ar[1][1] == 'O' && ar[2][2] == 'O') {
            winner = 2;
            return true;

        }

        if (ar[2][0] == 'X' && ar[1][1] == 'X' && ar[0][2] == 'X') {
            winner = 1;
            return true;

        }
        if (ar[2][0] == 'O' && ar[1][1] == 'O' && ar[0][2] == 'O') {
            winner = 2;
            return true;

        }
        return false;
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

    private static void EasyEnter(int a) {

        switch (a) {
            case 1:
                x = 0;
                y = 0;
                break;
            case 2:
                x = 0;
                y = 1;
                break;
            case 3:
                x = 0;
                y = 2;
                break;
            case 4:
                x = 1;
                y = 0;
                break;
            case 5:
                x = 1;
                y = 1;
                break;
            case 6:
                x = 1;
                y = 2;
                break;
            case 7:
                x = 2;
                y = 0;
                break;
            case 8:
                x = 2;
                y = 1;
                break;
            case 9:
                x = 2;
                y = 2;
                break;
        }
    }

    private static boolean CheckEnter(char ar[][]) {
        if (ar[x][y] != 'X' && ar[x][y] != 'O') return true;
        else return false;
    }

    private static void EndStep(int a) {
        if (winner == 1) {
            System.out.println("Игрок 1 победил");
            if (a == 1) {
                PClose++;
                User1win++;
            } else if (a == 2) {
                User1win++;
                User2lose++;
            }
        } else if (winner == 2 && a == 1) {
            System.out.println("PC победил");
            PCwin++;
            User1lose++;
        } else if (winner == 2 && a == 2) {
            System.out.println("Игрок 2 победил");
            User2win++;
            User1lose++;
        }
    }

    private static boolean CheckDraw(char ar[][]) {
        int counter = 0;

        for (char m[] :
                ar) {
            for (char n :
                    m) {
                if (n == 'X' || n == 'O') counter++;
            }

        }

        if (counter == 9) return true;
        else return false;
    }

    public static void main(String args[]) {
        char array[][] = new char[3][3];
        boolean flag = true;
        byte choice = 0, Turn = 0;

        ResetArray(array);
        try {
            for (; choice != 4; ) {
                winner = 0;

                System.out.println("Выюерите режим:\n1)Против PC\n2)Против другого игрока\n3)Статистика\n4)Для выхода");

                choice = scanner.nextByte();


                switch (choice) {
                    case 1:
                        for (; ; ) { //для одного раунда
                            Table(array);

                            System.out.println("Выберите клетку (1-9)");
                            Turn = scanner.nextByte();
                            EasyEnter(Turn);

                            if (CheckEnter(array)) {
                                array[x][y] = 'X';


                                if (WinCheck(array)) {
                                    ResetArray(array);
                                    break;
                                } else if (CheckDraw(array)) {
                                    System.out.println("Ничья!");
                                    ResetArray(array);
                                    break;
                                }

                                for (; ; ) { // проверка правильности ввода компьютера
                                    x = random.nextInt(3);
                                    y = random.nextInt(3);
                                    if (array[x][y] != 'X' && array[x][y] != 'O') {
                                        array[x][y] = 'O';
                                        break;
                                    } else continue;
                                }
                                if (WinCheck(array)) {
                                    ResetArray(array);
                                    break;
                                } else continue;


                            } else {
                                System.out.println("Неправельный ввод.");
                                continue;
                            }
                        }
                        EndStep(choice);
                        break;

                    case 2:
                        for (; ; ) {
                            Table(array);//выводит таблицу

                            //ход игрока 1
                            System.out.println("Игрок 1 выберите клетку (1-9)");
                            Turn = scanner.nextByte();
                            EasyEnter(Turn);

                            if (CheckEnter(array)) {//проверка хода
                                array[x][y] = 'X';


                                if (WinCheck(array)) {
                                    ResetArray(array);
                                    break;//проверка выйграша
                                } else if (CheckDraw(array)) {
                                    System.out.println("Ничья!");
                                    ResetArray(array);
                                    break;
                                }

                                for (; ; ) {
                                    Table(array);

                                    System.out.println("Игрок 2 выберите клетку (1-9)");
                                    Turn = scanner.nextByte();
                                    EasyEnter(Turn);

                                    if (CheckEnter(array)) {
                                        array[x][y] = 'O';
                                        break;
                                    } else {
                                        System.out.println("Неправельный ввод.");
                                        continue;
                                    }
                                }
                                if (WinCheck(array)) {
                                    ResetArray(array);
                                    break;
                                } else continue;


                            } else {
                                System.out.println("Неправельный ввод.");
                                continue;
                            }
                        }

                        EndStep(choice);
                        break;

                    case 3:
                        Statistic();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Неправельный ввод");
                        continue;

                }
            }
        } catch (Exception e) {
            System.out.println("Ты смухлевал, Пока!");
        }
    }
}