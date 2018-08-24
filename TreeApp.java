public class TreeApp {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(1);
//        tree.insert(2);
        tree.insert(2);
//        tree.inOrder(tree.getRoot());
        tree.delete(1);

        System.out.println("minimum is " + tree.minimum().getData());
        System.out.println("maximum is " + tree.maximum().getData());

    }
}
