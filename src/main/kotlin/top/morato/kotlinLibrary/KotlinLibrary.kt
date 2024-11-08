package top.morato.kotlinLibrary

import org.bukkit.plugin.java.JavaPlugin

/**
 * @author bilirumble
 * */
class KotlinLibrary : JavaPlugin() {
    override fun onEnable() {
        logger.info("KotlinLibrary v${this.description.version} enabled!")
    }

    override fun onDisable() {
        logger.info("KotlinLibrary v${this.description.version} disabled!")
    }
}
