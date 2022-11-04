import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }

        void insert(int n){
            // 현재 노드의 값 보다 작을 때
            if(n < this.value){
                // 왼쪽이 비어있으면 왼쪽에 넣기
                if (this.left == null) {
                    this.left = new Node(n);
                }
                // 비어 있지 않으면 왼쪽노드에 붙이기
                else{
                    this.left.insert(n);
                }
            }
            // 현재 노드의 값 보다 클 때
            else{
                // 오른쪽 비어 있으면 오른쪽에 넣기
                if(this.right == null){
                    this.right = new Node(n);
                }
                // 아니면 오른쪽 노드에게 붙이기
                else{
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}