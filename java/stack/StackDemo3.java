package stack;
/**
 * 中缀表达式转换成 后缀表达式，逆波兰式
 */

import java.util.Scanner;
import java.util.Stack;

public class StackDemo3 {
    static final  String opStr ="+-*/";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            show(scanner.nextLine());
        }
    }

    private static void show(String str){

        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i=0;i<str.length();i++){
            ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
                continue;
            }
            if(ch == ')'){
                char charTop = stack.pop();
                while (charTop !='('){
                    System.out.print(charTop);
                    charTop = stack.pop();
                }
                continue;
            }
            deal4Char( stack, ch);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static void deal4Char( Stack<Character> stack, char ch) {
        if(opStr.contains(ch+"")){
            if(stack.isEmpty()){
                stack.push(ch);
                return;
            }else {
                char opTop = stack.pop();
                if(changeToint(opTop) >= changeToint(ch)){
                    System.out.print(opTop);
                    stack.push(ch);
                }else {
                    stack.push(opTop);
                    stack.push(ch);
                }
            }
        }else {
            System.out.print(ch);
        }
    }


    private static int changeToint(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }
        if(ch == '*' || ch == '/'){
            return 2;
        }
        return 0;
    }
}
