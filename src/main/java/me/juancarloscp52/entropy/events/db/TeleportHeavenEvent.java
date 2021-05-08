package me.juancarloscp52.entropy.events.db;

import me.juancarloscp52.entropy.Entropy;
import me.juancarloscp52.entropy.events.AbstractInstantEvent;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;

public class TeleportHeavenEvent extends AbstractInstantEvent {

    @Override
    public void init() {
        PlayerLookup.all(Entropy.getInstance().eventHandler.server).forEach(serverPlayerEntity -> {
            serverPlayerEntity.stopRiding();
            serverPlayerEntity.teleport(serverPlayerEntity.getX(), 260, serverPlayerEntity.getZ());
        });
    }
}
