/**
 * Created by Паша on 10.11.2014.
 */
class Model {
    int width = 10;
    int height = 10;
    int cellSize = 50;
    //Так по-моему все-таки правильнее, хоть на занятии я сам так и написал изначально model
    boolean field[][] = new boolean[height][width];

    Model() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                field[i][j] = false;
        }

    }

    //Названия методов - camelCase'ом
    public void doIteration() {
        boolean copy[][] = new boolean[height][width];
        int i;
        int j;
        int a; //i-1
        int b; //i+1
        int c; //j-1
        int d; //j+1
        //Осмысленные имена - где можете
        int neighbors;
        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {
                a = (i == 0) ? height - 1 : i - 1;
                b = (i == height - 1) ? 0 : i + 1;
                c = (j == 0) ? width - 1 : j - 1;
                d = (j == width - 1) ? 0 : j + 1;

                neighbors = 0;
                if (field[a][c]) neighbors++;
                if (field[a][j]) neighbors++;
                if (field[a][d]) neighbors++;
                if (field[i][c]) neighbors++;
                if (field[i][d]) neighbors++;
                if (field[b][c]) neighbors++;
                if (field[b][j]) neighbors++;
                if (field[b][d]) neighbors++;

                if (!field[i][j]) {
                    copy[i][j] = (neighbors == 3);
                } else {
                    copy[i][j] = (neighbors == 3 || neighbors == 2);
                }
            }
        }
        field = copy;
    }
}

