package com.brew.home.geekbang.p3tree.trie;

public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data) { this.data = data; }
}
