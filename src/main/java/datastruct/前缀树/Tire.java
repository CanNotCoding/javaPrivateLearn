package datastruct.前缀树;


import java.util.Arrays;

/**
 *
 *
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 通过次数35,624提交次数53,280
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Tire {

    static class TireNode {

        boolean isEnd;
        TireNode[] next;

        TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }

    Tire() {
        tree = new TireNode();
    }

    static TireNode tree;

    public static void main(String[] args) {
        Tire trie = new Tire();

        trie.insertWords("apple");
        System.out.println(trie.searchWords("apple"));  // 返回 true
        System.out.println(trie.searchWords("app"));// 返回 false
        System.out.println(trie.startsWithWords("app"));   // 返回 true

        trie.insertWords("app");
        System.out.println(trie.searchWords("app"));//返回true

        String[] a = new String[3];


    }


    public static void insertWords(String words) {
        TireNode root = tree;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new TireNode();
            }
            root = root.next[c - 'a'];
        }
        root.isEnd = true;
    }

    public static boolean searchWords(String words) {
        TireNode root = tree;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (root.next[c - 'a'] == null) {
                return false;
            }
            root = root.next[c - 'a'];
        }
        return root.isEnd;
    }


    public static boolean startsWithWords(String words) {
        TireNode root = tree;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (root.next[c - 'a'] == null) {
                return false;
            }
            root = root.next[c - 'a'];
        }
        return true;
    }
}
