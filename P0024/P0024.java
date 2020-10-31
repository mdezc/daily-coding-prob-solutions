package P0024;

import static utils.Utils.printResult;

public class P0024 {

    /*
     * Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.
     *
     * Design a binary tree node class with the following methods:
     *
     *  - is_locked, which returns whether the node is locked
     *  - lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
     *  - unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
     *
     */

    public static void main(String[] args) {

        BinaryNode right = new BinaryNode();
        BinaryNode left = new BinaryNode();
        BinaryNode root = new BinaryNode();
        root.leftChild(left);
        root.rightChild(right);

        // solution for root
        printResult(true,root.lock());
        printResult(true,root.unlock());

        // allows locking left just once and not lock root
        printResult(true, left.lock());
        printResult(false, left.lock());
        printResult(false, root.lock());

        // allows unlocking left just once and not lock root
        printResult(true, left.unlock());
        printResult(false, left.unlock());
        printResult(true, root.lock());

        // test ancestor not locking due to left locked
        printResult(true, root.unlock());
        printResult(true, left.lock());
        BinaryNode ancestor = new BinaryNode();
        ancestor.leftChild(root);
        printResult(false, ancestor.lock());
        // test ancestor locking
        printResult(true, left.unlock());
        printResult(true, ancestor.lock());
    }

    public static class BinaryNode {

        public BinaryNode parent = null;
        public boolean locked;
        public BinaryNode left;
        public BinaryNode right;

        public BinaryNode() {
            this.locked = false;
        }

        public boolean isLocked() {
            return locked;
        }

        public boolean lock() {
            if (!this.locked && this.unlockedAncestors() && this.unlockedDescendants()) {
                this.toggleLock();
                return true;
            }
            return false;
        }

        public boolean unlock() {
            if (this.locked && this.unlockedAncestors() && this.unlockedDescendants()) {
                this.toggleLock();
                return true;
            }
            return false;
        }

        private void toggleLock() {
            this.locked = !locked;
        }

        public void leftChild(BinaryNode node) {
            node.parent = this;
            this.left = node;
        }

        public void rightChild(BinaryNode node) {
            node.parent = this;
            this.right = node;
        }

        public boolean unlockedDescendants() {
            return (this.left == null || (!this.left.locked && this.left.unlockedDescendants()))
                && (this.right == null || (!this.right.locked && this.right.unlockedDescendants()));
        }

        public boolean unlockedAncestors() {
            if (this.parent == null || !this.parent.locked) {
                return true;
            } else {
                return this.parent.unlockedAncestors();
            }
        }
    }
}
