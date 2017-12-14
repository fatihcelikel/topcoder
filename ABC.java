/**
 * Problem Statement
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 * <p>
 * The string has exactly N characters, each of which is either 'A', 'B' or 'C'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] < s[j].
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 *
 * @author fatih celikel
 */
public class ABC {

    private static boolean debug = false;

    private char[] chars;

    public static void main(String[] args) {
        int length = 30;
        int goal = 298;
        String s = new ABC().createString(length, goal);
        System.out.println(s);
    }

    public String createString(int length, int goal) {
        chars = new char[length];

        int firstThird = length / 3;
        int secondThird = (length - firstThird) / 2;
        int nearestGoal = 0;

        outerloop:
        {
            for (int nA = 1; nA <= firstThird; nA++) {
                for (int nB = nA; nB <= secondThird; nB++) {
                    int nC = length - nA - nB;
                    nearestGoal = nA * nB + nB * nC + nA * nC;

                    if (debug) {
                        System.out.println(String.format("%dx%d+%dx%d+%dx%d=%d", nA, nB, nB, nC, nA, nC, nearestGoal));
                    }

                    if (nearestGoal >= goal) {
                        fill('A', 0, nA);
                        fill('B', nA, nA + nB);
                        fill('C', nA + nB, length);
                        break outerloop;
                    }
                }

            }
        }

        //bingo
        if (nearestGoal == goal) {
            return new String(chars);
        }

        //bingo
        if (nearestGoal < goal) {
            return "";
        }

        int diff = nearestGoal - goal;
        shift(diff);

        return new String(chars);
    }

    private void shift(int diff) {
        //shift B for A
        diff = shiftOnce('B', diff);
        if (diff == 0) {
            return;
        }

        //shift C for B
        diff = shiftOnce('C', diff);
        if (diff == 0) {
            return;
        }

        //shift C for A
        shiftOnce('C', diff);

    }

    private int shiftOnce(char shiftChar, int diff) {
        if (debug) {
            System.out.println(String.format("%s\t%d", new String(chars), value()));
        }

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == shiftChar) {
                char p = chars[i - 1];
                chars[i] = p;
                chars[i - 1] = c;
                if (debug) {
                    System.out.println(String.format("%s\t%d", new String(chars), value()));
                }
                diff--;
                if (diff == 0) {
                    return 0;
                }
            }
        }
        return diff;
    }

    private void fill(char c, int start, int end) {
        for (int i = start; i < end; i++) {
            chars[i] = c;
        }
    }

    private int value() {
        int nC = 0;
        int nB = 0;
        int value = 0;
        for (int i = chars.length - 1; 0 <= i; i--) {
            if (chars[i] == 'C') {
                nC++;
            } else if (chars[i] == 'B') {
                nB++;
                value += nC;
            } else {
                value += nC;
                value += nB;
            }
        }
        return value;
    }
}

