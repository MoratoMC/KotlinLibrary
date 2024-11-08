package top.morato.kotlinLibrary.configures

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.*
import java.nio.charset.StandardCharsets

/**
 * 配置文件类, 实现后用init传一个主类就行.
 *
 * 示例:
 * ```kotlin
 * class ExampleConfigures : Configures() {
 *     // 文件名
 *     override var fileName: String
 *         get() = "test.yml"
 *         set(value) {}
 *
 *     // 需要获取的内容
 *     var example: String = "example"
 *
 *     // 加载配置文件, 同时为this.example赋值
 *     override fun reload() {
 *         super.reload()
 *
 *         // 可能为null, 使用时注意处理空指针
 *         this.example = this.getConfiguration().getString("example", "example")!!
 *     }
 * }
 * ```
 *
 * @author bilirumble
 */
open class Configures {
    var plugin: JavaPlugin? = null
    private var configuration: FileConfiguration? = null

    /**
     * 配置文件的文件名称
     */
    open var fileName: String = "example.yml"

    /**
     * 重载配置文件
     *
     * @author bilirumble
     */
    open fun reload() {
        reloadConfigures()
    }

    /**
     * 真正的重载工具
     *
     * @throws NullPointerException 配置文件不存在时抛出
     * @author bilirumble
     */
    @Throws(NullPointerException::class)
    open fun reloadConfigures() {
        saveConfig()
        val file = File((plugin ?: return).dataFolder, fileName)
        configuration = YamlConfiguration.loadConfiguration(file)

        // 从本体加载默认文件
        val `is`: InputStream? = (plugin ?: return).getResource(fileName)
        if (`is` != null) {
            val defConfigStream: Reader = InputStreamReader(`is`, StandardCharsets.UTF_8)
            val defConfig = YamlConfiguration.loadConfiguration(defConfigStream)
            (configuration ?: return).setDefaults(defConfig)
        } else throw NullPointerException("Config file '$fileName' not found!")
    }

    /**
     * 将包内文件保存到插件目录
     *
     * @throws IOException 打包的插件没有包含源文件时抛出
     * @author bilirumble
     */
    @Throws(IOException::class)
    open fun saveConfig() {
        val file = File((plugin ?: return).dataFolder, fileName)
        if (!file.exists()) {
            try {
                (plugin ?: return).saveResource(fileName, false)
            } catch (e: IOException) {
                throw IOException("Config file '$fileName' not found in Jar file! this jar may be broken!")
            }
        }
    }

    /**
     * 获取配置文件内容
     *
     * 示例:
     * ```kotlin
     * val example = this.getConfiguration().getString("example", "默认内容")!!
     * ```
     *
     * @return FileConfiguration
     */
    fun getConfiguration(): FileConfiguration {
        if (configuration == null) reloadConfigures()
        return configuration!!
    }

    /**
     * 加载配置文件用的
     * 好像没什么用?
     *
     * @author bilirumble
     */
    open fun init(plugin: JavaPlugin) {
        this.plugin = plugin
        reload()
    }
}