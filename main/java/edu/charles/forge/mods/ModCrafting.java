package edu.charles.forge.mods;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {
	public static void initCrafting() {
	
		int[] dyeints = {1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 
				14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 1644825};
		
		GameRegistry.addRecipe(new ItemStack(DyeableClothes.clothShirt), "# #", "###", "###", '#', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(DyeableClothes.clothHat), "###", "# #", '#', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(DyeableClothes.clothBoots), "# #", "# #", '#', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(DyeableClothes.clothPants), "###", "# #", "# #", '#', Blocks.wool);
		
		for (int color=0; color < 16; color++) {
			 for (int base=0; base < 16; base++) {
				 ItemStack coloredBoots = new ItemStack(DyeableClothes.clothBoots);
				 ((ItemArmor) coloredBoots.getItem()).setColor(coloredBoots, dyeints[color]);
				 GameRegistry.addShapelessRecipe(coloredBoots, new ItemStack(DyeableClothes.clothBoots, 1, base), new ItemStack(Items.dye, 1, color)); 
			}
		}
		for (int color=0; color<16; color++) {
			 for (int base=0; base < 16; base++) {
				 ItemStack coloredHat = new ItemStack(DyeableClothes.clothHat);
				 ((ItemArmor) coloredHat.getItem()).setColor(coloredHat, dyeints[color]);
				 GameRegistry.addShapelessRecipe(coloredHat, new ItemStack(DyeableClothes.clothHat, 1, base), new ItemStack(Items.dye, 1, color));
			}
		}
		for (int color=0; color<16; color++) {
			 for (int base=0; base < 16; base++) {
				 ItemStack coloredShirt = new ItemStack(DyeableClothes.clothShirt);
				 ((ItemArmor) coloredShirt.getItem()).setColor(coloredShirt, dyeints[color]);
				 GameRegistry.addShapelessRecipe(coloredShirt, new ItemStack(DyeableClothes.clothShirt, 1, base), new ItemStack(Items.dye, 1, color));			
			}
		}
		for (int color=0; color<16; color++) {
			 for (int base=0; base < 16; base++) {
				 ItemStack coloredPants = new ItemStack(DyeableClothes.clothPants);
				 ((ItemArmor) coloredPants.getItem()).setColor(coloredPants, dyeints[color]);
				 GameRegistry.addShapelessRecipe(coloredPants, new ItemStack(DyeableClothes.clothPants, 1, base), new ItemStack(Items.dye, 1, color));
			}
		}
	
	}

}