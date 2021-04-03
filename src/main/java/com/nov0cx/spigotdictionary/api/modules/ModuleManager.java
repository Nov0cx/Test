package com.nov0cx.spigotdictionary.api.modules;

import org.bukkit.Bukkit;

import java.util.ArrayList;

public class ModuleManager {

    private final ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager register(Module.ModuleType type) {
        try {
            Class<?> c = Class.forName(type.getPath());

            Object o = null;
            if(Bukkit.getServicesManager().isProvidedFor(c)) {
                o = Bukkit.getServicesManager().load(c);
            }

            modules.add((Module) o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ModuleManager register(Module.ModuleType... types) {
        for (Module.ModuleType type : types) {
            register(type);
        }

        return this;
    }

    public void load() {
        modules.parallelStream().forEach(Module::load);
    }
}
