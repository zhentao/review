package com.zhentao.review.google.high;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树，要求删一些node，返回list of roots 高频 5次 More Detail :
 * 给一个tree有红的node有蓝的node，把红的去掉后剩下一堆零零散散的tree，
 * 返回这些tree的node，只要node，不要children，也就是说把这个node的children设置成null然后加到list里。
 * 参数是这个树的root。找到所有的红点然后delete掉，去掉这些红点之后就会把一个tree变成散落的几个tree，然后返回这几个tree的root。直接一个recursive判断一下，如果这个node是红点的话就ignore
 * 掉再去判断这个node的children，如果这个node是蓝点的话，要看这个蓝点的parent是不是个红点，是的话，这个蓝点就是散落的tree中其中一个tree的root。
 * 
 * @author zhentao
 *
 */
public class DeleteRedNode {
    
    public List<NaryTreeNode> delete(final NaryTreeNode root) {
        final List<NaryTreeNode> list = new ArrayList<>();
        if (root != null) {
            preOrder(root, null, list);
        }
        return list;
    }
    
    void preOrder(final NaryTreeNode node, final NaryTreeNode parent, final List<NaryTreeNode> list) {
        if ((parent == null || parent.isRed()) && !node.isRed()) {
            list.add(node);
        }
        
        for (final NaryTreeNode child : node.children) {
            preOrder(child, node, list);
        }
        node.children = null;
    }
    
    static class NaryTreeNode {
        String color;
        List<NaryTreeNode> children;
        
        NaryTreeNode(final String color) {
            this.color = color;
            children = new ArrayList<>();
        }
        
        boolean isRed() {
            return "red".equals(color);
        }
        
        @Override
        public String toString() {
            return "color: " + color + " " + children;
        }
    }
}

