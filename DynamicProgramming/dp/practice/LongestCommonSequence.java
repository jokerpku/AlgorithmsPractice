package dp.practice;

/**
 * Created by Jokeria on 2016/11/9.
 */
public class LongestCommonSequence {
    public static void main(String[] args) {
//        int nums[] = {5, -4, 2, 5, -1};
//        int res[] = lss(nums);
//        for(int num : res) {
//            System.out.println(num + " ");
//        }

//        System.out.println(largestSum(nums));
        System.out.println(lcs("abcde", "ebcbcd"));
    }

    static String lcs(String a, String b) {
        if(a == null || a.length() == 0) {
            return "";
        } else if(b == null || b.length() == 0) {
            return "";
        }

        int alen = a.length();
        int blen = b.length();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int ac[] = new int[alen+1];
        int bc[] = new int[blen+1];

        for(int i = 0; i < blen; i++) {
            int temp = ac[0];
            for(int j = 0; j < alen; j++) {
                int tt = ac[j+1];
                if(aChars[j] == bChars[i]) {
                    ac[j+1] = temp + 1;
                }
                temp = tt;
            }
        }

        for(int i = 0; i < alen; i++) {
            int temp = bc[0];
            for(int j = 0; j < blen; j++) {
                int tt = bc[j+1];
                if(bChars[j] == aChars[i]) {
                    bc[j+1] = temp + 1;
                }
                temp = tt;
            }
        }

        int amax = 0;
        for(int i = 1; i <= alen; i++) {
            if(ac[i] > ac[amax]) {
                amax = i;
            }
        }

        int bmax = 0;
        for(int i = 1; i <= blen; i++) {
            if(bc[i] > bc[bmax]) {
                bmax = i;
            }
        }

        if(amax < bmax) {
            return b.substring(bmax - bc[bmax], bmax);
        } else {
            return a.substring(amax - ac[amax], amax);
        }


    }
}
