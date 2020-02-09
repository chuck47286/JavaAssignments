package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The class is the command-line programs to use a series of number to represent the word.
 *
 * @author YuCheng
 * @version 2020/2/8 21:56
 */
public class Words2SigProto {
    public static void main(String[] args) {
        for (String s: args)
            System.out.println(PredictivePrototype.wordToSignature(s));
    }
}
