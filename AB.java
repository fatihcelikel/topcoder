/**
 * Problem Statement
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 * <p>
 * The string has exactly N characters, each of which is either 'A' or 'B'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 *
 * @author fatih celikel
 */
public class AB {

    private static boolean debug = false;

    private char[] chars;

    public static void main(String[] args) {
        int length = 50;
        int goal = 48;
        String s = new AB().createString(length, goal);
        System.out.println(s);
    }

    public String createString(int length, int goal) {
        chars = new char[length];

        int half = length / 2;
        int nearestGoal = 0;

        for (int nA = 1; nA <= half; nA++) {
            int nB = length - nA;
            nearestGoal = nA * nB;

            if (debug) {
                System.out.println(String.format("%dx%d=%d", nA, nB, nearestGoal));
            }

            if (nearestGoal >= goal) {
                fill('A', 0, nA);
                fill('B', nA, length);
                break;
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
        if (debug) {
            System.out.println(String.format("%s\t%d", new String(chars), value()));
        }

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'B') {
                char p = chars[i - 1];
                chars[i] = p;
                chars[i - 1] = c;
                if (debug) {
                    System.out.println(String.format("%s\t%d", new String(chars), value()));
                }
                diff--;
                if (diff == 0) {
                    return;
                }
            }
        }
    }

    private void fill(char c, int start, int end) {
        for (int i = start; i < end; i++) {
            chars[i] = c;
        }
    }

    private int value() {
        int nB = 0;
        int value = 0;
        for (int i = chars.length - 1; 0 <= i; i--) {
            if (chars[i] == 'B') {
                nB++;
            } else {
                value += nB;
            }
        }
        return value;
    }

}

