import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
    static class Vertex{
        String data;
        int num, left, right;

        Vertex(int num, String data,int left, int right){
            this.num = num;
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }
    static Vertex [] tree;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1; tc <= 10; tc++){
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            tree = new Vertex[N+1];
            ans = "";
            for(int i = 1; i < N+1; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String alphabet = st.nextToken();
                int left = 0;
                int right = 0;
                if(st.hasMoreElements()){
                    left = Integer.parseInt(st.nextToken());
                }
                if(st.hasMoreElements()){
                    right = Integer.parseInt(st.nextToken());
                }
                Vertex vertex = new Vertex(num,alphabet,left,right);
               tree[i] = vertex;
            }
            In_order(tree[1]);
            System.out.println("#" + tc + " " + ans);
        }
    }
    static void In_order(Vertex vertex){
        if(vertex.left == 0 && vertex.right == 0){
            ans+=vertex.data;
            return;
        }
        if(vertex.left != 0){
            In_order(tree[vertex.left]);
            vertex.left = 0;
        }
        ans += vertex.data;
        if(vertex.right != 0){
            In_order(tree[vertex.right]);
            vertex.right = 0;
        }
    }
    static void pre_order(Vertex vertex){
        ans+= vertex.data;
        if(vertex.left != 0){
            pre_order(tree[vertex.left]);
        }
        if(vertex.right != 0){
            pre_order(tree[vertex.right]);
        }
    }
    static void post_order(Vertex vertex){
        if(vertex.left == 0 && vertex.right ==0){
            ans += vertex.data;
            return;
        }
        if(vertex.left != 0){
            post_order(tree[vertex.left]);
        }
        if(vertex.right !=0 ){
            post_order(tree[vertex.right]);
        }
        ans += vertex.data;
    }
}
