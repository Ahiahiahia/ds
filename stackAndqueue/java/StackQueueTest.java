package data_structure.stackAndqueue.java;

/**
 * 栈和队列面试题
 */
class StackQueueTest {
    /**
     * 括号匹配问题
     * @param str
     * @return
     */
    public boolean MatchBrackets(String str){
        IStack stack = new IStackImpl();
        char[] chs = str.toCharArray();
        for(int i=0; i<chs.length; i++){
            if(chs[i] == '(' || chs[i] == '{' || chs[i] == '['){
                stack.pushStack(chs[i]);
            }else if(chs[i] == ')' || chs[i] == '}' || chs[i] == ']'){
                if(!stack.isEmpty()){
                    char ch = (char)stack.topStack();
                    stack.popStack();
                    if((ch=='(' && chs[i]==')') || (ch=='{' && chs[i]=='}')
                            || (ch=='[' && chs[i]==']')){
                        ;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    
}
