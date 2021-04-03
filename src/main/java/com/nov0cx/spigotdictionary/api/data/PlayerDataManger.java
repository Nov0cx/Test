package com.nov0cx.spigotdictionary.api.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerDataManger {
    private final ArrayList<APlayerData> playerDataList = new ArrayList<>();

    public APlayerData getPlayerData(Player player) {
        return getPlayerData(player.getUniqueId());
    }

    public APlayerData getPlayerData(UUID uuid) {
        return playerDataList.parallelStream().filter(data -> data.uuid == uuid).findFirst().orElse(null);
    }

    public void addPlayerData(APlayerData data) {
        playerDataList.add(data);
    }
}
