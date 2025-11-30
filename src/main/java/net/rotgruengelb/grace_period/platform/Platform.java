package net.rotgruengelb.grace_period.platform;

import net.minecraft.world.level.GameRules;

public interface Platform {
	boolean isModLoaded(String modId);

	ModLoader loader();

	GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String key, GameRules.Category category, boolean defaultValue);

	GameRules.Key<GameRules.IntegerValue> registerIntegerGameRule(String key, GameRules.Category category, int defaultValue);

	enum ModLoader {
		FABRIC, NEOFORGE, FORGE, QUILT
	}
}
