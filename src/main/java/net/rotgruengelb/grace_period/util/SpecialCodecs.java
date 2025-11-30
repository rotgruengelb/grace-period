package net.rotgruengelb.grace_period.util;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapLike;
import com.mojang.serialization.RecordBuilder;
import org.spongepowered.asm.mixin.Unique;

import java.util.stream.Stream;

public class SpecialCodecs {
	public static MapCodec<Boolean> contains(String key) {
		return new MapCodec<>() {
			@Override
			public <T> RecordBuilder<T> encode(Boolean booleanInput, DynamicOps<T> dynamicOps, RecordBuilder<T> prefix) {
				return prefix;
			}

			@Override
			public <T> Stream<T> keys(DynamicOps<T> dynamicOps) {
				return Stream.empty();
			}

			@Override
			public <T> DataResult<Boolean> decode(DynamicOps<T> dynamicOps, MapLike<T> mapLikeInput) {
				return DataResult.success(mapLikeInput.get(key) != null);
			}

		};
	}
}
