import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class GenerateClass with three field variables classname, variableNames and
 * variableTypes of type String, String array and String array respectively.
 *
 * @version 2019-10-30
 * @author Yu Cheng
 */
public class GenerateClass {
    public String classname;
    public String[] variableNames;
    public String[] variableTypes;

    /**
     *
     * @param classname The classname of the GenerateClass.
     * @param variableNames The variableNames of the GenerateClass.
     * @param variableTypes The variableTypes of the GenerateClass.
     */
    public GenerateClass(String classname, String[] variableNames, String[] variableTypes) {
        this.classname = classname;
        this.variableNames = variableNames;
        this.variableTypes = variableTypes;
    }

    /**
     * The field variable of the class GenerateClass.
     * @return All field variables of the class GenerateClass.
     */
    public String makeFields() {
        int index = 0;
        String str = "";
        while (index < variableNames.length  ) {
            str +=  "  private " + variableTypes[index] +" " + variableNames[index] + ";" + "\n";
            index++;
        }
        return str += "\n";
    }

    /**
     * The constructor of the class GenerateClass.
     * @return The constructor of the class GenerateClass.
     */
    public String makeConstructor() {
        // return result if it is Default constructor or no-arg constructor
        if (variableNames.length == 0) {
            return "  public Person4(){}\n";
        } else {
            int index = 0;
            String tempstr = "";
            while (index < variableNames.length) {
                tempstr += "" + variableTypes[index] + " " + variableNames[index] + ", ";
                index++;
            }
            String str =
                    "  public " + this.classname +
                            "(" + tempstr.substring(0, tempstr.length() - 2) + ")"
                            + "{" + "\n";
            index = 0;
            while (index < variableNames.length) {
                str += "    this." + variableNames[index] + " = " +
                        variableNames[index] + ";\n";
                index++;
            }
            return str + "  }\n";
        }
    }

    /**
     * The getters of the class GenerateClass.
     * @return The getters of the class GenerateClass.
     */
    public String makeGetters() {
        int index = 0;
        String str = "";
        while (index < variableNames.length) {
            str += "  public " + variableTypes[index] + " " +
                    "get"+Character.toUpperCase(variableNames[index].charAt(0)) +
                    variableNames[index].substring(1, variableNames[index].length()) +
                    "(){" + "\n"+
                    "    return "+ variableNames[index] +";" +"\n" +
                    "  }\n"
            ;
            index++;
        }
        return str;
    }

    /**
     * The setters of the class GenerateClass.
     * @return The setters of the class GenerateClass.
     */
    public String makeSetters() {
        int index = 0;
        String str = "";
        while (index < variableNames.length) {
            str += "  public" + " void" + " " +
                    "set"+Character.toUpperCase(variableNames[index].charAt(0)) +
                    variableNames[index].substring(1,variableNames[index].length()) +
                    "(" + variableTypes[index] + " " + variableNames[index] + "){" + "\n" +
                    "    this."+ variableNames[index] +" = "+
                    variableNames[index] +";\n" +
                    "  }\n";
            index++;
        }

        return str;
    }

//    @Override
//    public String toString() {
//        return "GenerateClass{" +
//                "classname='" + classname + '\'' +
//                ", variableNames=" + Arrays.toString(variableNames) +
//                ", variableTypes=" + Arrays.toString(variableTypes) +
//                '}';
//    }

    /**
     * This method is to write the class and its field variables, constructors,
     * getters and setters respectively in the file which has the same name of
     * the class. If there is IOException during the process of the method, the
     * message of the stack would be printed.
     */
    public void writeFile() {
        try {

            String content =
                    "class " +
                            Character.toUpperCase(classname.charAt(0)) +
                            classname.substring(1,classname.length()) +
                            "{\n" +
                            this.makeFields()+ "\n" +
                            this.makeConstructor() + "\n" +
                            this.makeGetters() + "\n" +
                            this.makeSetters() + "\n" +
                            "}";
            File file = new File(this.classname+ ".java");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(
                    file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(
                    fileWriter
            );
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
