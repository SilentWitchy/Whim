package net.august.whim.trim;

import net.august.whim.Whim;
import net.august.whim.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> BISMUTH =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Whim.MOD_ID, "bismuth"));
//  public static final ResourceKey<TrimMaterial> NEW TRIM MATERIAL =
//          ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Whim.MOD_ID, "NEW TRIM MATERIAL"));

    // List of armor trims.
    // (TextColor.parseColor("#031cfc") dictates on hover text color
    // ItemModelIndex determines what color the item texture turns into. based on the TrimMaterials hashmap in ModItemsModelProvider
    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, BISMUTH, ModItems.BISMUTH.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc").getOrThrow()), 0.5F);
//      register(context, NEW TRIM MATERIAL, ModItems.NEW TRIM MATERIAL.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc").getOrThrow()), 0.5F);

    }

    //Helper method to register trim material.
    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}
