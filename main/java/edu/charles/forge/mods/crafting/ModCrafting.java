package edu.charles.forge.mods.crafting;

import edu.charles.forge.mods.core.main.DyeableClothes;
import edu.charles.forge.mods.items.armor.MyItemArmor;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {
	public static void initCrafting() {

		int[] dyeints = {1973019, 11743532, 3887386, 5320730, 
						2437522, 8073150, 2651799, 11250603, 
						4408131, 14188952, 4312372, 14602026, 
						6719955, 12801229, 15435844, 15790320};
	 
		for (int color = 0; color < 16; color++) {
			ItemStack coloredHat = new ItemStack(DyeableClothes.clothHat);
			ItemStack coloredPants = new ItemStack(DyeableClothes.clothPants);
			ItemStack coloredShirt = new ItemStack(DyeableClothes.clothShirt);
			ItemStack coloredBoots = new ItemStack(DyeableClothes.clothBoots);
			((MyItemArmor) coloredBoots.getItem()).setColor(coloredBoots, dyeints[color]);
			((MyItemArmor) coloredShirt.getItem()).setColor(coloredShirt, dyeints[color]);
			((MyItemArmor) coloredPants.getItem()).setColor(coloredPants, dyeints[color]);
			((MyItemArmor) coloredHat.getItem()).setColor(coloredHat, dyeints[color]);
			GameRegistry.addRecipe(coloredBoots, "# #", "# #", '#',new ItemStack(Blocks.wool, 1, dyeints.length - 1 - color));
			GameRegistry.addRecipe(coloredPants, "###", "# #", "# #", '#',new ItemStack(Blocks.wool, 1, dyeints.length - 1 - color));
			GameRegistry.addRecipe(coloredShirt, "# #", "###", "###", '#',new ItemStack(Blocks.wool, 1,dyeints.length - 1 - color));
			GameRegistry.addRecipe(coloredHat, "###", "# #", '#',new ItemStack(Blocks.wool, 1, dyeints.length -1 -  color));
			for (int base = 0; base < 16; base++) {
				GameRegistry.addShapelessRecipe(coloredBoots, new ItemStack(DyeableClothes.clothBoots, 1, base), 
						new ItemStack(Items.dye, 1, color));					
				GameRegistry.addShapelessRecipe(coloredHat, new ItemStack(DyeableClothes.clothHat, 1, base), 
						new ItemStack(Items.dye, 1, color));
				GameRegistry.addShapelessRecipe(coloredShirt, new ItemStack(DyeableClothes.clothShirt, 1, base),
						new ItemStack(Items.dye, 1, color));
				GameRegistry.addShapelessRecipe(coloredPants, new ItemStack(DyeableClothes.clothPants, 1, base), 
						new ItemStack(Items.dye, 1, color));

			}
		}



	}

}