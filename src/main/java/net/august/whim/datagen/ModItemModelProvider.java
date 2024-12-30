package net.august.whim.datagen;

import net.august.whim.Whim;
import net.august.whim.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

//This applies the textures to the list of items below.
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Whim.MOD_ID, existingFileHelper);
    }

    //List of items to attach textures too.
    @Override
    protected void registerModels() {
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());

        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
    }
}


