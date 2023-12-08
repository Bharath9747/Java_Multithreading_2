import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class QuickSort {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(2);
        arr.add(23);
        arr.add(11);
        arr.add(21);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        QuickSortCal quickSortCal = new QuickSortCal(arr);
        Future<List<Integer>> listFuture = executorService.submit(quickSortCal);
        List<Integer> res = listFuture.get();
        System.out.println(res);
        executorService.shutdown();
    }
}
