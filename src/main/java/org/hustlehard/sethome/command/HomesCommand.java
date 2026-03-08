package org.hustlehard.sethome.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hustlehard.sethome.storage.StorageInterface;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class HomesCommand implements CommandExecutor {

    private final StorageInterface storage;

    public HomesCommand(StorageInterface storage) {
        this.storage = storage;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender commandSender,
            @NotNull Command command,
            @NotNull String s,
            @NotNull String @NotNull [] args
    ) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Команда только для игроков.");
        }

        Player player = (Player) commandSender;

        Map<String, Location> homes = storage.getAllHomes(player.getName());
        String homesList = String.join(", ", homes.keySet());

        player.sendMessage("§aТвои дома: §e" + homesList);

        return false;
    }
}
