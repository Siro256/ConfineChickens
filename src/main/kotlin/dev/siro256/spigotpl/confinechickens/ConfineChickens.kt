package dev.siro256.spigotpl.confinechickens

import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class ConfineChickens: JavaPlugin() {
    override fun onEnable() {
        server.consoleSender.sendMessage("[ConfineChickens] ${ChatColor.GREEN}ConfineChickens enabled.")
    }

    override fun onDisable() {
        server.consoleSender.sendMessage("[ConfineChickens] ${ChatColor.RED}ConfineChickens enabled.")
    }
