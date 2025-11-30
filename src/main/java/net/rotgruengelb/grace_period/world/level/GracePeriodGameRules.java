package net.rotgruengelb.grace_period.world.level;

import net.minecraft.world.level.GameRules;
import net.rotgruengelb.grace_period.GracePeriod;

import static net.minecraft.world.level.GameRules.Category.PLAYER;

public class GracePeriodGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> MAY_FORGFEIT_GRACE_PERIOD_GAMERULE_KEY = GracePeriod.xplat().registerBooleanGameRule("grace_period:mayForfeitGracePeriod", PLAYER, false);
	public static final GameRules.Key<GameRules.IntegerValue> STARTING_GRACE_PERIOD_TICKS_GAMERULE_KEY = GracePeriod.xplat().registerIntegerGameRule("grace_period:startingGracePeriodTicks", PLAYER, 0);
}
