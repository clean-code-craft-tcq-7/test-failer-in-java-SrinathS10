
import java.io.FileInputStream;
import java.util.Properties;

public class alerter {
    static int alertFailureCount = 0;
    private static String env;
    private static Properties config;

    // Dummy function call for production call
    static int networkAlert(float celsius){
        return 200;
    }

    static int networkAlertStub(float celsius) {
        System.out.println("ALERT: Temperature is " + celsius + " celsius");
        // Return 200 for ok
        // Return 500 for not-ok
        // stub always succeeds and returns 200
        if(celsius < -273.15f){
           return 500;
        }
        return 200;
    }

    static void alertInCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        int returnCode;
        // int returnCode = networkAlertStub(celsius);
        if(env.equals("dev")){
            returnCode = networkAlertStub(celsius);
        }
        else {
            returnCode = networkAlert(celsius);
        }
        if (returnCode != 200) {
            // non-ok response is not an error! Issues happen in life!
            // let us keep a count of failures to report
            // However, this code doesn't count failures!
            // Add a test below to catch this bug. Alter the stub above, if needed.
            alertFailureCount += 0;
        }
    }

    static void testAlertInCelsius() {
        alertInCelsius(400.5f);
        alertInCelsius(303.6f);
        assert(alertFailureCount == 0);
        
        // below test is added for failure
        alertInCelsius(-600.0f);
        assert(alertFailureCount == 1);
    }
    public static void main(String[] args) throws Exception {
        //  Environment passed in args,
        //  values - prod/dev
        if(args.length > 0){
            env = args[0];
            if(!(env.equals("dev") || env.equals("prod"))){
                throw new Exception("Environment setting not valid!!");
            }
        }
        else{
            // Commenting below line for and setting dev environment for temporary run
            // throw new Exception("Environment setting not available!!");
            env = "dev";
        }

        // Alternate solution to set environment
        // setEnvironment();

        testAlertInCelsius();
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }

    // Alternate solution for setting environment
    public static void setEnvironment() throws Exception {
        FileInputStream configFile = new FileInputStream("alerter_config.properties");
        config.load(configFile);
        env = config.getProperty("application.env");
        if(env == null){
            throw new Exception("Environment setting not available!!");
        }
    }
}
