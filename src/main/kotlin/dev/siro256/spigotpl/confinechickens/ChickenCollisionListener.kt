package dev.siro256.spigotpl.confinechickens

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.event.world.ChunkLoadEvent
import org.bukkit.event.world.WorldLoadEvent

object ChickenCollisionListener: Listener {
    @EventHandler
    fun onEntitySpawn(event: EntitySpawnEvent) {
        if (event.entity.type != EntityType.CHICKEN) return
        ConfineChickens.nonCollisionTeam.addEntry(event.entity.uniqueId.toString())
    }

    @EventHandler
    fun onLoadChunk(event: ChunkLoadEvent) {
        event.chunk.entities.forEach {
            if (it.type != EntityType.CHICKEN) return
            ConfineChickens.nonCollisionTeam.addEntry(it.uniqueId.toString())
        }
    }

    @EventHandler
    fun onLoadWorld(event: WorldLoadEvent) {
        event.world.entities.forEach {
            if (it.type != EntityType.CHICKEN) return@forEach
            ConfineChickens.nonCollisionTeam.addEntry(it.uniqueId.toString())
        }
    }

    @EventHandler
    fun onDeathEntity(event: EntityDeathEvent) {
        if (event.entity.type != EntityType.CHICKEN) return
        ConfineChickens.nonCollisionTeam.removeEntry(event.entity.uniqueId.toString())
    }
}
