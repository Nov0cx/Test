package com.nov0cx.spigotdictionary.api.executors.types;

import com.nov0cx.spigotdictionary.api.executors.SpigotDictionaryExecutor;

public interface SpigotMainThreadExecutor extends SpigotDictionaryExecutor {
    void exe(Runnable runnable);
}
