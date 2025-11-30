package net.rotgruengelb.grace_period;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameRules;
import net.rotgruengelb.grace_period.platform.Platform;
import net.rotgruengelb.grace_period.util.mixin.accessor.PlayerEntityAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import net.rotgruengelb.grace_period.platform.fabric.FabricPlatform;
//?} neoforge {
/*import net.rotgruengelb.grace_period.platform.neoforge.NeoforgePlatform;
 *///?}

@SuppressWarnings("LoggingSimilarMessage")
public class GracePeriod {

	public static final String MOD_ID = /*$ mod_id*/ "grace_period";
	public static final String MOD_VERSION = /*$ mod_version*/ "0.1.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Grace Period";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, GracePeriod.xplat().loader());
	}

	public static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		 //?} neoforge {
		/*return new NeoforgePlatform();
		*///?}
	}

	public static int playerGetGracePeriodRemainingTicks(ServerPlayer player) {
		return ((PlayerEntityAccessor) player).grace_period$getGracePeriodRemainingTicks();
	}

	public static void playerSetGracePeriodRemainingTicks(ServerPlayer player, int gracePeriodRemainingTicks) {
		((PlayerEntityAccessor) player).grace_period$setGracePeriodRemainingTicks(gracePeriodRemainingTicks);
	}
}
