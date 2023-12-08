import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class QuickSortCal implements Callable<List<Integer>>{
    List<Integer> arr;
    public QuickSortCal(List<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public List<Integer> call() throws Exception {
         quicksort(arr);
        return arr;
    }

    private void quicksort( List<Integer> arr) throws ExecutionException, InterruptedException {
        if (arr.size() > 1) {
            int pi = arr.get(0);
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            for(int i=1;i<arr.size();i++)
            {
                if(arr.get(i)<=pi)
                    leftList.add(arr.get(i));
                else
                    rightList.add(arr.get(i));
            }

            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<List<Integer>> leftpartition = executorService.submit(new QuickSortCal(leftList));
            Future<List<Integer>> rightpartition = executorService.submit(new QuickSortCal(rightList));
            List<Integer> lr = leftpartition.get();
            List<Integer> rr = rightpartition.get();
            arr.clear();
            arr.addAll(lr);
            arr.add(pi);
            arr.addAll(rr);
            executorService.shutdown();
        }
    }


    static void swap(List<Integer> arr, int i, int j)
    {
        int temp = arr.get(i);
        arr.set(i,j);
        arr.set(j,temp);
    }
    static int partition(List<Integer> arr, int low, int high)
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
