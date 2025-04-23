package problems.leetcode.das.trees

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import utils.dfsInOrderTraverse
import utils.dfsPostOrderTraverse
import utils.dfsPreOrderTraverse
import kotlin.test.Test

/**
 * Run the test cases associated with DFS
 */
class DepthFirstSearchUtilsTest {

    var root: TreeNode? = null

    @BeforeEach
    fun setup() {

        /*
         * This tree used for DFS
         *
         *            0
         *       1         2
         *    3    4    x     5
         *   x x  x 6        x x
         */
        root = TreeNode(0)
        val t1 = TreeNode(1)
        t1.left = TreeNode(3)
        t1.right = TreeNode(4)
        t1.right?.right = TreeNode(6)
        val t2 = TreeNode(2)
        t2.right = TreeNode(5)
        root?.left = t1
        root?.right = t2
    }

    @Test
    fun testPreOrderScenario1() {

        // Given
        val results = ArrayList<Int>()

        // Test
        dfsPreOrderTraverse(root, results)

        // Then
        val expected = intArrayOf(0,1,3,4,6,2,5)
        println(expected.contentToString())
        Assertions.assertArrayEquals(expected, results.toIntArray())
    }

    @Test
    fun testInOrderScenario1() {

        // Given
        val results = ArrayList<Int>()

        // Test
        dfsInOrderTraverse(root, results)

        // Then
        val expected = intArrayOf(3,1,4,6,0,2,5)
        println(expected.contentToString())
        Assertions.assertArrayEquals(expected, results.toIntArray())
    }

    @Test
    fun testPostOrderScenario1() {

        // Given
        val results = ArrayList<Int>()

        // Test
        dfsPostOrderTraverse(root, results)

        // Then
        val expected = intArrayOf(3,6,4,1,5,2,0)
        println(expected.contentToString())
        Assertions.assertArrayEquals(expected, results.toIntArray())
    }
}