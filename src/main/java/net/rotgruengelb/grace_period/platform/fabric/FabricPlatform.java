package net.rotgruengelb.grace_period.platform.fabric;

//? fabric {

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;
import net.rotgruengelb.grace_period.platform.Platform;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatform implements Platform {

	@Override
	public boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	@Override
	public ModLoader loader() {
		return ModLoader.FABRIC;
	}

	@Override
	public GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String key, GameRules.Category category, boolean defaultValue) {
		return GameRuleRegistry.register(key, category, GameRuleFactory.createBooleanRule(defaultValue));
	}

	@Override
	public GameRules.Key<GameRules.IntegerValue> registerIntegerGameRule(String key, GameRules.Category category, int defaultValue) {
		return GameRuleRegistry.register(key, category, GameRuleFactory.createIntRule(defaultValue));
	}
}
//?}
