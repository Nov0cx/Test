package com.nov0cx.spigotdictionary.api;

import com.nov0cx.spigotdictionary.api.data.PlayerDataManger;
import com.nov0cx.spigotdictionary.api.executors.ExecutorManager;
import com.nov0cx.spigotdictionary.api.modules.ModuleManager;
import org.bukkit.Bukkit;

public interface SpigotDictionaryAPI {
    static SpigotDictionaryAPI get() {

        if(Bukkit.getPluginManager().getPlugin("SpigotDictionary") == null) {
            throw new IllegalStateException("The plugin \"SpigotDictionary\" isn't loaded.");
        }

        return (SpigotDictionaryAPI) Bukkit.getPluginManager().getPlugin("SpigotDictionary");
    }

    ExecutorManager getExecutors();

    ModuleManager getModuleManger();

    PlayerDataManger getPlayerDataManager();
}
