package net.rotgruengelb.grace_period.platform.neoforge;

//? neoforge {
/*
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.rotgruengelb.grace_period.event.GracePeriodEventHandler;

@EventBusSubscriber
public class NeoforgeEventSubscriber {

	@SubscribeEvent
	public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			GracePeriodEventHandler.playerJoins(player);
		}
	}

	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Post event) {
		GracePeriodEventHandler.serverTick(event.getServer());
	}

	@SubscribeEvent
	public static void onDamageIncoming(LivingIncomingDamageEvent event) {
		event.setCanceled(!GracePeriodEventHandler.allowLivingEntityDamage(event.getEntity(), event.getEntity().getLastDamageSource()));
	}
}
*///?}
