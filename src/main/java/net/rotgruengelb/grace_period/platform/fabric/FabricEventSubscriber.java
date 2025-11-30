package net.rotgruengelb.grace_period.platform.fabric;

//? fabric {

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.rotgruengelb.grace_period.event.GracePeriodEventHandler;

public class FabricEventSubscriber {

	public static void registerEvents() {
		ServerLivingEntityEvents.ALLOW_DAMAGE.register(((entity, source, amount) -> GracePeriodEventHandler.allowLivingEntityDamage(entity, source)));
		ServerTickEvents.END_SERVER_TICK.register(GracePeriodEventHandler::serverTick);
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> GracePeriodEventHandler.playerJoins(handler.player));
	}
}
//?}
