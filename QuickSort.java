import java.util.ArrayList;
import java.util.concurrent.*;

public class QuickSort {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(2);
        arr.add(23);
        arr.add(11);
        arr.add(21);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        QuickSortCal quickSortCal = new QuickSortCal(arr);
        Future<ArrayList<Integer>> listFuture = executorService.submit(quickSortCal);
        ArrayList<Integer> res = listFuture.get();
        System.out.println(quickSortCal.arr);
        executorService.shutdown();
    }
}
