public class misaligned {
    static String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
    static String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
    static int printColorMap() {
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.printf(getColorPairFromIndex(i,j));
            }
        }
        return i * j;
    }
    static String getColorPairFromIndex(int i,int j){
        return String.format("%d | %s | %s\n", i * 5 + j, majorColors[i], minorColors[i]);
    }
    /*
    static String getColorPairFromIndexImpl(int i,int j){
        // Returns color pair along with index separated by |
        // Color index position - 0, Major Color index - 5, Minor Color index - 18
        return String.format("%-2d | %-10s | %-10s ",(i*5)+j+1,majorColors[i],minorColors[j]);
    }
    */
    static void testColorPairPrint(){
        int result = printColorMap();
        assert(result == 25);

        String colorPairStr;
        // double-digit pair number check
        colorPairStr = getColorPairFromIndex(4,4);
        assert(colorPairStr.contains("Violet") && colorPairStr.contains("Slate"));
        assert(colorPairStr.substring(3,4).equals("|"));
        assert(colorPairStr.contains("25"));

        // single-digit pair number check
        colorPairStr = getColorPairFromIndex(0,1);
        assert(colorPairStr.contains("Orange") && colorPairStr.contains("White"));
        assert(colorPairStr.substring(3,4).equals("|"));

        colorPairStr = getColorPairFromIndex(2,2);
        assert(colorPairStr.contains("Black") && colorPairStr.contains("Green"));

    }

    public static void main(String[] args) {
        testColorPairPrint();
        System.out.println("All is well (maybe!)");
    }
}
