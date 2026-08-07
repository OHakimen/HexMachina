package com.hakimen.hex_machina.common.compat.trinkets;

import at.petrak.hexcasting.common.lib.HexAttributes;
import com.google.common.collect.Multimap;
import com.hakimen.hex_machina.common.registry.ItemRegister;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class TrinketsCompat {

    public static void register() {
        TrinketsApi.registerTrinket(ItemRegister.SCRYING_GOOGLES.get(), new Trinket() {
            @Override
            public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
                var modifiers = Trinket.super.getModifiers(stack, slot, entity, uuid);
                modifiers.put(HexAttributes.GRID_ZOOM, new AttributeModifier(
                        uuid,
                        "Scrying Lens Zoom", 0.5, AttributeModifier.Operation.MULTIPLY_BASE));
                modifiers.put(HexAttributes.SCRY_SIGHT, new AttributeModifier(
                        uuid,
                        "Scrying Lens Sight", 1.0, AttributeModifier.Operation.ADDITION));
                return modifiers;
            }
        });
    }
}
