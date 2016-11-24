package Medium;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jokeria on 2016/11/22.
 */
public class ReconstructOriginalDigits {
        // static final Tuple[] tuples = new
        public String originalDigits(String s) {
            if(s == null || s.isEmpty()) {
                return "";
            }

            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                }
            }

            int[] res = new int[10];
            String[] englishs = {"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
            if(map.containsKey('z')) {
                res[0] = map.get('z');
                removeDigit("zero", res[0], map);
            }
            if(map.containsKey('w')) {
                res[2] = map.get('w');
                removeDigit("two", res[2], map);
            }
            if(map.containsKey('u')) {
                res[4] = map.get('u');
                removeDigit("four", res[4], map);
            }
            if(map.containsKey('x')) {
                res[6] = map.get('x');
                removeDigit("six", res[6], map);
            }
            if(map.containsKey('g')) {
                res[8] = map.get('g');
                removeDigit("eight", res[8], map);
            }
            if(map.containsKey('o')) {
                res[1] = map.get('o');
                removeDigit("one", res[1], map);
            }
            if(map.containsKey('r')) {
                res[3] = map.get('r');
                removeDigit("three", res[3], map);
            }
            if(map.containsKey('f')) {
                res[5] = map.get('f');
                removeDigit("five", res[5], map);
            }
            if(map.containsKey('s')) {
                res[7] = map.get('s');
                removeDigit("seven", res[7], map);
            }
            if(map.containsKey('n')) {
                res[9] = map.get('n');
                removeDigit("nine", res[9], map);
            }

            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < 10; i++) {
                // char c = 'a' + i;
                while(res[i] != 0) {
                    builder.append(i);
                    res[i]--;
                }
            }

            return builder.toString();

        }

        void removeDigit(String digit, int num, Map<Character, Integer> map) {
            System.out.println(digit + " " + num);
            for(int i = 0; i < digit.length(); i++) {
                char c = digit.charAt(i);
                num = map.get(c)-num;
                if(num != 0) {
                    map.put(c, num);
                } else {
                    map.remove(c);
                }

            }

        // class Tuple {
        //     char key;
        //     String digit;
        //     int val;

        //     public Tuple(char key, String digit, int val) {
        //         this.key = key;
        //         this.digit = digit;
        //         this.val = val;
        //     }
    }
    public static void main(String[] args) {
        ReconstructOriginalDigits instance = new ReconstructOriginalDigits();
        instance.originalDigits("");
    }

}
