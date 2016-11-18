package dp.practice;

/**
 * Created by Jokeria on 2016/11/9.
 */

/**
 * if an == bm, LCS(a, b) = LCS(an-1, bm-1) + a[n];
 * else an != bm, LCS(a, b) = max(LCS(an-1, bm), LCS(an, bm-1))
 * 重叠子问题，第二种情况，会反复求解an-1,bm-1
 */
public class LCS {
    public static String lcs(String a, String b) {
        if(a == null || a.length() == 0) {
            return "";
        } else if(b == null || b.length() == 0) {
            return "";
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

//        String result = subLcs1(aChars, aChars.length-1, bChars, aChars.length-1);
        String result = subLcs2(aChars, bChars);
        return result;
    }

    private static String subLcs1(char[] a, int aHi, char[] b, int bHi) {
         if(aHi < 0 || bHi < 0) {
             return "";
         }

         if(a[aHi] == b[bHi]) {
             return subLcs1(a, aHi-1, b, bHi-1) + a[aHi];
         } else {
             String str1 = subLcs1(a, aHi-1, b, bHi);
             String str2 = subLcs1(a, aHi, b, bHi-1);
             if(str1.length() < str2.length()) {
                 return str2;
             } else {
                 return str1;
             }
         }
    }

    public static String subLcs2(char[] a, char[] b) {
        int alen = a.length;
        int blen = b.length;
        int c[][] = new int[blen+1][alen+1];
        char s[][] = new char[blen+1][alen+1];

        int i = 0;
        int j = 0;
        for(; i <= blen; i++) {
            c[i][0] = 0;
        }
        for(; i <= alen; i++) {
            c[0][i] = 0;
        }

        for(i = 1; i <= blen; i++) {
            for(j = 1; j <= alen; j++) {
                if(a[j-1] == b[i-1]) {
                    c[i][j] = c[i-1][j-1] + 1;
                    s[i][j] = 'd';
                } else if(c[i][j-1] < c[i-1][j]) {
                    c[i][j] = c[i-1][j];
                    s[i][j] = 'v';
                } else {
                    c[i][j] = c[i][j-1];
                    s[i][j] = 'h';
                }
            }
        }

        int rlen = c[blen][alen];
        char[] result = new char[rlen];
        i = blen;
        j = alen;
        while(i > 0 && j > 0) {
            if(s[i][j] == 'd') {
                result[--rlen] = a[j-1];
                i--;
                j--;
            } else if(s[i][j] == 'h') {
                j--;
            } else {
                i--;
            }
        }

        return new String(result);

    }


    public static void main(String[] args) {
        String a = "bdcaba";
        String b = "abcbdab";
        System.out.println(lcs(a, b));
    }
}
