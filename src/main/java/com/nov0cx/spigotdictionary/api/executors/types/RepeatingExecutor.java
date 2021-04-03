package com.nov0cx.spigotdictionary.api.executors.types;

import com.nov0cx.spigotdictionary.api.executors.SpigotDictionaryExecutor;

import java.util.concurrent.TimeUnit;

public interface RepeatingExecutor extends SpigotDictionaryExecutor {
    void exe(Runnable runnable, long delay, long repeat, TimeUnit time);
}
