import sliding_windows.easy.Solution_SW_E;
public class Main {
    public static void main(String[] args) {

        Solution_SW_E solution_sw_e = new Solution_SW_E();

        System.out.println(solution_sw_e.countGoodSubstrings("xyzzaz")); //return 1
        System.out.println(solution_sw_e.countGoodSubstrings("aababcabc")); //return 4
    }
}