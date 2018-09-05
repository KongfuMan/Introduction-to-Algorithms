import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combineHelper(result,new ArrayList<Integer>(),n,k,0);
        return  result;
    }

    private void combineHelper(List<List<Integer>> result,
                              List<Integer> onecombine,
                              int n,
                              int k,
                              int pos
    ){

        for ( int i = pos; i < n; i++ ){
            onecombine.add(i+1);
            combineHelper(result,onecombine,n,k,i+1);
            onecombine.remove(onecombine.size()-1);
        }

        if ( onecombine.size() == k ){
            result.add(new ArrayList<Integer>(onecombine));
            return;
        }
    }
}
