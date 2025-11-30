package net.rotgruengelb.grace_period.event;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.rotgruengelb.grace_period.GracePeriod;
import net.rotgruengelb.grace_period.world.level.GracePeriodGameRules;

import java.util.Objects;

public class GracePeriodEventHandler {

	public static boolean allowLivingEntityDamage(LivingEntity entity, DamageSource source) {
		if (entity instanceof ServerPlayer player) {
			if (source != null && source.getEntity() != null && source.getEntity() instanceof ServerPlayer attacker) {
				return !(GracePeriod.playerGetGracePeriodRemainingTicks(attacker) > 0 ||
				GracePeriod.playerGetGracePeriodRemainingTicks(player) > 0);
			}
		}
		return true;
	}

	public static void serverTick(MinecraftServer server) {
		for (ServerPlayer player : server.getPlayerList().getPlayers()) {
			int ticksLeft = GracePeriod.playerGetGracePeriodRemainingTicks(player);
			if (ticksLeft > 0) {
				GracePeriod.playerSetGracePeriodRemainingTicks(player, ticksLeft - 1);
			}
		}
	}

	public static void playerJoins(ServerPlayer player) {
		int ticksLeft = GracePeriod.playerGetGracePeriodRemainingTicks(player);
		if (ticksLeft <= -1) {
			ticksLeft = Objects.requireNonNull(player.level().getServer()).getGameRules().getRule(GracePeriodGameRules.STARTING_GRACE_PERIOD_TICKS_GAMERULE_KEY).get();
			GracePeriod.playerSetGracePeriodRemainingTicks(player, ticksLeft);
		}
	}
}
