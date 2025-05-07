import java.io.*;
import java.util.*;

public class EVEMainTest {
    public static void main(String[] args) throws IOException {
        runFormattingTest(
                "Simple key/value trimming and splitting",
                "foo:bar,baz\nalpha:  one ,two, three  \n",
                Arrays.asList(
                        "foo: bar, baz",
                        "alpha: one, two, three"
                )
        );

        runFormattingTest(
                "Whitespace around key and value",
                "   mixedKey   :    some   value   \n",
                Arrays.asList(
                        "mixedKey: some   value"
                )
        );

        runFormattingTest(
                "Multiple vehicle entries and blank line normalization",
                // note: two blank lines in input
                "vehicle_id: 2\n"
                        + "type: car, convertible\n"
                        + "engine:   Goliath Inc.,  diesel   \n"
                        + "color: blue\n"
                        + "manufacturer: ACME\n"
                        + "wheels: ACME,   all-weather,  4\n"
                        + "\n\n"
                        + "vehicle_id:     01\n"
                        + "type: truck, pickup\n"
                        + " color  :  silver\n"
                        + "engine: ACME, electric\n"
                        + "manufacturer:  Goliath Inc.\n"
                        + "wheels: ACME, all-weather, 6\n",
                Arrays.asList(
                        "vehicle_id: 2",
                        "type: car, convertible",
                        "engine: Goliath Inc., diesel",
                        "color: blue",
                        "manufacturer: ACME",
                        "wheels: ACME, all-weather, 4",
                        "",                                  // exactly one blank line
                        "vehicle_id: 01",
                        "type: truck, pickup",
                        "color: silver",
                        "engine: ACME, electric",
                        "manufacturer: Goliath Inc.",
                        "wheels: ACME, all-weather, 6"
                )
        );

        runExceptionTest(
                "Missing colon should throw",
                "noColonLine\n"
        );

        runExceptionTest(
                "More than one colon should throw",
                "key: value: extra\n"
        );
    }

    private static void runFormattingTest(String testName, String input, List<String> expectedLines) throws IOException {
        // redirect
        InputStream  oldIn  = System.in;
        PrintStream  oldOut = System.out;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(bout));

        boolean passed = false;
        List<String> actualLines = new ArrayList<>();
        try {
            EVEMain.main(new String[0]);
            // read printed output line by line
            BufferedReader r = new BufferedReader(new StringReader(bout.toString()));
            String line;
            while ((line = r.readLine()) != null) {
                actualLines.add(line);
            }
            passed = actualLines.equals(expectedLines);
        } catch (InvalidInputError e) {
            // test fails if we expected formatting but got exception
            System.setOut(oldOut);
            System.out.println(testName + " — FAIL (threw exception)");
            e.printStackTrace(System.out);
        } finally {
            // restore
            System.setIn(oldIn);
            System.setOut(oldOut);
        }

        if (passed) {
            System.out.println(testName + " — PASS");
        } else {
            System.out.println(testName + " — FAIL");
            System.out.println("  expected → " + expectedLines);
            System.out.println("  actual   → " + actualLines);
        }
    }

    private static void runExceptionTest(String testName, String input) {
        InputStream  oldIn  = System.in;
        PrintStream  oldOut = System.out;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        boolean threwCorrect = false;
        try {
            EVEMain.main(new String[0]);
        } catch (InvalidInputError e) {
            threwCorrect = true;
        } catch (Exception e) {
            System.setOut(oldOut);
            System.out.println(testName + " — FAIL (wrong exception)");
            e.printStackTrace(System.out);
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }

        System.out.println(testName + (threwCorrect ? " — PASS" : " — FAIL (no InvalidInputError)"));
    }
}
