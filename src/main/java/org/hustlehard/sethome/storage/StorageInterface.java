package org.hustlehard.sethome.storage;

import org.bukkit.Location;

import java.util.Map;

public interface StorageInterface {
    boolean putHomeIfAbsent(
            String playerName,
            String homeName,
            Location location
    );

    Location getHomeLocationIfExists(
            String playerName,
            String homeName
    );

    Map<String, Location> getAllHomes(
            String playerName
    );

}
