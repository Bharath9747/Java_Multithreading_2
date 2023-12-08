import java.util.ArrayList;
import java.util.concurrent.*;

public class MergeSortCal implements Callable<ArrayList<Integer>> {
    private ArrayList<Integer> arr;

    public MergeSortCal(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        return mergesort(arr);
    }

    private ArrayList<Integer> mergesort(ArrayList<Integer> arr) throws ExecutionException, InterruptedException {
        if(arr.size()<=1)
            return arr;
        int size = arr.size()/2;
        ArrayList<Integer> leftList = new ArrayList<>(arr.subList(0,size));
        ArrayList<Integer> rightList = new ArrayList<>(arr.subList(size,arr.size()));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<ArrayList<Integer>> leftFuture = executorService.submit(new MergeSortCal(leftList));
        Future<ArrayList<Integer>> rightFuture = executorService.submit(new MergeSortCal(rightList));
        leftList = leftFuture.get();
        rightList = rightFuture.get();
        executorService.shutdown();
        return merge(leftList,rightList);

    }

    private ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0;
        int lsize=leftList.size(),rsize = rightList.size();
        while (i<lsize && j<rsize)
        {
            if(leftList.get(i)<=rightList.get(j))
            {
                res.add(leftList.get(i));
                i++;
            }
            else
            {
                res.add(rightList.get(j));
                j++;
            }
        }
        while(i<lsize)
        {
            res.add(leftList.get(i));
            i++;
        }
        while(j<rsize)
        {
            res.add(rightList.get(j));
            j++;
        }
        return res;
    }
}
