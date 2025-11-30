package net.rotgruengelb.grace_period.platform.neoforge;

//? neoforge {
/*
import net.minecraft.world.level.GameRules;
import net.neoforged.fml.ModList;
import net.rotgruengelb.grace_period.GracePeriod;
import net.rotgruengelb.grace_period.platform.Platform;

public class NeoforgePlatform implements Platform {

	@Override
	public boolean isModLoaded(String modId) {
		return ModList.get().isLoaded(modId);
	}

	@Override
	public ModLoader loader() {
		return ModLoader.NEOFORGE;
	}

	@Override
	public GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String key, GameRules.Category category, boolean defaultValue) {
		return GameRules.register(key, category, GameRules.BooleanValue.create(defaultValue));
	}

	@Override
	public GameRules.Key<GameRules.IntegerValue> registerIntegerGameRule(String key, GameRules.Category category, int defaultValue) {
		return GameRules.register(key, category, GameRules.IntegerValue.create(defaultValue));
	}
}
*///?}
