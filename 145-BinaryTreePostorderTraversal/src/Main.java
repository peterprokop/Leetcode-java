import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

interface Executable {
    void execute();
}

class AddValueExecutable implements Executable {

    int value;
    List<Integer> traversalList;

    AddValueExecutable(int value, List<Integer> traversalList) {
        this.value = value;
        this.traversalList = traversalList;
    }

    public void execute() {
        traversalList.add(value);
    }
}

class TraverseExecutable implements Executable {

    List<Executable> executables;
    TreeNode root;
    List<Integer> traversalList;

    TraverseExecutable(List<Executable> executables, TreeNode root, List<Integer> traversalList) {
        this.executables = executables;
        this.root = root;
        this.traversalList = traversalList;
    }

    public void execute() {
        if ( root == null) { return; }

        TraverseExecutable left = new TraverseExecutable(executables, root.left, traversalList);
        TraverseExecutable right = new TraverseExecutable(executables, root.right, traversalList);

        executables.add(0, left);
        executables.add(1, right);

        AddValueExecutable add = new AddValueExecutable(root.val, traversalList);
        executables.add(2, add);
    }
}

public class Main {
    public static List<Integer> list = new ArrayList<Integer>();

    // Non-recursive implementation
    public static void traversalHelperIterative(TreeNode root) {
        List<Executable> executables = new ArrayList<Executable>();

        TraverseExecutable rootExecutable = new TraverseExecutable(executables, root, list);
        executables.add(rootExecutable);

        while ( executables.size() != 0 ) {
            Executable ex = executables.remove(0);
            ex.execute();
        }
    }

    // Recursive implementation
    public static void traversalHelperRecursive(TreeNode root) {
        if ( root == null) { return; }

        traversalHelperRecursive(root.left);
        traversalHelperRecursive(root.right);

        list.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        //traversalHelperRecursive(root);
        traversalHelperIterative(root);

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        List<Integer> traversed = postorderTraversal(node);
        System.out.println("traversed: " + traversed);
    }
}
