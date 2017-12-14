/**
 * Problem Statement
 * One day, Jamie noticed that many English words only use the letters A and B. Examples of such words include "AB" (short for abdominal), "BAA" (the noise a sheep makes), "AA" (a type of lava), and "ABBA" (a Swedish pop sensation).
 * <p>
 * <p>
 * Inspired by this observation, Jamie created a simple game. You are given two s: initial and target. The goal of the game is to find a sequence of valid moves that will change initial into target. There are two types of valid moves:
 * <p>
 * Add the letter A to the end of the string.
 * Reverse the string and then add the letter B to the end of the string.
 * Return "Possible" (quotes for clarity) if there is a sequence of valid moves that will change initial into target. Otherwise, return "Impossible".
 *
 * @author fatih celikel
 */
public class ABBA {

    private static boolean debug = false;

    public static void main(String[] args) {
        String initial = "AB";
        String target = "BBAABBA";
        String s = new ABBA().canObtain(initial, target);
        System.out.println(s);
    }

    public String canObtain(String initial, String target) {
        if (debug) {
            System.out.println(initial + ":" + target);
        }

        int count = target.length() - initial.length();
        String t = target;
        for (int i = 0; i < count; i++) {
            t = remove(t);

            if (debug) {
                System.out.println(t);
            }

            if (t.equals(initial)) {
                return "Possible";
            }
        }
        return "Impossible";
    }

    private String remove(String target) {
        char last = target.charAt(target.length() - 1);
        target = removeLast(target);
        if (last == 'B') {
            target = reverse(target);
        }
        return target;
    }

    private String removeLast(String target) {
        return target.substring(0, target.length() - 1);
    }

    private String reverse(String target) {
        return new StringBuilder(target).reverse().toString();
    }
}
