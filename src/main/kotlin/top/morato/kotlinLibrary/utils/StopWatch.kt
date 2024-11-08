package top.morato.kotlinLibrary.utils

/**
 * 计时器
 *
 * 示例:
 * ```kotlin
 * val stopWatch = StopWatch()
 *
 * stopWatch.start()
 * // ...
 * System.out.println(stopWatch.end())
 * ```
 *
 * @author bilirumble
 */
class StopWatch {
    private var startTime: Long = 0L
    private var endTime: Long = 0L
    private var isStart = false

    /**
     * 开始
     */
    fun start() {
        if (isStart) return
        startTime = System.currentTimeMillis()
        isStart = true
    }

    /**
     * 获取经过的时间
     *
     * @return 经过的时间, 单位毫秒
     */
    fun end(): Long {
        if (!isStart) return 0L
        endTime = System.currentTimeMillis()
        isStart = false
        return endTime - startTime
    }
}