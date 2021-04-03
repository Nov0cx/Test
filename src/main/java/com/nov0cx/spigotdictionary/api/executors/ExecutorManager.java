package com.nov0cx.spigotdictionary.api.executors;

import com.nov0cx.spigotdictionary.api.executors.types.*;

public interface ExecutorManager {
    LaterExecutor getLaterExecutor();
    LaterSpigotMainThreadExecutor getLaterSpigotMainThreadExecutor();
    NewThreadExecutor getNewThreadExecutor();
    RepeatingExecutor getRepeatingExecutor();
    RepeatingSpigotMainThreadExecutor getRepeatingSpigotMainThreadExecutor();
    SpigotMainThreadExecutor getSpigotMainThreadExecutor();
    NormalExecutor getExecutor();
}
