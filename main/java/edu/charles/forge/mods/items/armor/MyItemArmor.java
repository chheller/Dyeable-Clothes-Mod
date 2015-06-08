package edu.charles.forge.mods.items.armor;

import java.util.List;

import edu.charles.forge.mods.core.main.ItemRenderRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;



public class MyItemArmor extends ItemArmor {

	public MyItemArmor(String unlocalizedName, ArmorMaterial material,
			int renderIndex, int type) {
		super(material, renderIndex, type);
		this.setUnlocalizedName(unlocalizedName);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);

	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName();
	}

	//Create a function to give each new item an NBT upon crafting
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if (itemStack.getTagCompound() == null)
			itemStack.setTagCompound(new NBTTagCompound());
	}
	//Magic dye numbers pulled from ItemDye.java
	private int[] dyeints = { 1973019, 11743532, 3887386, 5320730, 2437522,
			8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026,
			6719955, 12801229, 15435844, 15790320 };
	//Create the 15 other colors of armor using metadata/NBT
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			ItemStack stack = new ItemStack(itemIn, 1, i);
			subItems.add(stack);
			((ItemArmor) stack.getItem()).setColor(stack, dyeints[i]);
			ItemRenderRegister.reg(stack.getItem(), i);
		}
	}
	//Override the get/has/setColor() functions and strip the if material != leather condition so that things will work with cloth armor.
	@Override
	public int getColor(ItemStack stack) {

		NBTTagCompound nbttagcompound = stack.getTagCompound();

		if (nbttagcompound != null) {
			NBTTagCompound nbttagcompound1 = nbttagcompound
					.getCompoundTag("display");

			if (nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3)) {
				return nbttagcompound1.getInteger("color");
			}
		}

		return 15790320;

	}

	@Override
	public boolean hasColor(ItemStack stack) {
		return true;
	}

	@Override
	public void setColor(ItemStack stack, int color) {
		NBTTagCompound nbttagcompound = stack.getTagCompound();

		if (nbttagcompound == null) {
			nbttagcompound = new NBTTagCompound();
			stack.setTagCompound(nbttagcompound);
		}

		NBTTagCompound nbttagcompound1 = nbttagcompound
				.getCompoundTag("display");

		if (!nbttagcompound.hasKey("display", 10)) {
			nbttagcompound.setTag("display", nbttagcompound1);
		}

		nbttagcompound1.setInteger("color", color);
	}
}
