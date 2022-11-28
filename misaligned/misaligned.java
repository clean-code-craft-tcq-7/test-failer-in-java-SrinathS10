public class misaligned {
    static final String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
    static final String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};

    static int printColorMap() {
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.println(getColorPairFromIndex(i,j));
            }
        }
        return i * j;
    }

    static String getColorPairFromIndex(int i,int j){
        // Returns color pair along with index separated by |
        // Color index position - 0, Major Color index - 5, Minor Color index - 18
        return String.format("%-2d | %-10s | %-10s ",(i*5)+j+1,majorColors[i],minorColors[j]);
    }

    static void testColorPairPrint(){
        int result = printColorMap();
        assert(result == 25);

        // testing individual cases
        String colorPairStr;
        colorPairStr = getColorPairFromIndex(4,4);
        assert(colorPairStr.contains("Violet"));
        assert(colorPairStr.substring(3,4).contains("|") && colorPairStr.substring(16,17).contains("|"));
        assert(colorPairStr.substring(0,2).contains("25"));

        colorPairStr = getColorPairFromIndex(0,1);
        assert(colorPairStr.contains("Orange") && colorPairStr.contains("White"));
    }

    public static void main(String[] args) {
        testColorPairPrint();
        System.out.println("All is well (maybe!)");
    }
}
