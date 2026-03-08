package org.hustlehard.sethome.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hustlehard.sethome.storage.StorageInterface;
import org.jetbrains.annotations.NotNull;

public class SetHomeCommand implements CommandExecutor {

    private final StorageInterface storage;

    public SetHomeCommand(StorageInterface storage) {
        this.storage = storage;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender commandSender,
            @NotNull Command command,
            @NotNull String s,
            @NotNull String @NotNull [] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Команда только для игроков.");
        }

        if (args.length != 1) {
            commandSender.sendMessage("Использование: /home <homeName>");
            return true;
        }

        Player player = (Player) commandSender;
        String homeName = args[0];

        storage.putHomeIfAbsent(
                player.getName(),
                homeName,
                player.getLocation()
        );

        player.sendMessage("Дом успешно установлен.");
        return true;
    }
}
