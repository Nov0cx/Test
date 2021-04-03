package com.nov0cx.spigotdictionary.api.data;

import com.nov0cx.spigotdictionary.api.utils.FetchUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class APlayerData {

    protected final Player player;
    protected final UUID uuid;

    public APlayerData(Player player) {
        this(player, player.getUniqueId());
    }

    public APlayerData(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if(player == null) {
            player = Bukkit.getOfflinePlayer(uuid).getPlayer();
        }
        this.player = player;
        this.uuid = uuid;
    }

    public APlayerData(Player player, UUID uuid) {
        this.player = player;
        this.uuid = uuid;
    }

    public APlayerData(OfflinePlayerData offlinePlayerData) {
        this(offlinePlayerData.offlinePlayer.getPlayer(), offlinePlayerData.uuid);
    }

    public static class OfflinePlayerData {

        @Getter
        private final UUID uuid;
        @Getter
        private final OfflinePlayer offlinePlayer;

        OfflinePlayerData(String name) {
            uuid = FetchUtils.UUIDFetcher.getUUID(name);
            offlinePlayer = Bukkit.getOfflinePlayer(uuid);
        }

        OfflinePlayerData(UUID uuid) {
            this.uuid = uuid;
            offlinePlayer = Bukkit.getOfflinePlayer(uuid);
        }
    }

}
