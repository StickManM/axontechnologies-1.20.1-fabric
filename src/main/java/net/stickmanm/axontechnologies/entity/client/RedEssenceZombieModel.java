package net.stickmanm.axontechnologies.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.stickmanm.axontechnologies.AxonTechnologies;
import net.stickmanm.axontechnologies.entity.custom.RedEssenceZombieEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RedEssenceZombieModel extends GeoModel<RedEssenceZombieEntity> {
    @Override
    public Identifier getModelResource(RedEssenceZombieEntity animatable) {
        return new Identifier(AxonTechnologies.MOD_ID,"geo/red_essence_zombie.geo.json");
    }

    @Override
    public Identifier getTextureResource(RedEssenceZombieEntity animatable) {
        return new Identifier(AxonTechnologies.MOD_ID,"textures/entity/red_essence_zombie.png");    }

    @Override
    public Identifier getAnimationResource(RedEssenceZombieEntity animatable) {
        return new Identifier(AxonTechnologies.MOD_ID,"animations/red_essence_zombie.animation.json");
    }
    @Override
    public void setCustomAnimations(RedEssenceZombieEntity animatable, long instanceId, AnimationState<RedEssenceZombieEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
