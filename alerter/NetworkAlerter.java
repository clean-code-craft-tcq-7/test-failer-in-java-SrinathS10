package alerter;
public class NetworkAlerter {

    // Dummy function call for production call
    static int networkAlert(float celsius){
        return 200;
    }

    static int networkAlertStub(float celsius) {
        System.out.println("ALERT: Temperature is " + celsius + " celsius");
        if(celsius < -273.15f){
            return 500;
        }
        return 200;
    }
}
