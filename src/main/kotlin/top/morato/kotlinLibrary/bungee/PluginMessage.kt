package top.morato.kotlinLibrary.bungee

import com.google.common.io.ByteStreams
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

/**
 * 插件消息发送工具类
 *
 * @author bilirumble
 */
object PluginMessage {
    /**
     * 发送插件消息
     *
     * @param channel 消息通道
     * @param data 消息内容
     * @param plugin 插件
     * @author bilirumble
     */
    @Deprecated("没啥用, 建议自己实现")
    fun sendPluginMessage(player: Player?, channel: String, plugin: JavaPlugin, data: ByteArray) {
        val out = ByteStreams.newDataOutput()
        out.write(data)

        if (player == null) {
            Bukkit.getServer().sendPluginMessage(plugin, channel, out.toByteArray())
            return
        }

        player.sendPluginMessage(plugin, channel, out.toByteArray())
    }
}