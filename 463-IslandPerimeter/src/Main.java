public class Main {

    public static int perimeterHelper(int[][] grid, int i, int j) {
        int count = 0;
        int height = grid.length;
        int width = grid[0].length;

        if ( i - 1 < 0 ) {
            count++;
        }

        if ( j - 1 < 0 ) {
            count++;
        }

        if ( i + 1 >= height ) {
            count++;
        }

        if ( j + 1 >= width ) {
            count++;
        }

        if ( i - 1 >= 0 && grid[i-1][j] == 0) {
            count++;
        }

        if ( i + 1 < height && grid[i+1][j] == 0) {
            count++;
        }

        if ( j - 1 >= 0 && grid[i][j-1] == 0) {
            count++;
        }

        if ( j + 1 < width && grid[i][j+1] == 0) {
            count++;
        }

        grid[i][j] = 2;

        if ( i - 1 >= 0 && grid[i-1][j] == 1) {
            count += perimeterHelper(grid, i-1, j);
        }

        if ( i + 1 < height && grid[i+1][j] == 1) {
            count += perimeterHelper(grid, i+1, j);
        }

        if ( j - 1 >= 0 && grid[i][j-1] == 1) {
            count += perimeterHelper(grid, i, j-1);
        }

        if ( j + 1 < width && grid[i][j+1] == 1) {
            count += perimeterHelper(grid, i, j+1);
        }

        return count;

    }

    public static int islandPerimeter(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        for ( int i = 0; i < height; i++ ) {
            for ( int j = 0; j < width; j++ ) {
                if ( grid[i][j] == 1) {
                    return perimeterHelper(grid, i, j);
                }
            }
        }



        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1, 0,0}};

        System.out.println(islandPerimeter(grid));
    }
}
