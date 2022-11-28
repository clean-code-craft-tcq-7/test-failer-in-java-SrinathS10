public class tshirts{
    static String getTshirtSize(int cms) {
        if(cms < 38) {
            return "S";
        } else if(cms > 38 && cms < 42) {
            return "M";
        } else {
            return "L";
        }
    }

    public static void main(String[] args) { 
        testTshirtSize();
        System.out.println("All is well (maybe!)");
    }

    static void testTshirtSize(){
        assert(getTshirtSize(37) == "S");
        assert(getTshirtSize(40) == "M");
        assert(getTshirtSize(43) == "L");
        assert(getTshirtSize(42) == "L");
        // below test case should fail
        assert(getTshirtSize(38) == "M");
    }
}
