package net.august.whim.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.august.whim.Whim;
import net.august.whim.item.ModItems;
import net.august.whim.item.custom.HammerItem;
import net.august.whim.potion.ModPotions;
import net.august.whim.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = Whim.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if(event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if(player.getMainHandItem().getItem() == Items.END_ROD) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with an END ROD? YOU SICK FRICK!"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 6));
                player.getMainHandItem().shrink(1);
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // trades.get() dictates what level of the villager you're adding the trades to.
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    // Count is how many you get, maxUses is how many times you can before restock
                    new ItemStack(ModItems.RADISH.get(), 8), 8, 4, 0.05f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 10),
                    // Count is how many you get, maxUses is how many times you can before restock
                    new ItemStack(ModItems.CHISEL.get(), 1), 1, 10, 0.05f
            ));
        }

            if(event.getType() == ModVillagers.COVENER.value()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                // Make sure trades.get has a level 1
                trades.get(1).add((pTrader , pRandom) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 6),
                        new ItemStack(ModItems.FROSTFIRE_ICE.get(), 8), 4, 4, 0.05f
                ));

                trades.get(2).add((pTrader , pRandom) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 3),
                        new ItemStack(ModItems.RADISH.get(), 8), 8, 4, 0.05f
                ));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader , pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD , 2),
                new ItemStack(ModItems.RADISH.get(), 8), 8, 4, 0.05f
        ));

        rareTrades.add((pTrader , pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD , 10),
                new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC.get(), 1), 1, 10, 0.05f
        ));

    }
}
