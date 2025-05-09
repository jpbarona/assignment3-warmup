
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EVEMain {
    private static final String SPACE = " ";
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String VALUES_SEPARATOR = ",";

    public static final String COLOR = "color";
    public static final String ENGINE = "engine";
    public static final String MANUFACTURER = "manufacturer";
    public static final String TYPE = "type";
    public static final String VEHICLE_ID = "vehicle_id";
    public static final String WHEELS = "wheels";
    public static final ArrayList<String> FIELDS_LIST = new ArrayList<>(
            Arrays.asList(COLOR, ENGINE, MANUFACTURER, TYPE, VEHICLE_ID, WHEELS)
    );



    private static void processLineFeed() {
            Scanner reader = new Scanner(System.in);
            boolean justReceivedEntry = false;
            ArrayList<String[]> keyValuesList = new ArrayList<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isBlank()) {
                    if (justReceivedEntry)
                    {
                        Vehicle vehicle = new Vehicle(keyValuesList);
                        vehicle.printVehicle();
                        keyValuesList.clear();
                        justReceivedEntry = false;
                    }
                    continue;
                }
                checkLine(line);
                addKeyValueToList(line, keyValuesList);
                justReceivedEntry = true;
        }
    }

    private static void addKeyValueToList(String line, ArrayList<String[]> keyValuesList) {
        String[] splitLine = line.split(KEY_VALUE_SEPARATOR);
        String key = splitLine[0];
        String keyString = key.strip();

        String value = splitLine[1];
        String valuesString = createValuesString(value);

        String[] keyValueTuple = {keyString, valuesString};
        keyValuesList.add(keyValueTuple);
    }

    private static void checkLine(String line) {
        if (!line.contains(KEY_VALUE_SEPARATOR)) {
            throw new InvalidInputError("Line feed must contain " + KEY_VALUE_SEPARATOR);
        }
        if (line.split(KEY_VALUE_SEPARATOR).length != 2) {
            throw new InvalidInputError("Line feed must contain key and value separated by a " + KEY_VALUE_SEPARATOR);
        }
    }

    private static String createValuesString(String value) {
        String valuesString;
        if (value.length() > 1) {
            String[] parsedValuesList = getParsedValuesList(value);
            valuesString = getParsedValuesString(parsedValuesList);
        }
        else {
            valuesString = value.trim();
        }
        return valuesString;
    }

    private static String getParsedValuesString(String[] parsedValuesList) {
            String parsedValuesString = "";
            for (int i = 0; i < parsedValuesList.length; i++) {
                String value = parsedValuesList[i];
                if (i == parsedValuesList.length-1) {
                    parsedValuesString+= SPACE + value;
                }
                else {
                    parsedValuesString += SPACE + value + VALUES_SEPARATOR;
                }

            }
            return parsedValuesString;
    }

    private static String[] getParsedValuesList(String value) {
        String[] valueFields = value.split(VALUES_SEPARATOR);
        String [] parsedValues = new String[valueFields.length];
        for (int i = 0; i < valueFields.length; i++) {
            parsedValues[i] = valueFields[i].trim();
        }
        return parsedValues;
    }

    public static void main(String[] args) throws IOException {
            processLineFeed();
    }
}