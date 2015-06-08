package edu.charles.forge.mods.core.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public final class ItemRenderRegister {
	public static void registerItemRenderer() {
		reg(DyeableClothes.clothBoots);
		reg(DyeableClothes.clothHat);
		reg(DyeableClothes.clothShirt);
		reg(DyeableClothes.clothPants);
	}

	public static void reg(Item item) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(DyeableClothes.MODID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}

	public static void reg(Item item, int meta, String file) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						meta,
						new ModelResourceLocation(DyeableClothes.MODID + ":"
								+ file, "inventory"));
	}

	public static void reg(Item item, int meta) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						meta,
						new ModelResourceLocation(DyeableClothes.MODID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}

}
