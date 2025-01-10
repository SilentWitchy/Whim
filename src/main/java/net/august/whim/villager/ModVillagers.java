package net.august.whim.villager;

import com.google.common.collect.ImmutableSet;
import net.august.whim.Whim;
import net.august.whim.block.ModBlocks;
import net.august.whim.sound.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.concurrent.Immutable;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, Whim.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, Whim.MOD_ID);

    // ImmutableSet.copyOf(ModBlocks.(BLOCK HERE) dictates what block creates the villager type.
    // MaxTickets is how many different villagers can take the profession from the block
    // Valid range is how far they can take from it.
    public static final Holder<PoiType> MAGIC_POI = POI_TYPES.register("magic_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MAGIC_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> COVENER = VILLAGER_PROFESSIONS.register( "covener",
            () -> new VillagerProfession("covener", holder -> holder.value() == MAGIC_POI.value(),
                    holder -> holder.value() == MAGIC_POI.value(),ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.MAGIC_BLOCK_PLACE.get()));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
