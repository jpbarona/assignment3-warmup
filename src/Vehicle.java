import java.util.ArrayList;
import java.util.Arrays;

public class Vehicle {
    private static final String SPACE = " ";
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String VALUES_SEPARATOR = ",";

    public static final String VEHICLE_ID_STRING = "vehicle_id";
    private static final int DEFAULT_VEHICLE_ID = -100000;
    private int vehicleId = DEFAULT_VEHICLE_ID;

    public static final String COLOR_STRING = "color";
    public static final String COST_STRING = "cost";
    public static final String ENGINE_STRING = "engine";
    public static final String MANUFACTURER_STRING = "manufacturer";
    public static final String TYPE_STRING = "type";
    public static final String VALID_STRING = "valid";
    public static final String WHEELS_STRING = "wheels";


    private String[] color;
    private String[] engine;
    private String[] manufacturer;
    private String[] type;
    private String[] wheels;

    private boolean valid = false;
    private int cost = 0;

    public Vehicle (ArrayList<String[]> keyValuesList) {
        for (String[] keyValueTuple : keyValuesList) {
            String key = keyValueTuple[0].strip();
            String valueString = keyValueTuple[1].strip();

            switch(key) {
                case VEHICLE_ID_STRING:
                    if (this.vehicleId == DEFAULT_VEHICLE_ID) {this.vehicleId = Integer.parseInt(valueString);}
                    break;
                case COLOR_STRING:
                    String[] colorList = parseValue(valueString);
                    if (this.color == null) {this.color = colorList;}
                    break;
                case ENGINE_STRING:
                    String[] engineList = parseValue(valueString);
                    if (this.engine == null) {this.engine = engineList;}
                    break;
                case MANUFACTURER_STRING:
                    String[] manufacturerList = parseValue(valueString);
                    if (this.manufacturer == null) {this.manufacturer = manufacturerList;}
                    break;
                case TYPE_STRING:
                    String[] typeList = parseValue(valueString);
                    if (this.type == null) {this.type = typeList;}
                    break;
                case WHEELS_STRING:
                    String[] wheelsList = parseValue(valueString);
                    if (this.wheels == null) {this.wheels = wheelsList;}
                    break;
            }
        }
    }

    private static String[] parseValue(String valueString) {
        String[] valuesRaw = valueString.split(VALUES_SEPARATOR);
        String[] valuesStripped = new String[valuesRaw.length];
        for (int i = 0; i < valuesRaw.length; i++) {
            String rawValue = valuesRaw[i];
            valuesStripped[i] = rawValue.strip();
        }
        return valuesStripped;
    }

    public void printVehicle() {
        String idString = String.valueOf(vehicleId);
        String vehicleIdLineString = VEHICLE_ID_STRING + KEY_VALUE_SEPARATOR + SPACE + idString;
        System.out.println(vehicleIdLineString);
        String[] validList = { String.valueOf(valid)};
        String[] costList = { String.valueOf(cost)};

        printLineString(COLOR_STRING, color);
        printLineString(COST_STRING, costList);
        printLineString(ENGINE_STRING, engine);
        printLineString(MANUFACTURER_STRING, manufacturer);
        printLineString(TYPE_STRING, type);
        printLineString(WHEELS_STRING, wheels);
        printLineString(VALID_STRING,validList);

    }

    public static void printLineString(String KEY_STRING, String[] values) {
        String valuesString = constructValueString(values);
        String lineString = KEY_STRING + KEY_VALUE_SEPARATOR + SPACE + valuesString;
        System.out.println(lineString);
    }

    private static String constructValueString(String[] values) {
        String valuesString = "";
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            if (i == 0) {
                if (i == values.length-1) {
                    //This branch gets executed when there is only one value, hence no separator is required
                    valuesString += value;
                }
                else {
                    valuesString += value + VALUES_SEPARATOR;
                }
                continue;
            }
            if (i == values.length - 1) {
                valuesString += SPACE + value;
                continue;
            }
            else {
                valuesString += SPACE + value + VALUES_SEPARATOR;
            }

        }
            return valuesString;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }



    public static void main(String[] args) {
//        parseValue("hello");
        String key = "key";
        String rawValueString = "   value 1   , value2,     value3    ";
        String[] parsedValues = parseValue(rawValueString);
        System.out.println(Arrays.toString(parsedValues));
        String valuesString = constructValueString(parsedValues);
        System.out.println("Values string:");
        System.out.print(valuesString);
        System.out.println("[END OF STRING]");

        String[] list1 = {"v1", "v2", "v3"};
        String[] list2 = {"value"};
        System.out.println("list1: [START]" + constructValueString(list1) + "[END]");
        System.out.println("list2: [START]" + constructValueString(list2) + "[END]");
    }
}
