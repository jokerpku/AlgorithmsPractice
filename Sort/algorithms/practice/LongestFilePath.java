package algorithms.practice;

import java.util.Stack;

/**
 * Created by Jokeria on 2016/11/5.
 */
public class LongestFilePath {

    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<String>();
        StringBuilder builder = new StringBuilder();
        int nowLevel = 1;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\n') { // 构造文件名或者文件夹名
                builder.append(chars[i]);
            } else {
                int level = 1;
                while (chars[++i] == '\t') {
                    level++;
                }
                if (level > nowLevel) { // 更深文件，前一个字符串入栈，清空builder
                    stack.push(builder.toString());
                    builder.delete(0, builder.length());
                } else if (level == nowLevel) { // 同级文件，前一字符串若为文件，则入栈，否则说明为空文件夹，直接清空builder
                    if (builder.toString().contains(".")) {
                        stack.push(builder.toString());
                    }
                    builder.delete(0, builder.length());
                } else { // 更浅层的文件，出栈差数个文件夹，组建成一个文件名称入栈
                    String res = builder.toString().contains(".") ? builder.toString() : "";
                    builder.delete(0, builder.toString().length());
                    int diff = nowLevel - level;
                    while (diff != 0 && !stack.isEmpty()) {
                        String peek = stack.pop();
                        if (peek.contains(".")) {
                            res = res.length() > peek.length() ? res : peek;
                        } else {
                            if(res.contains(".")) {
                                res = peek + "/" + res;
                            }
                            diff--;
                        }
                    }
                    if(res.contains(".")) {
                        stack.push(res);
                    }
                }
                nowLevel = level;
                i--;
            }
        }

        // 操作栈，寻找最长路径
        String res = builder.toString().contains(".") ? builder.toString() : "";
        while (!stack.isEmpty()) {
            String peek = stack.pop();
            if (peek.contains(".")) {
                res = res.length() > peek.length() ? res : peek;
            } else if(res.contains(".")){
                res = peek + "/" + res;
            }
        }

        System.out.println("lengthLongestPath result is " + res);
        if(res.contains(".")) {
            return res.length();
        }
        return 0;
    }
}
