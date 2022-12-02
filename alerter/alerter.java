package alerter;

import java.io.FileInputStream;
import java.util.Properties;

public class alerter {
    static int alertFailureCount = 0;
    private static String env;
    private static Properties config;

    static int networkAlert(float celsius){
        return 200;
    }
  
    static void alertInCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        int returnCode = networkAlert(celsius);
        if (returnCode != 200) {
            alertFailureCount += 1;
        }
    }

    static void testAlertInCelsius() {
        //above threshold
        alertInCelsius(400.5f);
        alertInCelsius(303.6f);
        assert(alertFailureCount == 0);

        // threshold
        alertInCelsius(-459.66f);
        assert(alertFailureCount == 0);

        // below threshold
        alertInCelsius(-500.10f);
        assert(alertFailureCount == 1);
        alertInCelsius(-600.0f);
        assert(alertFailureCount == 2);
    }

    public static void main(String[] args) {
        try {
            //  Environment passed in args,
            //  values - prod/dev
            if (args.length > 0) {
                env = args[0];
            } else {
                // Commenting below line for setting dev environment for temporary run
                // throw new Exception("Environment setting not available!!");
                env = "dev";
            }
            // Alternate solution to set environment - setEnvironment();

//             switch (env) {
//                 case "dev":
//                     networkAlertInterface = NetworkAlerter::networkAlertStub;
//                     break;
//                 case "prod":
//                     networkAlertInterface = NetworkAlerter::networkAlert;
//                     break;
//                 default:
//                     throw new Exception("Environment setting not valid!!");
//             }

            testAlertInCelsius();
            System.out.printf("%d alerts failed.\n", alertFailureCount);
            System.out.println("All is well (maybe!)\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Alternate solution for setting environment
    public static void setEnvironment() throws Exception {
        FileInputStream configFile = new FileInputStream("alerter/alerter_config.properties");
        config.load(configFile);
        env = config.getProperty("application.env");
    }
}
