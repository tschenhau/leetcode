class Solution {
    class Node {
        String a;
        int cur, val, step;

        Node(String _a, int _c, int _v, int _s) {
            a = _a;
            cur = _c;
            val = _v;
            step = _s;
        }
    }

    int f(String a, int k) {
        Map<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            m1.put(a.charAt(i), m1.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) == 0)
                m2.put(b.charAt(i), m2.getOrDefault(b.charAt(i), 0) + 1);
        }
        int ans = 0;
        for (char c : m1.keySet()) {
            int c1 = m1.get(c), c2 = m2.getOrDefault(c, 0);
            if (c1 + c2 < 3)
                return INF;
            if (c1 < 3)
                ans += (3 - c1);
        }
        return ans;
    }

    int INF = 0x3f3f3f3f;
    String b;
    int m;
    Map<String, Integer> map = new HashMap<>();

    public int findMinStep(String _a, String _b) {
        b = _b;
        m = b.length();
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> (o1.val + o1.step) - (o2.val + o2.step));
        q.add(new Node(_a, 1 << m, f(_a, 1 << m), 0));
        map.put(_a + "_" + (1 << m), 0);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            String a = poll.a;
            int cur = poll.cur;
            int step = poll.step;
            int n = a.length();
            for (int i = 0; i < m; i++) {
                if (((cur >> i) & 1) == 1)
                    continue;
                int next = (1 << i) | cur;
                for (int j = 0; j <= n; j++) {
                    boolean ok = false;
                    if (j > 0 && j < n && a.charAt(j) == a.charAt(j - 1) && a.charAt(j - 1) != b.charAt(i))
                        ok = true;
                    if (j < n && a.charAt(j) == b.charAt(i))
                        ok = true;
                    if (!ok)
                        continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(a.substring(0, j)).append(b.substring(i, i + 1));
                    if (j != n)
                        sb.append(a.substring(j));
                    int k = j;
                    while (0 <= k && k < sb.length()) {
                        char c = sb.charAt(k);
                        int l = k, r = k;
                        while (l >= 0 && sb.charAt(l) == c)
                            l--;
                        while (r < sb.length() && sb.charAt(r) == c)
                            r++;
                        if (r - l - 1 >= 3) {
                            sb.delete(l + 1, r);
                            k = l >= 0 ? l : r;
                        } else {
                            break;
                        }
                    }
                    String nextStr = sb.toString();
                    if (nextStr.length() == 0)
                        return step + 1;
                    if (f(nextStr, next) == INF)
                        continue;
                    String hashKey = nextStr + "_" + next;
                    if (!map.containsKey(hashKey) || map.get(hashKey) > step + 1) {
                        map.put(hashKey, step + 1);
                        q.add(new Node(nextStr, next, f(nextStr, next), step + 1));
                    }
                }
            }
        }
        return -1;
    }
}