package edu.charles.forge.mods.tabs;


import edu.charles.forge.mods.core.main.DyeableClothes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabsMainMod extends CreativeTabs {

public CreativeTabsMainMod(String tabLabel)
{
super(tabLabel);
}

@Override
public Item getTabIconItem() {
	return DyeableClothes.clothShirt;
}
@Override
public String getTranslatedTabLabel() {
	return "Dyeable Clothes";
}

}