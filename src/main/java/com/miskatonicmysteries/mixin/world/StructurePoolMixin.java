package com.miskatonicmysteries.mixin.world;

import net.minecraft.structure.pool.StructurePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@SuppressWarnings("UnresolvedMixinReference")
@Mixin(StructurePool.class)
public class StructurePoolMixin {
	/**
	 * Increases the weight limit that mojang slapped on that was a workaround for https://bugs.mojang.com/browse/MC-203131
	 * @author - TelepathicGrunt
	 * @return - The higher weight that is a more reasonable limit.
	 */
	@ModifyConstant(
			method = "lambda$static$1",
			constant = @Constant(intValue = 150),
			remap = false,
			require = 0
	)
	private static int mm_increaseWeightLimitDev(int constant) {
		return 5000;
	}

	/**
	 * Increases the weight limit that mojang slapped on that was a workaround for https://bugs.mojang.com/browse/MC-203131
	 * @author - TelepathicGrunt
	 * @return - The higher weight that is a more reasonable limit.
	 */
	@ModifyConstant(
			method = "method_28886",
			constant = @Constant(intValue = 150),
			remap = false,
			require = 0
	)
	private static int mm_increaseWeightLimitProd(int constant) {
		return 5000;
	}
}
