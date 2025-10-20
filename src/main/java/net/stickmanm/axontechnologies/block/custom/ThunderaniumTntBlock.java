package net.stickmanm.axontechnologies.block.custom;

import net.minecraft.block.Blocks;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.stickmanm.axontechnologies.entity.custom.ThunderaniumTntEntity;
import org.jetbrains.annotations.Nullable;

public class ThunderaniumTntBlock extends TntBlock {
    public ThunderaniumTntBlock(Settings settings) {
        super(settings);
    }

    private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (world.isClient) {
            return;
        }
        ThunderaniumTntEntity thunderaniumTntEntity = new ThunderaniumTntEntity(world,
                (double)pos.getX() + 0.5,
                (double)pos.getY(),
                (double)pos.getZ() + 0.5,
                igniter);

        world.spawnEntity(thunderaniumTntEntity);
        world.playSound(null, thunderaniumTntEntity.getX(), thunderaniumTntEntity.getY(), thunderaniumTntEntity.getZ(),
                SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        // The vanilla TntBlock removes the block, but it's often safer to rely on your
        // custom block's logic or simply call super to ensure the block is replaced.
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
    }



}
