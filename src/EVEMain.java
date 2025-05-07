
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
                        checkValid(keyValuesList);
                        checkCost(keyValuesList);

                        keyValuesList = sortList(keyValuesList);
                        printKeyValues(keyValuesList);
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

    private static ArrayList<String[]> sortList(ArrayList<String[]> keyValuesList) {
        HashMap<String, String> keyValues = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        for (String[] keyValueTuple : keyValuesList) {
            String key = keyValueTuple[0];
            String value = keyValueTuple[1];
            keyValues.put(key, value);
            keys.add(key);
        }
        Collections.sort(keys); //keys beyond this point is sorted
        ArrayList<String[]> sortedkeyValuesList = new ArrayList<>();
        for (String key : keys) {
            String[] keyValueTuple = {key, keyValues.get(key)};
            sortedkeyValuesList.add(keyValueTuple);
        }
        return sortedkeyValuesList;
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

    private static void checkValid(ArrayList<String[]> keyValuesList) {
            boolean valid = true;
            for (String[] keyValueTuple : keyValuesList) {
                String keyString = keyValueTuple[0];
                valid &= (FIELDS_LIST.contains(keyString));
            }
            String[] validTuple = {"valid", SPACE + String.valueOf(valid)};
            keyValuesList.add(validTuple);
    }

    private static void checkCost(ArrayList<String[]> keyValuesList) {
        int cost = 0;
        String[] keyValueTuple = {"cost", String.valueOf(cost)};
        keyValuesList.add(keyValueTuple);
    }

    private static void printKeyValues(ArrayList<String[]> keyValueList) {
        for(String[] keyValueTuple : keyValueList) {
            String keyString = keyValueTuple[0];
            String valuesString = keyValueTuple[1];
            String lineString = keyString + KEY_VALUE_SEPARATOR + valuesString;
            System.out.println(lineString);
        }

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