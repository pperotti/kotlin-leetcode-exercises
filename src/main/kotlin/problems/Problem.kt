package problems

/**
 * Represents a coding problem. Each solution must implement this interface. This interface follows the GoF's Command pattern.
 */
interface Problem {

    /**
     * Executes the solution
     */
    fun execute()
}