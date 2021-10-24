public class HomeWork2 {
    final static int MAX_SIZE = 4;

    public static void main(String[] args) {
        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        try {
            System.out.println(checkAndSum(matrix));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int checkAndSum(String[][] matrix) throws MyArraySizeException, MyArrayDataException {

        // Проверка размерности: количества массивов...
        if(matrix.length != MAX_SIZE) {
            throw new MyArraySizeException("Некорректное количество массивов");
        }

        // Проверка размерности: количества элементов массива...
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i].length != MAX_SIZE) {
                throw new MyArraySizeException("Некорректное количество элементов массива");
            }
        }

        // Суммирование элементов матрицы...
        int sum = 0;
        for(int row=0; row<matrix.length; row++) {
            for(int col=0; col<matrix[row].length; col++) {
                try {
                    sum += Integer.parseInt(matrix[row][col].trim());
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(matrix[row][col], col, row);
                }
            }
        }

        return sum;
    }
}


// Исключение: некорректный размер массива...
class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super(message);
    }
}


// Исключение: некорретный элемент массива...
class MyArrayDataException extends Exception {
    public int col;
    public int row;

    public MyArrayDataException(Object obj, int col, int row) {
        super("Некорректное значение \"" + obj.toString() + "\". Колонка " + col + " Строка " + row);

        this.col = col;
        this.row = row;
    }
}
