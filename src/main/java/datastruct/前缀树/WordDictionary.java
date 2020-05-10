package datastruct.前缀树;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * <p>
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {

    static TrieNode root;

    static class TrieNode {
        boolean isEnd;
        TrieNode[] next;

        TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public static void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public static boolean search(String word) {
        return searchByDfs(word, 0,root);
    }

    public static boolean searchByDfs(String word, int index,TrieNode r) {
        TrieNode node = r;

        boolean bool = false;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println(c);
            if (c == '.') {

                for (int j = 0;j < 26;j++) {
                    if (node.next[j] != null)
                        bool = bool || searchByDfs(word, i + 1,node.next[j]);
                }
                return bool;
            } else {
                if (node.next[c - 'a'] == null) {
                    return false;
                }
                node = node.next[c - 'a'];
            }
        }
        return node.isEnd;
    }


    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
//        System.out.println(obj.search("pad"));
//        System.out.println(search("bad"));
//        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b."));
//                * search(".ad") -> true
//                * search("b..") -> true
    }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */