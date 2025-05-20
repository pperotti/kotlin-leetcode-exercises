package problems

/**
 * Represents a coding problem. Each solution must implement this interface. This interface follows the GoF's Command pattern.
 */
@Deprecated("New problems should no longer use this interface")
interface Problem {

    /**
     * Executes the solution
     */
    fun execute()
}