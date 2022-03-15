package OwnTreeRealization;

/**
 * @author Max Steblevskiy(JavaAbuser) on 03.01.22
 * My own tree realization
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(8, "EIGHT");
        tree.insert(5, "FIVE");
        tree.find(5).printNode();
    }
}
