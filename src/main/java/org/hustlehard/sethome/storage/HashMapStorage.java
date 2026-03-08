package org.hustlehard.sethome.storage;

import org.bukkit.Location;
import org.hustlehard.sethome.exception.HomeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage implements StorageInterface {
    private final Map<String, Map<String, Location>> homes = new HashMap<>();

    public boolean putHomeIfAbsent(
            String playerName,
            String homeName,
            Location location
    ) {
        homes.putIfAbsent(playerName, new HashMap<>());
        homes.get(playerName).put(homeName, location);

        return true;
    }

    public Location getHomeLocationIfExists(
            String playerName,
            String homeName
    ) {

        Map<String, Location> playerHomes = homes.get(playerName);

        if (playerHomes == null || !playerHomes.containsKey(homeName)) {
            throw new HomeNotFoundException("Дом не найден.");
        }

        return playerHomes.get(homeName);
    }

    public Map<String, Location> getAllHomes(
            String playerName
    ) {
        return homes.getOrDefault(playerName, Map.of());
    }
}
