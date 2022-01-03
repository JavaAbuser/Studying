package OwnTreeRealization;

public class Tree {
    private Node root;

    public void insert(int value, String data) {
        Node node = new Node();
        node.setKey(value);
        node.setData(data);

        if (root == null) {
            root = node;
        } else {
            Node currentNode = root;
            Node previousNode = null;
            while (true) {
                previousNode = currentNode;
                if (value < previousNode.getKey()) {
                    currentNode = currentNode.getLeftChild();
                    if(currentNode == null){
                        previousNode.setLeftChild(node);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if(currentNode == null){
                        previousNode.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }
    public Node find(int key){
        Node currentNode = root;
        while(currentNode.getKey() != key) {
            if (key < currentNode.getKey()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if(currentNode == null){
                System.out.println("Node was not find");
                return null;
            }
        }
        return currentNode;
    }
}
