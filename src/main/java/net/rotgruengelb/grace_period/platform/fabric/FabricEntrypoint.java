package net.rotgruengelb.grace_period.platform.fabric;

//? fabric {

import net.rotgruengelb.grace_period.GracePeriod;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		GracePeriod.onInitialize();
		FabricEventSubscriber.registerEvents();
	}
}
//?}
