package top.morato.kotlinLibrary.configures

import org.bukkit.plugin.java.JavaPlugin
import top.morato.kotlinLibrary.utils.PlayerUtils.coloredMessage

/**
 * 消息i18n简易实现
 *
 * 用法:
 * ```kotlin
 *  class ExampleMessage : Message() {
 *     override var fileName: String
 *         get() = "message_cn.yml"
 *         set(value) {}
 * }
 * ```
 *
 * 然后将inti替换为initMessage, reload替换为reloadMessage, 通过get("节点")获取内容
 * 示例:
 * ```kotlin
 * ...
 * val message = ExampleMessage()
 * // 初始化, = init
 * message.initMessage(this, "message_cn.yml")
 * System.out.println(message.get("example"))
 * // 重载, = reload
 * message.reloadMessage("message_en.yml")
 * System.out.println(message.get("example"))
 * ```
 *
 */
open class Message : Configures() {
    override var fileName: String
        get() = "messages.yml"
        set(value) {}

    /**
     * 初始化
     *
     * @param plugin 插件主类
     * @param file 语言文件名
     * @author bilirumble
     */
    open fun initMessage(plugin: JavaPlugin, file: String) {
        this.fileName = file
        this.init(plugin)
    }

    /**
     * 重载消息
     *
     * @param file 语言文件名
     * @author bilirumble
     */
    open fun reloadMessage(file: String) {
        this.fileName = file
        super.reload()
    }

    /**
     * 获取消息
     *
     * @param key 消息键
     * @author bilirumble
     */
    open fun get(key: String): String {
        if (this.getConfiguration().getString(key) == null)
            throw NullPointerException("Message node '$key' not found!")
        return coloredMessage(this.getConfiguration().getString(key)!!)
    }
}