/**
 * Created by dullam on 1/29/18.
 */
import java.util.Stack;
class AsteroidsCollide {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i< asteroids.length; i++) {
            if(asteroids[i] < 0 ) {
                if(!stack.empty()  && stack.peek() > 0)  {
                    collide(stack,asteroids[i] );
                } else {
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()) res[i++] = stack.pop();
        return res;
    }

    private void collide(Stack<Integer> stack, int topAst) {
        while(!stack.isEmpty()) {
            if(topAst < 0 && !stack.empty() && stack.peek() > 0 ) {
                int belowAst = stack.pop();
                if( (topAst * -1) < belowAst) {
                    stack.push(belowAst);
                } else if((topAst * -1) == belowAst) {
                    continue;
                } else {
                    collide(stack,topAst);
                    return;
                }

            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        AsteroidsCollide ac = new AsteroidsCollide();
        int[] res = ac.asteroidCollision(new int[]{5,10,-5});
        for(int i: res)
            System.out.println(" "+ i);
    }
}