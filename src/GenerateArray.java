import java.util.Random;

public class GenerateArray {
    public static Integer[] generateArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10; // генерируем числа от -10 до 10
        }
        return array;
    }
}
