package top.morato.kotlinLibrary.utils

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * 玩家工具类
 */
object PlayerUtils {
    /**
     * 将文本中的颜色代码转换为Minecraft颜色代码
     *
     * @param text 文本
     * @return 转换后的文本
     * @author bilirumble
     */
    fun coloredMessage(text: String): String {
        return ChatColor.translateAlternateColorCodes('&', text)
    }

    /**
     * SpigotAPI的sendMessage方法, 会自动转&为颜色代码
     * */
    fun sendMessage(player: Player, type: ChatMessageType, message: String) {
        player.spigot().sendMessage(type, TextComponent(coloredMessage(message)))
    }

    /**
     * 发送消息, 会自动转&为颜色代码
     *
     * @author bilirumble
     */
    fun sendMessage(sender: CommandSender, message: String) {
        sender.sendMessage(coloredMessage(message))
    }

    /**
     * 发送标题, 会自动转&为颜色代码
     *
     * @author bilirumble
     */
    fun sendTitle(
        sender: CommandSender, title: String, subtitle: String = "",
        fadeIn: Int = 20, stay: Int = 40, fadeOut: Int = 20
    ) {
        if (sender is Player) sender.sendTitle(coloredMessage(title), coloredMessage(subtitle), fadeIn, stay, fadeOut)
    }
}