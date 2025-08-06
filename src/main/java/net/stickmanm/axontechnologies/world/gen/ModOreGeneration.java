package net.stickmanm.axontechnologies.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.stickmanm.axontechnologies.world.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.all(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MIMICARIUM_ORE_PLACED_KEY);
    }
}