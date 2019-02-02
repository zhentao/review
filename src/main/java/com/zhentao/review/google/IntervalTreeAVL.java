package com.zhentao.review.google;

public class IntervalTreeAVL<T extends Comparable<T>> {
    private static class TreeNode<T> {
        private final T low;
        private final T high;
        private TreeNode<T> left;
        private TreeNode<T> right;
        private T max;
        private int height;

        private TreeNode(final T l, final T h) {
            this.low = l;
            this.high = h;
            this.max = high;
            this.height = 1;
        }
    }

    private TreeNode<T> root;

    public void insert(final T l, final T h) {
        root = insert(root, l, h);
    }

    private TreeNode<T> insert(final TreeNode<T> node, final T l, final T h) {
        if (node == null) {
            return new TreeNode<T>(l, h);
        } else {
            final int k =  node.low.compareTo(l);
            if (k > 0) {
                node.left = insert(node.left, l, h);
            } else {
                node.right = insert(node.right, l, h);
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            node.max = findMax(node);
            final int hd = heightDiff(node);
            if (hd < -1) {
                final int kk = heightDiff(node.right);
                if (kk > 0) {
                    node.right = rightRotate(node.right);
                    return leftRotate(node);
                } else {
                    return leftRotate(node);
                }
            } else if (hd > 1) {
                if (heightDiff(node.left) < 0) {
                    node.left = leftRotate(node.left);
                    return rightRotate(node);
                } else {
                    return rightRotate(node);
                }
            } else
                ;
        }
        return node;
    }

    private TreeNode<T> leftRotate(final TreeNode<T> n) {
        final TreeNode<T> r = n.right;
        n.right = r.left;
        r.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        n.max = findMax(n);
        r.max = findMax(r);
        return r;
    }

    private TreeNode<T> rightRotate(final TreeNode<T> n) {
        final TreeNode<T> r = n.left;
        n.left = r.right;
        r.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        n.max = findMax(n);
        r.max = findMax(r);
        return r;
    }

    private int heightDiff(final TreeNode<T> a) {
        if (a == null) {
            return 0;
        }
        return height(a.left) - height(a.right);
    }

    private int height(final TreeNode<T> a) {
        if (a == null) {
            return 0;
        }
        return a.height;
    }

    private T findMax(final TreeNode<T> n) {
        if (n.left == null && n.right == null) {
            return n.max;
        }
        if (n.left == null) {
            if ( n.right.max.compareTo(n.max) > 0) {
                return n.right.max;
            } else {
                return n.max;
            }
        }
        if (n.right == null) {
            if (n.left.max.compareTo(n.max) > 0) {
                return n.left.max;
            } else {
                return n.max;
            }
        }
        final T c1 = n.left.max;
        final T c2 = n.right.max;
        final T c3 = n.max;
        T max = null;
        if (c1.compareTo(c2) < 0) {
            max = n.right.max;
        } else {
            max = n.left.max;
        }
        if (c3.compareTo(max) > 0) {
            max = n.max;
        }
        return max;
    }

    TreeNode<T> intervalSearch(final T t1) {
        TreeNode<T> t = root;
        while (t != null && !isInside(t, t1)) {
            if (t.left != null) {
                if (t.left.max.compareTo(t1) > 0) {
                    t = t.left;
                } else {
                    t = t.right;
                }
            } else {
                t = t.right;
            }
        }
        return t;
    }

    private boolean isInside(final TreeNode<T> node, final T t) {
        final T cLow = node.low;
        final T cHigh = node.high;
        final int i = cLow.compareTo(t);
        final int j = cHigh.compareTo(t);
        if (i <= 0 && j >= 0) {
            return true;
        }
        return false;
    }
}
