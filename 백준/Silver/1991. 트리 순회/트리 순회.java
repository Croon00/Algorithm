
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static class Node{
        char data;
        Node left;
        Node right;
        public Node(char data){
            this.data = data;
        }
    }

    static class Tree{
        Node Root;

        // 루트 넣고 왼쪽 부터 채우고 오른쪽채우기,
        public void add(char data, char leftData, char rightData){
            // 루트가 채워져 있지 않았을 때 데이터 넣기
            if(Root == null) {
                if(data !='.') Root = new Node(data);
                if (leftData != '.') Root.left = new Node(leftData);
                if (rightData != '.') Root.right = new Node(rightData);
                // root가 채워져 있을 때 다음 노드를 루트로 넣으러 가기
            }
            else Move(Root, data, leftData, rightData);
        }

        // 다음 데이터로 이동
        public void Move(Node Root, char data, char leftData, char rightData){
            // root 가 null이면 끝내기
            if(Root == null) return;

                // 루트 노드의 데이터가 data라면 right랑 left 넣기
            else if(Root.data == data){
                if(leftData != '.') Root.left = new Node(leftData);
                if(rightData != '.') Root.right = new Node(rightData);
            }

            // 못 찾았을 때 왼쪽 부터 찾아서 들어가기
            else{
                Move(Root.left, data, leftData, rightData);
                Move(Root.right, data, leftData, rightData);
            }
        }

        // 전위 순회
        // 가운데 -- 좌 -- 우 임으로 출력 하고 왼쪽 들어가고 오른쪽 들어가기
        public void PreOrder(Node root){
            System.out.print(root.data);

            if(root.left != null) PreOrder(root.left);

            if(root.right != null) PreOrder(root.right);
        }
        // 중위 순회
        // 좌 -- 가운데 - 우 임으로 왼쪽 들어가고 출력하고 오른쪽 들어가기
        public void InOrder(Node root){
            if(root.left != null) InOrder(root.left);
            System.out.print(root.data);
            if(root.right != null) InOrder(root.right);
        }

        // 후위 순회
        // 좌 -- 우 -- 가운데 --> 왼쪽 들어가고 오른쪽 들어가고 출력하기
        public void PostOrder(Node root){
            if(root.left != null) PostOrder(root.left);
            if(root.right != null) PostOrder(root.right);
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            tree.add(a.charAt(0), b.charAt(0), c.charAt(0));
        }

        tree.PreOrder(tree.Root);
        System.out.println();
        tree.InOrder(tree.Root);
        System.out.println();
        tree.PostOrder(tree.Root);
    }
}
