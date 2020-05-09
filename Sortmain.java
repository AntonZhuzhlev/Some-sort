package sortpackage;

public class Sortmain {
    public static void main(String[] args) {

    }

    public static void mergeSort(int[] array, int left, int right) {
        // проверяем состоит ли промежуток из 1 элемента
        if (right <= left) return;
        int mid = (left + right) / 2;
        // выбираем середину, сортируем левую половину, потом правую, а потом делаем слияние
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    static void merge(int[] array, int left, int mid, int right) {
        // сам алгоритм слияния
        int lengthleft = mid - left + 1;
        int lengthright = right - mid;

        // создаем вспомогательные массивы с элементами левой части и правой части
        int leftarray[] = new int[lengthleft];
        int rightarray[] = new int[lengthright];

        for (int i = 0; i < lengthleft; i++) {
            leftarray[i] = array[left + i];
        }
        for (int i = 0; i < lengthright; i++) {
            rightarray[i] = array[mid + i + 1];
        }

        // введем два параметра для движения по левому и по правому массиву
        int leftindex = 0;
        int rightindex = 0;

        // постоянно сравниваем текущий элемент левого и текущий элемент правого массива, а потом вставляем меньший из них в текущую ячейку изначального массива
        for (int i = left; i < right + 1; i++) {
            if (leftindex < lengthleft && rightindex < lengthright) {
                if (leftarray[leftindex] < rightarray[rightindex]) {
                    array[i] = leftarray[leftindex];
                    leftindex++;
                } else {
                    array[i] = rightarray[rightindex];
                    rightindex++;
                }
            } else if (leftindex < lengthleft) {
                array[i] = leftarray[leftindex];
                leftindex++;
            } else if (rightindex < lengthright) {
                array[i] = rightarray[rightindex];
                rightindex++;
            }
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        int leftindex = left;
        int rightindex = right;
        int mid = (leftindex + rightindex) / 2;
        int pivot = array[mid];
        while (leftindex < rightindex) {
            // будем идти по левой части и по правой до тех пор, пока слева не наткнемся на "большой" элемент, а справа на "маленький", а тогда меняем их
            while (array[leftindex] < pivot) {
                leftindex++;
            }
            while (array[rightindex] >= pivot) {
                rightindex--;
            }
            if (leftindex < rightindex) {
                int x = array[leftindex];
                array[leftindex] = array[rightindex];
                array[rightindex] = x;
                leftindex++;
                rightindex--;
            }
        }
        // теперь нужно применить сортировку к левой "маленькой" части и правой "большой" части
        quickSort(array, left, rightindex);
        quickSort(array, leftindex, right);
    }
}