package data_structure.stackAndqueue.java;

/**
 * Created by hunter on 2019/2/15
 */
public class TestMain {
    public static void main(String[] args){
        StackQueueTest test = new StackQueueTest();
        String s1 = "(())abc{[(])}";
        String s2 = "(()))abc{[]}";
        String s3 = "(()()abc{[]}";
        String s4 = "(())abc{[]()}";
        System.out.println(test.MatchBrackets(s1));
        System.out.println(test.MatchBrackets(s2));
        System.out.println(test.MatchBrackets(s3));
        System.out.println(test.MatchBrackets(s4));
    }
}
