///**
// * Created by dullam on 8/4/17.
// */
//
//public class Sample {
//    public boolean isMatch(String s, String p) {
//        if(s.length() == 0 && p.length() == 0)  return true;
//
//        char[] pArray = p.toCharArray();
//        Stack pStack = new Stack<Character>();
//
//        char[] sArray = s.toCharArray();
//        Stack sStack = new Stack<Character>();
//
//
//        for(int i=0;i<pArray.length;i++) {
//            pStack.push(pArray[i]);
//        }
//
//        for(int i=0;i<sArray.length;i++) {
//            sStack.push(sArray[i]);
//        }
//
//        while(!pStack.empty()) {
//            if(sStack.empty()) return true;
//            Character c = (char)pStack.pop();
//            if(c=='*' && pStack.peek()!=null) {
//                Character prev = (char)pStack.pop();
//                if(prev=='.') {
//                    while(!sStack.empty() && sStack.peek()!=null) sStack.pop();
//                } else {
//                    while(!sStack.empty() && sStack.peek()!=null && prev==(char)sStack.peek()) sStack.pop();
//                }
//            } else if(c=='.') {
//                if(!sStack.empty() && sStack.peek()!=null) sStack.pop();
//            } else {
//                if(!sStack.empty() && c==(char)sStack.peek()) sStack.pop();
//            }
//        }
//
//        if(sStack.empty()) return true;
//        else return false;
//
//    }
//}
