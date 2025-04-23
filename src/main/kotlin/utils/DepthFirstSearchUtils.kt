package utils

import problems.leetcode.das.trees.TreeNode

/**
 * Traverse the content of the tree using 'pre-order' criteria
 *
 * @param node The node considered root
 * @param results The container where the value of the node will be added.
 */
fun dfsPreOrderTraverse(node: TreeNode?, results: ArrayList<Int>) {
    if (node == null) {
        return
    }

    // Do something with the value
    println("Value: ${node.`val`}")
    results.add(node.`val`)

    // Traverse left side
    dfsPreOrderTraverse(node.left, results)

    // Traverse right side
    dfsPreOrderTraverse(node.right, results)
}

/**
 * Traverse the Tree recursively using 'post-order' criteria.
 *
 * @param node The current node from which the tree will be evaluated.
 * @param results The list where the results will be stored.
 */
fun dfsInOrderTraverse(node: TreeNode?, results: ArrayList<Int>) {
    if (node == null) {
        return
    }

    // Traverse left side
    dfsInOrderTraverse(node.left, results)

    // Do something with the value
    println("Value: ${node.`val`}")
    results.add(node.`val`)

    // Traverse right side
    dfsInOrderTraverse(node.right, results)
}

/**
 * Traverse the Tree recursively using 'post-order' criteria.
 *
 * @param node The current node from which the tree will be evaluated.
 * @param results The list where the results will be stored.
 */
fun dfsPostOrderTraverse(node: TreeNode?, results: ArrayList<Int>) {
    if (node == null) {
        return
    }

    // Traverse left side
    dfsPostOrderTraverse(node.left, results)

    // Traverse right side
    dfsPostOrderTraverse(node.right, results)

    // Do something with the value
    println("Value: ${node.`val`}")
    results.add(node.`val`)
}
