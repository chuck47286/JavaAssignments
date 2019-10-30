import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateClass {
    public String classname;
    public String[] variableNames;
    public String[] variableTypes;

    public GenerateClass(String classname, String[] variableNames, String[] variableTypes) {
        this.classname = classname;
        this.variableNames = variableNames;
        this.variableTypes = variableTypes;
    }
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
     *
     * @return
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
