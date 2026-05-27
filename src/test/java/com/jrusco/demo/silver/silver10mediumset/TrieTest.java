package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 * 
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * == My Notes ==
 * - Trie problems require a custom TrieNode DS — not a standard Java collection.
 *   The node doesn't store the character directly; instead, the character is
 *   encoded as a position in a children[26] array (index = char - 'a').
 *   The node you're "at" implicitly represents the character used to reach it.
 * - Two booleans to distinguish: path exists (children[index] != null) vs word
 *   ends here (isEnd = true). search() needs both; startsWith() only needs the first.
 * - All three operations share the same traversal skeleton — only the termination
 *   condition differs. When you see insert/search/prefix on a Trie, write one
 *   traversal and vary the ending.
 */
public class TrieTest {
    
    @Test
    public void test(){

        /**
         * Example 1:
         * 
         * Input
         * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
         * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
         * Output
         * [null, null, true, false, true, null, true]
         * 
         * Explanation
         * Trie trie = new Trie();
         * trie.insert("apple");
         * trie.search("apple"); // return True
         * trie.search("app"); // return False
         * trie.startsWith("app"); // return True
         * trie.insert("app");
         * trie.search("app"); // return True
         * 
         */
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            char[] wordChars = word.toCharArray();
            TrieNode current = root;

            for (char c : wordChars) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            
            current.isEnd = true;
        }

        public boolean search(String word) {
            char[] wordChars = word.toCharArray();
            TrieNode current = root;

            for (int i = 0; i < wordChars.length; i++) {
                int index = wordChars[i] - 'a';
                if (current.children[index] == null){
                    return false;
                }
                current = current.children[index];
            }
            return current.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] wordChars = prefix.toCharArray();
            TrieNode current = root;

            for (int i = 0; i < wordChars.length; i++) {
                int index = wordChars[i] - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    
}
