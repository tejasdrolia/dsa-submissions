class PrefixTree {
    class Node {
        Node[] children;
        boolean isEnd;
        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null)
                return false;
            temp = temp.children[ch - 'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (temp.children[ch - 'a'] == null)
                return false;
            temp = temp.children[ch - 'a'];
        }
        return true;
    }
}
