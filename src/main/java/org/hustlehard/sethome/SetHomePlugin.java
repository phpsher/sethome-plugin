package org.hustlehard.sethome;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.hustlehard.sethome.command.HomeCommand;
import org.hustlehard.sethome.command.HomesCommand;
import org.hustlehard.sethome.command.SetHomeCommand;
import org.hustlehard.sethome.storage.HashMapStorage;
import org.hustlehard.sethome.storage.StorageInterface;


public final class SetHomePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Плагин SetHome запущен");

        Bukkit.getPluginManager().registerEvents(this, this);

        StorageInterface storage = new HashMapStorage();

        this
                .getCommand("home")
                .setExecutor(new HomeCommand(storage));

        this
                .getCommand("sethome")
                .setExecutor(new SetHomeCommand(storage));

        this
                .getCommand("homes")
                .setExecutor(new HomesCommand(storage));
    }

    @Override
    public void onDisable() {
        getLogger().info("Плагин SetHome выключен");
    }
}
