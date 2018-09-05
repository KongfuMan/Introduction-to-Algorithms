import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NQueens {
    public class Coord{
        public int i;
        public int j;
        public Coord(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> solution(int n){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        NQueensHelper(result,new ArrayList<Integer>(),n);
        return result;
    }

//    private List<List<String>>  drawChessBoard(List<List<Integer>> result){
//        List<List<String>> chessboard = new ArrayList<List<String>>();
//        for(int i = 0; i < result.size(); i++){
//            for (int j = 0; j < result.get(i).size(); j++){
//                if (result.get(i).get(j) ==)
//            }
//        }
//
//    }

    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++){
            if(col == cols.get(i)){
                return false;
            }

            if(Math.abs(row - i) == Math.abs(col - cols.get(i))){
                return false;
            }
        }
        return true;
    }

    public void NQueensHelper(List<List<Integer>> result,
                              List<Integer> cols,
                              int n
                              ){
        if (cols.size() == n){
            result.add(new ArrayList<Integer>(cols));
            return;
        }

        for(int col = 0; col < n; col++){
            if (!isValid(cols,col)){
                continue;
            }

            cols.add(col);
            NQueensHelper(result,cols,n);
            cols.remove(cols.size()-1);
        }
    }
}
