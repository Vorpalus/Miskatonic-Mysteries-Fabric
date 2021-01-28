package com.miskatonicmysteries.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class InfestedWheatCropBlock extends CropBlock {
    public static final IntProperty AGE = Properties.AGE_1;

    public InfestedWheatCropBlock() {
        super(Settings.copy(Blocks.WHEAT));
    }


    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 1;
    }
}