public class misaligned {
    static String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
    static String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};

    static String formatColorPairFromIndex(int i,int j){
        // Returns color pair along with index separated by |
        // Assuming Below alignments
        // Color index position - 0, Major Color index - 5, Minor Color index - 18
        // Separator (|) index - 3 and 16
        return String.format("%-2d | %-10s | %-10s ", (i*5)+j+1, majorColors[i], minorColors[j]);
    }

    static int printColorMap() {
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.println(formatColorPairFromIndex(i,j));
            }
        }
        return i * j;
    }

    static void testColorPairPrint(){
        int result = printColorMap();
        assert(result == 25);

        String colorPairStr;
        // double-digit pair number check
        colorPairStr = formatColorPairFromIndex(4,4);
        assert(colorPairStr.contains(majorColors[4]) && colorPairStr.contains(minorColors[4]));
        assert(colorPairStr.charAt(3) == '|');
        assert(colorPairStr.contains("25"));

        // single-digit pair number check
        colorPairStr = formatColorPairFromIndex(0,1);
        assert(colorPairStr.contains(majorColors[0]) && colorPairStr.contains(minorColors[1]));
        assert(colorPairStr.charAt(3) == '|');
        assert(colorPairStr.contains("2"));

        colorPairStr = formatColorPairFromIndex(2,2);
        assert(colorPairStr.contains(majorColors[2]) && colorPairStr.contains(minorColors[2]));
        assert(colorPairStr.charAt(3) == '|');
        assert(colorPairStr.charAt(16) == '|');
        assert(colorPairStr.contains("13"));
    }

    public static void main(String[] args) {
        testColorPairPrint();
        System.out.println("All is well (maybe!)");
    }
}
