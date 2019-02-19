package DataStructure.Tree;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-20 21:00
 **/
public class Tree {
    Tree left;
    Tree right;
    int value;

    public Tree(int value) {
        this.value = value;
    }
    public Tree() {
    }

    public static void print(Tree head){
         print( head,0);
        }
    public static void print(Tree head,int hight){
        if (head==null){
            return;
        }
        hight++;
        int val = head.value;
        String space = getSpace(hight);
        String intSpace = getStrSpace(val);
        print(head.right,hight);
        String s = " ";

        System.out.println(space+intSpace+val+intSpace+"<");
        print(head.left,hight);
    }

    private static String getStrSpace(int len) {
        String l0 = String.valueOf(len);
        int l = l0.length();
        l = l >> 1;
        l = 5-l;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }


    private static String getSpace(int h) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < h; i++) {
            sb.append("           ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Tree tree = new Tree(22);
        Tree tree0 = new Tree(1);
        Tree tree1 = new Tree(2222);
        Tree tree2 = new Tree(3);
        Tree tree3 = new Tree(12345678);
        Tree tree4 = new Tree(0111);
        Tree tree5 = new Tree(1234567890);

        tree.left = tree0;
        tree.right=tree1;
        tree0.left = tree2;
        tree0.right = tree3;
        tree1.left = tree4;
        tree1.right = tree5;
        Tree.print(tree);
    }
}
