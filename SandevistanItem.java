package com.example.sandevistan;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;

import java.util.List;

public class SandevistanItem extends TrinketItem {
    public SandevistanItem() {
        super(new Item.Settings().maxCount(1).rarity(Rarity.EPIC).fireproof());
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("item.sandevistan.sandevistan.tooltip").formatted(Formatting.AQUA));
    }
}
