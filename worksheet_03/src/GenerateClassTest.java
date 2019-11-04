import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateClassTest {
    private GenerateClass generateClass;
    @BeforeEach
    void setUp() {
        generateClass = new GenerateClass("Person",
                new String[]{"name", "dob"},
                new String[]{"String","Date"});
    }

    @Test
    void makeFields() {
        String expected = "  private String name;\n" + "  private Date dob;\n\n";
//        System.out.println(expected);
        String actual = generateClass.makeFields();
        assertEquals(expected,actual);
    }

    @Test
    void makeConstructor() {
        String expected =
                "  public Person(String name, Date dob){\n" + "    this.name = name;\n"
                        + "    this.dob = dob;\n" + "  }\n";
//        System.out.println(expected);
        String actual = generateClass.makeConstructor();
//        System.out.println(actual);
//        System.out.println(expected.equals(actual));
        assertEquals(expected,actual);
    }

    @Test
    void makeGetters() {
        String expected =
                "  public String getName(){\n" + "    return name;\n" + "  }\n"
                        + "  public Date getDob(){\n" + "    return dob;\n" + "  }\n";;
        String actual = generateClass.makeGetters();
        assertEquals(expected,actual);
    }

    @Test
    void makeSetters() {
        String expected =
                "  public void setName(String name){\n" + "    this.name = name;\n" + "  }\n"
                        + "  public void setDob(Date dob){\n" + "    this.dob = dob;\n" + "  }\n";;
        String actual = generateClass.makeSetters();
        assertEquals(expected,actual);
    }

    @Test
    void writeFile() {
        generateClass.writeFile();

    }
}