public class WordDictionary {
    class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isEnd = false;
    }
    
    TrieNode root;
    public WordDictionary(){
        this.root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    public boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) return node.isEnd;
        HashMap<Character, TrieNode> children = node.children;
        char c = word.charAt(index);
        if (children.containsKey(c)) {
            return searchHelper(children.get(c), word, index + 1);
        } else if (c == '.'){ // wild card
            for (TrieNode childNode : children.values()) {
                if (searchHelper(childNode, word, index + 1)) return true;
            }
        }
        return false; // all search failed
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */