package com.nov0cx.spigotdictionary.api.executors.types;

import com.nov0cx.spigotdictionary.api.executors.SpigotDictionaryExecutor;

public interface NormalExecutor extends SpigotDictionaryExecutor {
    void exe(Runnable runnable);
}
