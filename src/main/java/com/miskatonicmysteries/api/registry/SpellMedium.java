package com.miskatonicmysteries.api.registry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public abstract class SpellMedium {
    private final Identifier id;

    public SpellMedium(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }

    public Identifier getTextureLocation() {
        return new Identifier(id.getNamespace(), "textures/gui/spell_widgets/medium/" + id.getPath() + ".png");
    }

    public abstract boolean cast(World world, LivingEntity caster, SpellEffect effect, int intensity);

    public abstract float getBurnoutRate(LivingEntity caster);
}
