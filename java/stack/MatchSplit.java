package stack;

import java.util.Scanner;

public class MatchSplit {
    public static void matchs(String str){
        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean needRun = true;
        StackDemo<Character> stack = new StackDemo(len);
        char outCh;
        char stackCh;
        for (int i=0;i<len && needRun;i++){
            outCh = chars[i];
            switch (outCh){
                case '(':
                case '[':
                case '{':
                    stack.push(outCh);
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty()){
                        System.out.println("不匹配");
                        needRun = false;
                        break;
                    }
                    stackCh = stack.peek();
                    boolean isMathc = '[' == stackCh && outCh == ']'|| '(' == stackCh && outCh == ')'
                            ||'{' == stackCh && outCh == '}';
                    if(isMathc){
                        stack.pop();
                        break;
                    }
                    needRun = false;
                    System.out.println("不匹配");
                    break;
            }
        }
        if(stack.isEmpty()){
            System.out.println("匹配");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            matchs(s.nextLine());
        }
    }
}
