import java.util.ArrayList;
import java.util.concurrent.Callable;

public class QuickSortCal implements Callable{
    ArrayList<Integer> arr;
    public QuickSortCal(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public Object call() throws Exception {
         quicksort(0,arr.size()-1,arr);
        return null;
    }

    private void quicksort(int i, int i1, ArrayList<Integer> arr) {
        if (i < i1) {
            int pi = partition(arr, i, i1);
            quicksort( i, pi - 1,arr);
            quicksort( pi + 1, i1,arr);
        }
    }


    static void swap(ArrayList<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i,j);
        arr.set(j,temp);
    }
    static int partition(ArrayList<Integer> arr, int low, int high)
    {
        int pivot = arr.get(high);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr.get(j) < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
