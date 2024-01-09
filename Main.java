import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("For an m x n grid, you begin at the top-left corner and your goal is to reach the bottom-right corner only moving down or to the right.");
        System.out.println("In how many ways can you travel to the goal?\n");
        System.out.println("Possible Paths For a 1x1 Grid: " + gridTraveler(1, 1)); // Expected: 1
        System.out.println("Possible Paths For a 2x3 Grid: " + gridTraveler(2, 3)); // Expected: 3
        System.out.println("Possible Paths For a 3x2 Grid: " + gridTraveler(3, 2)); // Expected: 3
        System.out.println("Possible Paths For a 3x3 Grid: " + gridTraveler(3, 3)); // Expected: 6

        // Create a hash map to store intermediate values
        HashMap<String, Long> solutions = new HashMap<String, Long>();
        System.out.println("Possible Paths For a 18x18 Grid: " + improvedGridTraveler(18, 18, solutions)); // Expected: 2333606220
    }

    static int gridTraveler(int rows, int columns) {
        // Base Cases
        // Invalid Grid
        if (rows <= 0 || columns <= 0) {
            return 0; // There are 0 ways to traverse these grids
        }

        // 1x1 Grid
        if (rows == 1 && columns == 1) {
            return 1;
        }

        // Return the sum of the number of times moving down and the number of times moving to the right
        return gridTraveler(rows - 1, columns) + gridTraveler(rows, columns - 1);
    }

    static long improvedGridTraveler(long rows, long columns, HashMap<String, Long> solutions) {
        // Base Cases
        // Invalid Grid
        if (rows == 0 || columns == 0) {
            return 0; // There are 0 ways to traverse these grids
        }

        // 1x1 Grid
        if (rows == 1 && columns == 1) {
            return 1;
        }

        // Concatenate rows and columns to form key (m, n)
        String key = rows + ", " + columns;
        String reverse_key = columns + ", " + rows;

        // Search hashmap for existing keys
        if (solutions.containsKey(key)) {
            return solutions.get(key);
        }
        else if (solutions.containsKey(reverse_key)) {
            return solutions.get(reverse_key);
        }

        // The result is unique and will be stored in the hash map
        long result = improvedGridTraveler(rows - 1, columns, solutions) + improvedGridTraveler(rows, columns - 1, solutions);
        solutions.put(key, result);
        
        return result;
    }
}
