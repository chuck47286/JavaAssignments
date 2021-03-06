import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * The class Mini_interperter is the simulation of how the ijvm works.
 *
 * @version 2019-12-05
 * @author YuCheng
 */
class Mini_interperter {
    /**
     * The heapmeory is to store the value of variables.
     */
    Map<String, Integer> heapmemory;
    /**
     * The pattern is to judge the instruction set is number or not.
     */
    Pattern pattern;

    /**
     * The method is interpret the instruction of string to the result.
     * @param input The Simulation of the bytecode.
     * @return The result of the instruction set.
     */
    private int interpreter(String input) {
        String[] instructions = input.split("\\n");
        heapmemory = new HashMap<>();
        pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        int i = 0;
        for ( ; i < instructions.length; i++) {
            try {
                cal(instructions[i]);
            } catch (RuntimeException e) {
                break;
            }

        }
        if (i < instructions.length) {
            if (!pattern.matcher(instructions[i].trim()).matches())
                return heapmemory.get(instructions[i].trim());
            else return Integer.parseInt(instructions[i]);
        }
        else
          throw new RuntimeException();

    }

    /**
     * The method is to calculate the addition of exactly two elements.
     * @param elements The variables or constants(C or 10).
     * @return The the addition of exactly two elements.
     */
    private void cal(String elements) {
        if (elements.indexOf("=") != -1) {
            String[] assignment = elements.split("=");
            String[] element = assignment[1].trim().split("\\+");
            // the simulation of how ijvm works by stack
            Stack<Integer> stack = new Stack();
            for (String e : element) {
                // if true, it is constant. otherwise it is variable.
                if (pattern.matcher(e.trim()).matches()) {
                    if (stack.isEmpty()) {
                        stack.push(Integer.parseInt(e.trim()));
                    } else {
                        int medianval = stack.pop();
                        stack.push(medianval + Integer.parseInt(e.trim()));
                    }
                } else {
                    if (stack.isEmpty()) {
                        stack.push(heapmemory.get(e.trim()));
                    } else {
                        int medianval = stack.pop();
                        stack.push(medianval + heapmemory.get(e.trim()));
                    }
                }

            }

            heapmemory.put(assignment[0].trim(), stack.peek());
        } else
            throw new RuntimeException();
    }
    public static void main(String[] args) {
        /*String input = "A = 2\n" +
                "B = 8\n" +
                "C = A + B\n" +
                "C";*/
        /*String input = "A = 2\n" +
                "B = 22\n" +
                "Z = 91\n" +
                "K = A + B\n" +
                "Z = K + A\n" +
                "Z";*/
        String input = "A = 2 + 1\n" +
                "B = A + 9\n" +
                "C = A + B\n" +
                "A";
        /*String input = "A = 2 + 1\n" +
                "B = A + 9\n" +
                "C = A + B\n" +
                "E = 4";*/
        /*String input = "A = 2 + 1\n" +
                "B = A + 9\n" +
                "C = A + B\n" +
                "B\n" +
                "B = A + B\n" +
                "B";*/
        /*String input = "A = 2 + 1\n" +
                "B = A + 9\n" +
                "C = A + B\n" +
                "20\n" +
                "B = A + B\n" +
                "B";*/

        Mini_interperter mini_interperter = new Mini_interperter();
        try {
            int res = mini_interperter.interpreter(input);
            System.out.println(res);
        } catch (Exception e) {
            /*System.out.println("There is no output in the runtime, " +
                    "please check whether there is something wrong with return");
            e.printStackTrace();*/
        }
    }
}
