import java.util.ArrayList;
import java.util.List;
class Solution {
     public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        int m = matrix.length;
    int n = matrix[0].length;
    int col=-1,row=0;
    while(n>0 && m>0){
        for(int i=0;i<n;i++){col+=1;l.add(matrix[row][col]);}
        m--;if(m==0){break;}
        for(int i=0;i<m;i++){row+=1;l.add(matrix[row][col]);}
        n--;if(n==0){break;}
        for(int i=0;i<n;i++){col-=1;l.add(matrix[row][col]);}
        m--;if(m==0){break;}
        for(int i=0;i<m;i++){row-=1;l.add(matrix[row][col]);}
        n--;if(n==0){break;}
    }
    return l;
    }

    public static void main(String[] args) {
        int[][] m = new int[6][6];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j] = 6*i + (j+1);
            }
        }
        System.out.println("Matrix In Normal Order : \n");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"\t");
            }
            System.out.println("\n");
        }
        System.out.println("Matrix In Spiral Order : \n");
        System.out.println(spiralOrder(m));
    }
}