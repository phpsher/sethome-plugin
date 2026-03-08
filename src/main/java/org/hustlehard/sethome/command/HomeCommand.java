package org.hustlehard.sethome.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hustlehard.sethome.exception.HomeNotFoundException;
import org.hustlehard.sethome.storage.StorageInterface;
import org.jetbrains.annotations.NotNull;

public class HomeCommand implements CommandExecutor {

    private final StorageInterface storage;

    public HomeCommand(StorageInterface storage) {
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

        if (args.length != 1) {
            commandSender.sendMessage("Использование: /home <homeName>");
            return true;
        }

        Player player = (Player) commandSender;
        String homeName = args[0];

        try {
            Location location = storage.getHomeLocationIfExists(
                    player.getName(),
                    homeName
                    );

            player.teleport(location);

            return true;
        } catch (HomeNotFoundException exception) {
            player.sendMessage(exception.getMessage());
            return true;
        }
    }
}
