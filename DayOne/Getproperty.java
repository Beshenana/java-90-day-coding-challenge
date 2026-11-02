package DayOne;
public class Getproperty {
    public static void main(String[] args) {
        String propertyValue = System.getProperty("java.version");
        System.out.println("Java Version: " + propertyValue);
        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
        String architecture = System.getProperty("os.arch");
        System.out.println("Architecture: " + architecture);
        String osVersion = System.getProperty("os.version");
        System.out.println("Operating System Version: " + osVersion);

    }
}
