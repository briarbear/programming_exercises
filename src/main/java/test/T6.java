package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 头条第二批笔试题1
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-25-10:38
 */
public class T6 {

    int[] parent;
    int[] rank;
    int[] sz;
    int N;
    public T6(int n) {
        N = n;
        parent = new int[N];
        rank = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void Union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;

        if (rank[xr] < rank[yr]) {
            int tmp = yr;
            yr = xr;
            xr = tmp;
        }
        if (rank[xr] == rank[yr])
            rank[xr]++;

        parent[yr] = xr;
        sz[xr] += sz[yr];
    }

    int size(int x) {
        return sz[find(x)];
    }

    int top() {
        return size(N - 1) - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();

            T6 d = new T6(n + 1);
            int t;

            for (int i = 0; i < n; i++) {
                while ((t = scanner.nextInt()) != 0){
                    d.Union(i+1,t);
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (d.find(i) == i) ans++;
            }

            System.out.println(ans);
        }

    }
}


