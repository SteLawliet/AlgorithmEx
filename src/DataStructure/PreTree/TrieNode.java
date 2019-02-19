package DataStructure.PreTree;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-07-27 18:38
 **/
public class TrieNode {
    private int pass;
    private int end;
    private TrieNode[] next;

    public TrieNode() {
      this.end=0;
      this.pass=0;
      this.next=new TrieNode[26];
    }

    public  void insert(String s){
        if (s==null||s.trim().equals("")) return;
        char[] chars = s.toCharArray();
        TrieNode node  = this;
        node.pass++;
        for (char char0 : chars) {
            int index = char0 - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.pass++;
        }
        node.end++; 
    }
    public int search(String s){
        if (s==null||s.trim().equals(""))return 0;
        char[] chars = s.toCharArray();
        TrieNode node  = this;
        for (char char0 : chars) {
            int index = char0 - 97;
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }

    public void delete(String s){
        if (search(s)<0) return;
        char[] chars = s.toCharArray();
        TrieNode node  = this;
        for (char char0 : chars) {
            int index = char0 - 'a';
            int nextPass = --node.next[index].pass;
            if (nextPass <= 0) {
                node.next[index] = null;
                return;
            }
            node = node.next[index];
        }
        node.end--;
    }

    public static void main(String[] args) {

        TrieNode node = new TrieNode();
        node.insert("abc");
        node.insert("bcd");
        node.insert("abc");
        node.insert("abc");
//        node.delete("bcd");
        int abc = node.search("abc");
        int bcd = node.search("bcd");

    }



}
