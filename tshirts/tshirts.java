public class tshirts{
    static String getTshirtSize(int cms) {
        // assuming size-38 is M and size-42 is L
        if(cms < 38) {
            return "S";
        } else if(cms >= 38 && cms < 42) {
            return "M";
        } else {
            return "L";
        }
    }

    static void testTshirtSize(){
        assert(getTshirtSize(37) == "S");
        assert(getTshirtSize(40) == "M");
        assert(getTshirtSize(43) == "L");
        assert(getTshirtSize(42) == "L");
        assert(getTshirtSize(38) == "M");
    }

    public static void main(String[] args) { 
        testTshirtSize();
        System.out.println("All is well (maybe!)");
    }
}
