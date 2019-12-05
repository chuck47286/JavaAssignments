import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class Mini_interperter {
    Map<String, Integer> heapmemory;
    Pattern pattern;

    private int interpreter(String input) {
        String[] instructions = input.split("\\n");
        heapmemory = new HashMap<>();
//        pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        int i = 0;
        for ( ; i < instructions.length; i++) {
            // if it is the assignment operation, the jvm should calculate the result and
            // store in the local variable table. otherwise, it is to return the variable or constant;
            /*if (instructions[i].indexOf("=") != -1) {
                cal(instructions[i].trim());
            } else {
                // constant if it is true. otherwise it is variable.
                if (pattern.matcher(instructions[i].trim()).matches()) {
                    return Integer.parseInt(instructions[i].trim());
                } else {
                    return heapmemory.getOrDefault(instructions[i].trim(), 0);
                }
            }*/
            try {
                cal(instructions[i]);
            } catch (RuntimeException e) {
                break;
            }

        }
//        throw new RuntimeException();
        return heapmemory.get(instructions[i].trim());

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

        Mini_interperter mini_interperter = new Mini_interperter();
        int res = 0;
//        try {
            res = mini_interperter.interpreter(input);
            System.out.println(res);
//        } catch (Exception e) {
//            System.out.println("There is warning in the runtime, " +
//                    "and the ijvm could be out of memory if gc does not works well");
//            e.printStackTrace();
//        }
    }
}
