package me.danipro2007.betterstreams.Bungee;

import java.util.HashMap;
import java.util.UUID;
import java.util.Map;

public class CooldownManager
{
    private final Map<UUID, Integer> cooldowns;
    public static final int DEFAULT_COOLDOWN = 15;
    
    public CooldownManager() {
        this.cooldowns = new HashMap<UUID, Integer>();
    }
    
    public void setCooldown(final UUID player, final int time) {
        if (time < 1) {
            this.cooldowns.remove(player);
        }
        else {
            this.cooldowns.put(player, time);
        }
    }
    
    public int getCooldown(final UUID player) {
        return this.cooldowns.getOrDefault(player, 0);
    }
}
