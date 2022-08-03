import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Elements implements Comparable<Elements>{
        public String name;
        public int ko, en, math;

        @Override
        public int compareTo(Elements o) {
            if(o.ko == this.ko){
                if(this.en == o.en){
                    if(this.math == o.math){
                        return name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.en - o.en;
            }
            else{
                return o.ko - this.ko;
            }


        }
    }
    static int N;
    static Elements[] a;
    static void input(){
        FastReader fr = new FastReader();
        Elements e = new Elements();
        N = fr.nextInt();
        a = new Elements[N];
        for(int i = 0; i < N; i++){
            a[i] = new Elements();
            a[i].name = fr.next();
            a[i].ko = fr.nextInt();
            a[i].en = fr.nextInt();
            a[i].math = fr.nextInt();
        }
    }

    static void sort(){
        Arrays.sort(a);
        for (int i = 0; i <a.length; i++){
            sb.append(a[i].name).append('\n');
        }
    }


    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}