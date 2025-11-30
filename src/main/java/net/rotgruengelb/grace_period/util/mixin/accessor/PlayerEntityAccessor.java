package net.rotgruengelb.grace_period.util.mixin.accessor;

public interface PlayerEntityAccessor {
	int grace_period$getGracePeriodRemainingTicks();

	void grace_period$setGracePeriodRemainingTicks(int gracePeriodRemainingTime);
}
