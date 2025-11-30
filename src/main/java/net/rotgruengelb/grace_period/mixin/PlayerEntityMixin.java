package net.rotgruengelb.grace_period.mixin;

import net.minecraft.world.entity.player.Player;
import net.rotgruengelb.grace_period.util.SpecialCodecs;
import net.rotgruengelb.grace_period.util.mixin.accessor.PlayerEntityAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//? if 1.21.10 {
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.stream.Stream;
//?} else {
/*import net.minecraft.nbt.CompoundTag;
*///?}

@Mixin(Player.class)
public abstract class PlayerEntityMixin implements PlayerEntityAccessor {

	@Unique
	private int gracePeriodRemainingTicks = -1;

	@Override
	public int grace_period$getGracePeriodRemainingTicks() {
		return gracePeriodRemainingTicks;
	}

	@Override
	public void grace_period$setGracePeriodRemainingTicks(int gracePeriodRemainingTicks) {
		this.gracePeriodRemainingTicks = gracePeriodRemainingTicks;
	}

	//? if 1.21.10 {
	@Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
	protected void injectAddAdditionalSaveData(ValueOutput valueOutput, CallbackInfo ci) {
		valueOutput.putInt("grace_period_remaining_ticks", gracePeriodRemainingTicks);
	}

	@Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
	protected void injectReadAdditionalSaveData(ValueInput valueInput, CallbackInfo ci) {
		if (!valueInputContains(valueInput, "grace_period_remaining_ticks")) {
			gracePeriodRemainingTicks = -1;
			return;
		}
		gracePeriodRemainingTicks = valueInput.getInt("grace_period_remaining_ticks").orElse(-1);
	}

	@Unique
	boolean valueInputContains(ValueInput valueInput, String key) {
		return valueInput.read(SpecialCodecs.contains(key)).orElseThrow();
	}

	//?} else {
	/*@Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
	protected void injectAddAdditionalSaveData(CompoundTag compoundTag, CallbackInfo ci) {
		compoundTag.putInt("grace_period_remaining_ticks", gracePeriodRemainingTicks);
	}

	@Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
	protected void injectReadAdditionalSaveData(CompoundTag compoundTag, CallbackInfo ci) {
		if (!compoundTag.contains("grace_period_remaining_ticks")) {
			gracePeriodRemainingTicks = -1;
			return;
		}
		gracePeriodRemainingTicks = compoundTag.getInt("grace_period_remaining_ticks");
	}
	*///?}
}

