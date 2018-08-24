public class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }//getRoot

    public Node find(int key){
        Node current = root;
        while(current.getData()!=key){
            if(key > current.getData())
                current = current.getRight();
            if(key < current.getData())
                current = current.getLeft();
            if(current==null)
                return null;
        }//while
        return current;
    }//find

    public void insert(int id){//id-int data
        Node newNode = new Node();
        newNode.setData(id);

        if(root == null)
            root = newNode;
        else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(id < current.getData()){
                    current = current.getLeft();
                    if(current == null){
                        parent.setLeft(newNode);
                        return;
                    }//if
                }//if
                else{
                    current = current.getRight();
                    if(current == null){
                        parent.setRight(newNode);
                        return;
                    }//if
                }//else
            }//while
        }//else
    }//insert

    public boolean delete(int key){
        Node current = root;
        Node parent = current;
        boolean isLeft = false;

        //search
        while(current.getData()!=key){
            parent = current;
            if(key < current.getData()){
                isLeft = true;
                current = current.getLeft();
            }else{
                isLeft = false;
                current = current.getRight();
            }
            if(current==null)return false;
        }//while

        //delete if node is list
        if(current.getLeft()==null && current.getRight()==null){
            if(current==root)
            {
                root = null;
            }//if
            else{
                if(isLeft){
                    parent.setLeft(null);
                }//if
                else{
                    parent.setRight(null);
                }//else
            }//else
        }//if
        else if(current.getRight()==null){
            if(current == root){
                root = current.getLeft();
            }else{
                if(isLeft){
                    parent.setLeft(current.getLeft());
                }else{
                    parent.setRight(current.getLeft());
                }//else
            }//else
        }//else if
        else if(current.getLeft()==null){
            if(current == root){
                root = current.getRight();
            }else{
                if(isLeft){
                    parent.setLeft(current.getRight());
                }else{
                    parent.setRight(current.getRight());
                }//else
            }//else

        }//else if
        else{//Два потомкa. Узел заменяется преемником
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeft){
                parent.setLeft(successor);
            }else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());

        }//else if
        return true;
    }

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode.getRight();
        Node current = delNode.getRight();

        while(current!=null){
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

       if(successor != delNode.getRight()){
           successorParent.setLeft(successor.getRight());
           successor.setRight(delNode.getRight());
       }

        return successor;
    }

    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.getLeft());
            System.out.println(node.getData()+" ");
            inOrder(node.getRight());
        }//if
    }//inOrder

    public Node minimum(){
        Node current = root;
        Node last=current;

        while(current!=null){
            last = current;
            current = current.getLeft();
        }//while
        return last;
    }//minimum

    public Node maximum(){
        Node current = root;
        Node last = current;
        while(current!=null){
            last = current;
            current = current.getRight();
        }//while
        return last;
    }//masximum
}
