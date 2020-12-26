package com.miskatonicmysteries.lib;

import com.google.common.collect.ImmutableList;
import com.miskatonicmysteries.common.MiskatonicMysteries;
import com.miskatonicmysteries.common.feature.world.processor.PsychonautHouseProcessor;
import com.miskatonicmysteries.lib.util.Constants;
import com.miskatonicmysteries.lib.util.WorldUtil;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.RuleStructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorRule;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.structure.rule.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Arrays;

public class ModWorld {
    public static final StructureProcessorType<PsychonautHouseProcessor> PSYCHONAUT_PROCESSOR = StructureProcessorType.register(Constants.MOD_ID + ":psychonaut_house", PsychonautHouseProcessor.CODEC);

    public static final PointOfInterestType PSYCHONAUT_POI = PointOfInterestHelper.register(new Identifier(Constants.MOD_ID, "psychonaut"), 1, 1, ModObjects.CHEMISTRY_SET);
    public static final StructureProcessorList ZOMBIE_PROCESSOR = new StructureProcessorList(Arrays.asList(new PsychonautHouseProcessor(10091940), new RuleStructureProcessor(ImmutableList.of(new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.8F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()), new StructureProcessorRule(new TagMatchRuleTest(BlockTags.DOORS), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new StructureProcessorRule(new BlockMatchRuleTest(Blocks.TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new StructureProcessorRule(new BlockMatchRuleTest(Blocks.WALL_TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.MOSSY_COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.WHITE_TERRACOTTA, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.OAK_LOG, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.OAK_PLANKS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.OAK_STAIRS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.STRIPPED_OAK_LOG, 0.02F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.GLASS_PANE, 0.5F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new StructureProcessorRule[]{new StructureProcessorRule(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, true).with(PaneBlock.SOUTH, true)), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, true).with(PaneBlock.SOUTH, true)), new StructureProcessorRule(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.EAST, true).with(PaneBlock.WEST, true)), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.EAST, true).with(PaneBlock.WEST, true))}))));
    public static final StructureProcessorList NORMAL_PROCESSOR = new StructureProcessorList(Arrays.asList(new PsychonautHouseProcessor(10091940), new RuleStructureProcessor(ImmutableList.of(new StructureProcessorRule(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState())))));

    public static void init() {
        //redo this tbh

        WorldUtil.addStructureToPool(StructurePool.Projection.RIGID, new Identifier("village/plains/houses"), new Identifier(Constants.MOD_ID, "village/plains/houses/psychonaut_house"), MiskatonicMysteries.config.psychonautHouseWeight, NORMAL_PROCESSOR);
        WorldUtil.addStructureToPool(StructurePool.Projection.RIGID, new Identifier("village/plains/zombie/houses"), new Identifier(Constants.MOD_ID, "village/plains/zombie/houses/psychonaut_house"), MiskatonicMysteries.config.psychonautHouseWeight, ZOMBIE_PROCESSOR);

        WorldUtil.addStructureToPool(StructurePool.Projection.RIGID, new Identifier("village/savanna/town_centers"), new Identifier(Constants.MOD_ID, "village/savanna/town_centers/savanna_hastur_shrine"), 2, NORMAL_PROCESSOR);

        StructurePools.register(new StructurePool(new Identifier(Constants.MOD_ID, "village/common/hastur_cultist"), new Identifier("empty"), Arrays.asList(Pair.of(StructurePoolElement.method_30426(Constants.MOD_ID + ":village/common/hastur_cultist", null), 1)), StructurePool.Projection.RIGID));
        StructurePools.register(new StructurePool(new Identifier(Constants.MOD_ID, "village/common/hastur_cultist_ascended"), new Identifier("empty"), Arrays.asList(Pair.of(StructurePoolElement.method_30426(Constants.MOD_ID + ":village/common/hastur_cultist_ascended", null), 1)), StructurePool.Projection.RIGID));
    }
}
