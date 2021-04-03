package com.nov0cx.spigotdictionary.api.modules;

import lombok.Getter;

public abstract class Module {
    protected boolean loaded = false;
    protected boolean loading = false;
    final protected ModuleType type;

    public Module(final ModuleType type) {
        this.type = type;
    }

    public abstract void load();
    public abstract void unload();

    public boolean isLoaded() {
        return loaded;
    }

    public boolean isLoading() {
        return loading;
    }

    public ModuleType getType() {
        return type;
    }

    public enum ModuleType {
        NICK_SYSTEM("com.nov0cx.spigotdictionary.nicksystem.NickModule", "NickModule");

        @Getter
        private final String path;
        @Getter
        private final String name;

        ModuleType(String path, String name) {
            this.path = path;
            this.name = name;
        }
    }

}
