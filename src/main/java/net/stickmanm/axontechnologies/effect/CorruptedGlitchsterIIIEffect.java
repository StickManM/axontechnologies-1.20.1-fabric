package net.stickmanm.axontechnologies.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class CorruptedGlitchsterIIIEffect extends StatusEffect {
    public CorruptedGlitchsterIIIEffect() {
        super(StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0x000000); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not


    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int Amplifier) {
        if(entity.hasStatusEffect(ModEffects.ANTI_CORRUPTED_GLITCHSTER)) {
            if (!entity.getWorld().isClient()) {
                addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 3f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 20f, EntityAttributeModifier.Operation.ADDITION)
                        .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "91AEAA56-376B-4498-935B-2F7F68070635", 40f, EntityAttributeModifier.Operation.ADDITION)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 30f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                        .addAttributeModifier(EntityAttributes.GENERIC_LUCK, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 50, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
            }
        }
        else {
            if (!entity.getWorld().isClient()) {
                if(entity.isPlayer()){
                    ((PlayerEntity) entity).getHungerManager().add(Amplifier + 1, 1.0f);
                    entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 10, 1, false, false, false));

                }
                addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 19f, EntityAttributeModifier.Operation.ADDITION)
                        .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 8f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                        .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "91AEAA56-376B-4498-935B-2F7F68070635", 50f, EntityAttributeModifier.Operation.ADDITION)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 40f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                        .addAttributeModifier(EntityAttributes.GENERIC_LUCK, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 67f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 10, 2, false, false, false));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 10, 4, false, false, false));
                if (entity.getHealth() < entity.getMaxHealth()) {
                    entity.heal(0.1F);
                }
            }
        }


        super.applyUpdateEffect(entity, Amplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
}