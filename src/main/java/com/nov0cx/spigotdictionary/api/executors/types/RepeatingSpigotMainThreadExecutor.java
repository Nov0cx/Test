package com.nov0cx.spigotdictionary.api.executors.types;

import com.nov0cx.spigotdictionary.api.executors.SpigotDictionaryExecutor;

public interface RepeatingSpigotMainThreadExecutor extends SpigotDictionaryExecutor {
    void exe(Runnable runnable, long delay, long repeat);
}
