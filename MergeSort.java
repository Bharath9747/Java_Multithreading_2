import java.util.ArrayList;
import java.util.concurrent.*;

public class MergeSort {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(2);
        arr.add(23);
        arr.add(11);
        arr.add(21);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<ArrayList<Integer>> listFuture = executorService.submit(new MergeSortCal(arr));
        ArrayList<Integer> res = listFuture.get();
        System.out.println(res);
        executorService.shutdown();
    }
}
