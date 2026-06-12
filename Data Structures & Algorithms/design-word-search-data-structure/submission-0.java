class WordDictionary {
    class Node {
        Node[] children;
        boolean isEnd;
        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new Node();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, Node n, int idx) {
        if (idx == word.length())
            return n.isEnd;
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                if (n.children[j] != null && dfs(word, n.children[j], idx + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (n.children[ch - 'a'] == null)
                return false;
            return dfs(word, n.children[ch - 'a'], idx + 1);
        }
    }
}
