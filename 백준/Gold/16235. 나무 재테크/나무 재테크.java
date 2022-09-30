
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int [][] map;

    static int [][] winter;

    static PriorityQueue<Tree> pq;
    // 가을 나무 번식 위한 8방 탐색
    static int [][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    // 나이순으로 뽑기 위해 comparable
    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        pq = new PriorityQueue<>();
        winter = new int [N][N];



        // 초기 양분은 5
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = 5;
            }
        }

        // 겨울에 넣을 양분
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int plus = Integer.parseInt(st.nextToken());
                winter[i][j] = plus;
            }
        }

        for(int i = 0; i < M; i++){
            // x, y 좌표 받고 해당 좌표에 들어갈 나무의 나이 넣기
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            pq.add(new Tree(x, y, age));
        }

        int year = 0;
        while (year < K){
            Queue<Tree> deadTree = new LinkedList<>();
            Queue<Tree> aliveTree = new LinkedList<>();

            // 봄일 때 나이만큼 양분 먹고, 나이 1증가 / 양분이 자신의 나이만큼 없으면 먹지 못하고 죽음
            while (!pq.isEmpty()){
                Tree tree = pq.poll();
                // 나이만큼 양분 있을 때 양분 빼기
                if(map[tree.x][tree.y] >= tree.age){
                    map[tree.x][tree.y] -= tree.age;
                    // 나이 1 먹여서 살아있는 나무에 넣기
                    Tree tree1 = new Tree(tree.x, tree.y, tree.age + 1);
                    aliveTree.add(tree1);
                }
                // 안되면 데드 트리에 저장
                else{
                    deadTree.add(tree);
                }
            }

            // 여름일때 해당 나무의 양분 더해주기
            while (!deadTree.isEmpty()){
                Tree tree = deadTree.poll();
                int food = tree.age / 2;
                map[tree.x][tree.y] += food;
            }

            // 가을에 나무 늘리기
            while (!aliveTree.isEmpty()){
                Tree tree = aliveTree.poll();
                // 5의 배수의 나이이면
                if(tree.age % 5 == 0){
                    for(int k = 0; k < 8; k++){
                        int nr = tree.x + dir[k][0];
                        int nc = tree.y + dir[k][1];
                        // 범위 안에 있으면
                        if(nr >= 0 && nr < N && nc >= 0 && nc <N){
                            // 나이 1짜리 나무 넣어주기
                            Tree tree1 = new Tree(nr, nc, 1);
                            pq.add(tree1);
                        }
                    }
                }
                // 살아있는 나무들은 다시 넣기
                pq.add(tree);
            }
            
            // 겨울에 양분 다시 추가하기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] += winter[i][j];
                }
            }

            // 1년 증가
            year++;
        }

        // 살아 남아있는 나무 갯수
        System.out.println(pq.size());

    }

}