package tree_example;

import java.util.Iterator;

class Node<T> {
    public T value;
    public Node<T> left, right, parent;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    public  Iterator<Node<T>> preOrder() {
        return new PreOrderIterator<>(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

class PreOrderIterator<T> implements Iterator<Node<T>> {
    private Node<T> current, root;
    private boolean yieldedStart;
    private boolean visitedLeftmostChild = false;
    private Node<T> lastVisitedElem;
    private Node<T> rightMostChild;

    public PreOrderIterator(Node<T> root) {
        current = this.root = root;
        Node<T> temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        rightMostChild = temp;
    }

    @Override
    public boolean hasNext() {
        return current != rightMostChild;
    }

    @Override
    public Node<T> next() {
        if (!yieldedStart) {
            yieldedStart = true;
            lastVisitedElem = current;
            return current;
        }

        //process left tree
        if (current.left != null) {
            current = current.left;
            if (current.left == null) {
                visitedLeftmostChild = true;
            }
            lastVisitedElem = current;
            return current;
        }
        if (visitedLeftmostChild) {
            while (current.right == null || current.right == lastVisitedElem) {
                if (current == root) {
                    visitedLeftmostChild = false;
                    break;
                }

                current = current.parent;
            }
            current = current.right;
            assert current != null;
            lastVisitedElem = current;
            return current;
        }
        return current;
    }
}


class Demo {
    public static void main(String[] args) {
        //   1
        //  / \
        // 2   3
        //4  5 6 7
        Node<Integer> root = new Node<>(1,
                new Node<>(2, new Node<>(4), new Node<>(5)),
                new Node<>(3, new Node<>(6), new Node<>(7)));

        Iterator<Node<Integer>> it = root.preOrder();

        while (it.hasNext()) {
            System.out.print("" + it.next() + ",");
        }
        System.out.println();

    }
}