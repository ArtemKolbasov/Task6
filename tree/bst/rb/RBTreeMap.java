package com.company.tree.bst.rb;

import com.company.tree.bst.DefaultBSTreeMap;
import com.company.tree.bst.DefaultBSTree;

/**
 * Реализация словаря на базе красно-черных деревьев
 *
 * @param <K>
 * @param <V>
 */
public class RBTreeMap<K extends Comparable<K>, V> implements DefaultBSTreeMap<K, V> {

    private final DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> tree = (DefaultBSTree<MapTreeEntry<K, V>>) new RBTree();

    @Override
    public DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
