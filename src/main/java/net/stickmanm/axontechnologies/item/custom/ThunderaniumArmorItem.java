package net.stickmanm.axontechnologies.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.world.World;
import net.stickmanm.axontechnologies.AxonTechnologies;
import net.stickmanm.axontechnologies.effect.GlitchsterEffect;
import net.stickmanm.axontechnologies.effect.ModEffects;
import net.stickmanm.axontechnologies.item.ModArmorMaterials;
import net.stickmanm.axontechnologies.item.ModItems;
import net.stickmanm.axontechnologies.item.client.ThunderaniumArmorRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ThunderaniumArmorItem extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);


    public ThunderaniumArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private ThunderaniumArmorRenderer renderer;


            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                        EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null)
                    this.renderer = new ThunderaniumArmorRenderer();


                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);


                return this.renderer;
            }
        });

    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }
    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {


        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                ItemStack headPiece = player.getEquippedStack(EquipmentSlot.HEAD);
                ItemStack chestPiece = player.getEquippedStack(EquipmentSlot.CHEST);
                ItemStack legPiece = player.getEquippedStack(EquipmentSlot.LEGS);
                ItemStack footPiece = player.getEquippedStack(EquipmentSlot.FEET);




                if (headPiece.isOf(ModItems.THUNDERANIUM_HELMET) &&
                        chestPiece.isOf(ModItems.THUNDERANIUM_CHESTPLATE) &&
                        legPiece.isOf(ModItems.THUNDERANIUM_LEGGINGS) &&
                        footPiece.isOf(ModItems.THUNDERANIUM_BOOTS)) {

                    if(player.hasStatusEffect(ModEffects.ANTIGLITCHSTER)) {
                        player.removeStatusEffect(ModEffects.GLITCHSTER);
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 10, 1, false, false, false));
                    } else if (player.hasStatusEffect(ModEffects.GLITCHSTERX)) {
                        player.removeStatusEffect(ModEffects.GLITCHSTER);
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 10, 1, false, false, false));
                    } else {
                        player.addStatusEffect(new StatusEffectInstance(ModEffects.GLITCHSTER, 200, 0, false, false, true));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false, true));
                    }

                  }

            }




    }

        super.inventoryTick(stack, world, entity, slot, selected);
    }




}
