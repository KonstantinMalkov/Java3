package DZ;

import java.util.ArrayList;

public class MainDZ {

    public static void main(String[] args) {

        NewTree tree0 = new NewTree(0, new ArrayList<NewTree>());
        NewTree tree1 = new NewTree(1, new ArrayList<NewTree>());
        NewTree tree2 = new NewTree(2, new ArrayList<NewTree>());
        NewTree tree3 = new NewTree(3, new ArrayList<NewTree>());
        NewTree tree4 = new NewTree(4, new ArrayList<NewTree>());
        NewTree tree5 = new NewTree(5, new ArrayList<NewTree>());
        NewTree tree6 = new NewTree(6, new ArrayList<NewTree>());

        tree0.child.add(tree1);
        tree0.child.add(tree2);
        tree1.child.add(tree3);
        tree3.child.add(tree4);
        tree4.child.add(tree5);
        tree0.child.add(tree6);

        tree0.sortTree(tree0.child);
    }
}

class NewTree{
    int value;
    ArrayList<NewTree> child;

    public NewTree(int value, ArrayList<NewTree> child) {
        this.value = value;
        this.child = child;
    }

    // перебор элементов
    void sortTree(ArrayList<NewTree> ch){
        for (int i = 0; i < ch.size(); i++) {
            ch.get(i).sortTree(ch.get(i).child);
        }
        System.out.println(value);
    }
}