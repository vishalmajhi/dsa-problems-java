import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remaining,
            int start) {
        if (remaining < 0) {
            return;
        } else if (remaining == 0) {
            result.add(new ArrayList<>(currentList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentList.add(candidates[i]);
                backtrack(result, currentList, candidates, remaining - candidates[i], i); // Note the recursion with 'i'
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationalSum combinationSum = new CombinationalSum();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}