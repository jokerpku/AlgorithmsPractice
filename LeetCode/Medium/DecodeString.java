package Medium;

import java.util.Stack;

/**
 * Created by Simple on 2016/11/22.
 */
public class DecodeString {
        public String decodeString(String s) {
            if(s == null || s.isEmpty()) {
                return s;
            }
            Stack<Integer> nums = new Stack<Integer>();
            Stack<String> strs = new Stack<String>();

            int num = 1;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '[') {
                    continue;
                } else if(s.charAt(i) == ']') {
                    StringBuilder post = new StringBuilder();
                    int count = nums.pop();
                    String str = strs.pop();
                    while(count != 0) {
                        post.append(str);
                        count--;
                    }
                    if(!strs.isEmpty()){
                        String pre = strs.pop();
                        strs.push(pre + post.toString());
                    } else {
                        strs.push(post.toString());
                    }
                } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {

                    StringBuilder intBuilder = new StringBuilder();
                    intBuilder.append(s.charAt(i));
                    while(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                        i++;
                        intBuilder.append(s.charAt(i));
                    }
                    num = Integer.parseInt(intBuilder.toString());
//                    nums.push(Integer.parseInt(intBuilder.toString()));
//                    num = 1;
                } else {
                    StringBuilder strBuilder = new StringBuilder();
                    strBuilder.append(s.charAt(i));
                    while((i+1) < s.length() && ((s.charAt(i+1) >= 'A' && s.charAt(i+1) <= 'Z') || (s.charAt(i+1) >= 'a' && s.charAt(i+1) <= 'z'))) {
                        i++;
                        strBuilder.append(s.charAt(i));
                    }
                    nums.push(num);
                    num = 1;
                    strs.push(strBuilder.toString());
                }
            }

            String res = "";
            while(!strs.isEmpty()) {
                res = strs.pop() + res;
            }
            return res;
        }

        public static void main(String[] args) {
            DecodeString instance = new DecodeString();
            String str = "sd2[f2[e]g]i";//"3[a]2[bc]";//"3[a2[c]]";//"2[abc]3[cd]ef";//;
            String res = instance.decodeString(str);
            System.out.println(res);
        }
}
