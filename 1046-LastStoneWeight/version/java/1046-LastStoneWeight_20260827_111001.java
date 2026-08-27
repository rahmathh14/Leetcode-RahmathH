// Last updated: 8/27/2026, 11:10:01 AM
1import java.util.*;
2
3class Solution {
4    public String countOfAtoms(String formula) {
5        Stack<Map<String, Integer>> stack = new Stack<>();
6        stack.push(new TreeMap<>());
7
8        int i = 0;
9
10        while (i < formula.length()) {
11
12            char ch = formula.charAt(i);
13
14            if (ch == '(') {
15                stack.push(new TreeMap<>());
16                i++;
17            }
18
19            else if (ch == ')') {
20                Map<String, Integer> current = stack.pop();
21                i++;
22
23                int start = i;
24
25                while (i < formula.length() &&
26                       Character.isDigit(formula.charAt(i))) {
27                    i++;
28                }
29
30                int multiplier = start == i
31                        ? 1
32                        : Integer.parseInt(formula.substring(start, i));
33
34                for (String element : current.keySet()) {
35                    int count = current.get(element) * multiplier;
36
37                    stack.peek().put(
38                        element,
39                        stack.peek().getOrDefault(element, 0) + count
40                    );
41                }
42            }
43
44            else {
45                int start = i;
46                i++;
47
48                while (i < formula.length() &&
49                       Character.isLowerCase(formula.charAt(i))) {
50                    i++;
51                }
52
53                String element = formula.substring(start, i);
54
55                start = i;
56
57                while (i < formula.length() &&
58                       Character.isDigit(formula.charAt(i))) {
59                    i++;
60                }
61
62                int count = start == i
63                        ? 1
64                        : Integer.parseInt(formula.substring(start, i));
65
66                stack.peek().put(
67                    element,
68                    stack.peek().getOrDefault(element, 0) + count
69                );
70            }
71        }
72
73        StringBuilder result = new StringBuilder();
74
75        for (Map.Entry<String, Integer> entry :
76             stack.peek().entrySet()) {
77
78            result.append(entry.getKey());
79
80            if (entry.getValue() > 1) {
81                result.append(entry.getValue());
82            }
83        }
84
85        return result.toString();
86    }
87}