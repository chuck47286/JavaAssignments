package predictive;

/**
 * The class has two field variables such as words of the type String
 * and signature of type String.
 *
 * @author YuCheng
 * @version 2020-2-9
 */
public class WordSig implements Comparable<WordSig>{
    private String words;
    private String signature;

    /**
     *
     * @param words The input of the words.
     * @param signature The input of the numeric signature.
     */
    public WordSig(String words, String signature) {
        this.words = words;
        this.signature = signature;
    }

    /**
     *
     * @return The value of words in the instance.
     */
    public String getWords() {
        return words;
    }

    /**
     *
     * @return The value of signature in the instance.
     */
    public String getSignature() {
        return signature;
    }

    /**
     *
     * @param ws The input of WordSig is the potential comparable object.
     * @return The 1 , -1 or 0. The meaning of this method is to sort the
     * WordSig by the signature length and alphabetical writing in ascending order.
     */
    @Override
    public int compareTo(WordSig ws) {
//
//        if(this.signature.length()<ws.signature.length()){
//            return -1;
//        }else if(this.signature.length()>ws.signature.length()){
//            return 1;
//        }else{
//            return this.signature.compareTo(ws.signature);
//        }
        return this.signature.compareTo(ws.signature);
    }
}
