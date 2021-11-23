package dev.siro256.spigotpl.confinechickens

import org.bukkit.ChatColor
import org.bukkit.entity.EntityType
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scoreboard.Team

class ConfineChickens: JavaPlugin() {
    init {
        instance = this
    }
    override fun onEnable() {
        nonCollisionTeam = if (server.scoreboardManager!!.mainScoreboard.getTeam("nonCollisionTeam") != null) {
            server.scoreboardManager!!.mainScoreboard.getTeam("nonCollisionTeam")!!
        } else {
            server.scoreboardManager!!.mainScoreboard.registerNewTeam("nonCollisionTeam").apply {
                setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER)
            }
        }

        server.pluginManager.registerEvents(ChickenCollisionListener, this)

        //Load spawn-chunk entities
        server.worlds.forEach { world ->
            world.entities.forEach forEachEntity@{
                if (it.type != EntityType.CHICKEN) return@forEachEntity
                nonCollisionTeam.addEntry(it.uniqueId.toString())
            }
        }

        server.consoleSender.sendMessage("[ConfineChickens] ${ChatColor.GREEN}ConfineChickens enabled.")
    }

    override fun onDisable() {
        server.consoleSender.sendMessage("[ConfineChickens] ${ChatColor.RED}ConfineChickens disabled.")
    }

    companion object {
        lateinit var instance: ConfineChickens
        lateinit var nonCollisionTeam: Team
    }
}
