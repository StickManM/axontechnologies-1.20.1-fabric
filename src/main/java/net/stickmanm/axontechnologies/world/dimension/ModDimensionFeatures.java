package net.stickmanm.axontechnologies.world.dimension;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.stickmanm.axontechnologies.world.biome.ModBiomes;

import static net.stickmanm.axontechnologies.AxonTechnologies.*;





public class ModDimensionFeatures {

    public static final RegistryKey<PlacedFeature> DREADSTONE_DIAMOND_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"dreadstone_diamond_ore"));
    public static final RegistryKey<PlacedFeature> DREADSTONE_THUNDERANIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"dreadstone_thunderanium_ore"));
    public static final RegistryKey<PlacedFeature> DREADSTONE_NETHERITE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"dreadstone_netherite_ore"));
    public static final RegistryKey<PlacedFeature> VOID_COAL_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"void_coal_ore"));
    public static final RegistryKey<PlacedFeature> CORRUPTION_BLOCK_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"corruption_block"));
    public static final RegistryKey<PlacedFeature> CORRUPTINITE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"corruptinite_ore"));
    public static final RegistryKey<PlacedFeature> THUNDERANIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"thunderanium_ore"));
    public static final RegistryKey<PlacedFeature> FAKESTONE_IRON_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"fakestone_iron_ore"));
    public static final RegistryKey<PlacedFeature> FAKESTONE_GOLD_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"fakestone_gold_ore"));
    public static final RegistryKey<PlacedFeature> FAKESLATE_IRON_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"fakeslate_iron_ore"));
    public static final RegistryKey<PlacedFeature> FAKESLATE_GOLD_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"fakeslate_gold_ore"));


    public static final RegistryKey<PlacedFeature> VOIDSTONE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"voidstone"));

    public static final RegistryKey<PlacedFeature> LIQUID_THUNDER_LAKE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"lake_liquid_thunder"));
    public static final RegistryKey<PlacedFeature> CORRUPTIONLANDS_LAVA_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"lake_corruptionlands_lava"));
    public static final RegistryKey<PlacedFeature> ORE_LIQUID_THUNDER_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"ore_liquid_thunder"));
    public static final RegistryKey<PlacedFeature> ORE_CORRUPTIONLANDS_LAVA_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID,"ore_corruptionlands_lava"));

    public static void registerModDimensionFeatures() {
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, DREADSTONE_DIAMOND_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, DREADSTONE_THUNDERANIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, DREADSTONE_NETHERITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, VOID_COAL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, THUNDERANIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_LIQUID_THUNDER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, CORRUPTION_BLOCK_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MIMIC_PLAINS_KEY,
                        ModBiomes.MIMIC_FOREST_KEY, ModBiomes.MIMIC_DESERT_KEY, ModBiomes.MIMIC_SWAMP_KEY, ModBiomes.MIMIC_TAIGA_KEY, ModBiomes.MIMIC_SNOWY_TAIGA_KEY, ModBiomes.MIMIC_BAMBOO_JUNGLE_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES, VOIDSTONE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MIMIC_PLAINS_KEY,
                        ModBiomes.MIMIC_FOREST_KEY, ModBiomes.MIMIC_DESERT_KEY, ModBiomes.MIMIC_SWAMP_KEY, ModBiomes.MIMIC_TAIGA_KEY, ModBiomes.MIMIC_SNOWY_TAIGA_KEY, ModBiomes.MIMIC_BAMBOO_JUNGLE_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES, FAKESTONE_IRON_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MIMIC_PLAINS_KEY,
                        ModBiomes.MIMIC_FOREST_KEY, ModBiomes.MIMIC_DESERT_KEY, ModBiomes.MIMIC_SWAMP_KEY, ModBiomes.MIMIC_TAIGA_KEY, ModBiomes.MIMIC_SNOWY_TAIGA_KEY, ModBiomes.MIMIC_BAMBOO_JUNGLE_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES, FAKESTONE_GOLD_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MIMIC_PLAINS_KEY,
                        ModBiomes.MIMIC_FOREST_KEY, ModBiomes.MIMIC_DESERT_KEY, ModBiomes.MIMIC_SWAMP_KEY, ModBiomes.MIMIC_TAIGA_KEY, ModBiomes.MIMIC_SNOWY_TAIGA_KEY, ModBiomes.MIMIC_BAMBOO_JUNGLE_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES, FAKESLATE_GOLD_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.MIMIC_PLAINS_KEY,
                        ModBiomes.MIMIC_FOREST_KEY, ModBiomes.MIMIC_DESERT_KEY, ModBiomes.MIMIC_SWAMP_KEY, ModBiomes.MIMIC_TAIGA_KEY, ModBiomes.MIMIC_SNOWY_TAIGA_KEY, ModBiomes.MIMIC_BAMBOO_JUNGLE_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES, FAKESLATE_IRON_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, CORRUPTINITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, ORE_CORRUPTIONLANDS_LAVA_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.THUNDERED_PLAINS_KEY), GenerationStep.Feature.LAKES, LIQUID_THUNDER_LAKE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CORRUPTED_PLAINS), GenerationStep.Feature.LAKES, CORRUPTIONLANDS_LAVA_PLACED_KEY);



    }
}
