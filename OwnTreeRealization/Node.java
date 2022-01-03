package OwnTreeRealization;

public class Node {
    private int key;
    private String data;
    private Node leftChild;
    private Node rightChild;

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void printNode(){
        System.out.println("Node with key " + key + ", data = " + data);
    }
}
