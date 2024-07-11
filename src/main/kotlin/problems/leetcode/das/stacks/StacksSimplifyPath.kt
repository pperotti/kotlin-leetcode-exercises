package problems.leetcode.das.stacks

import problems.Problem

/**
 * Given an absolute path for a Unix-style file system, which begins with a slash '/',
 * transform this path into its simplified canonical path.
 *
 * In Unix-style file system context, a single period '.' signifies the current directory,
 * a double period ".." denotes moving up one directory level, and multiple slashes such
 * as "//" are interpreted as a single slash. In this problem, treat sequences of periods
 * not covered by the previous rules (like "...") as valid names for files or directories.
 *
 * The simplified canonical path should adhere to the following rules:
 *
 * It must start with a single slash '/'.
 * Directories within the path should be separated by only one slash '/'.
 * It should not end with a slash '/', unless it's the root directory.
 * It should exclude any single or double periods used to denote current or parent directories.
 *
 * Return the new path.
 */
class StacksSimplifyPath : Problem {
    override fun execute() {
//        val path = "/home//foo/"
//        val path = "/home/user/Documents/../Pictures"
//        val path = "/../"
//        val path = "/.../a/../b/c/../d/./"
//        val path = "/a//b////c/d//././/.."
        val path ="/."
        println("Path: $path Length: ${path.length}")
        println("Canonical Path: ${simplifyPath(path)}")
    }

    private fun simplifyPath(path: String): String {
        if (path.length >= 3000) {
            throw IllegalArgumentException("Path is too big")
        }

        if (!path.startsWith('/')) {
            throw IllegalArgumentException("Path is not absolute")
        }

        val realPath = ArrayDeque<Char>()
        var last = 1
        path.forEachIndexed { index, c ->
            println("Char: $c")
            if (c == '/' && index > 0) {
                // Process word
                val word = path.substring(last, index)
                println("last: $last index: $index word: $word")
                //Do not add the word to the real path
                if (".." == word) {
                    handleCd(realPath)
                    last = index + 1
                } else if ("." == word) {
                    // Remove "./"
                    realPath.removeLast()
                    last = index + 1
                } else if ("" == word) {
                    last = index + 1
                } else {
                    realPath.add(c)
                    last = index + 1
                }
            } else {
                realPath.add(c)
            }
        }

        val word = path.substring(last)
        println("last piece: $last word: $word")
        if (".." == word) {
            handleCd(realPath)
        } else if ("." == word) {
            realPath.removeLast()
        }

        // Check last char and if it is a '/' let's remove it
        if (realPath.size > 1 && realPath.last() == '/') {
            realPath.removeLast()
        }

        return realPath.joinToString(separator="")
    }

    private fun handleCd(realPath: ArrayDeque<Char>) {
        var slashCount = 0
        do {
            val stackChar = realPath.lastOrNull()
            if (stackChar == '/' || stackChar == null) {
                slashCount++
            }
            if (slashCount < 2 && realPath.size > 1) {
                realPath.removeLast()
            }
        } while (slashCount < 2)
    }
}