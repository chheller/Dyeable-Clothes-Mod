package edu.charles.forge.mods;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabsMainMod extends CreativeTabs {

public CreativeTabsMainMod(String tabLabel)
{
super(tabLabel);
}

@Override
public Item getTabIconItem()
{
return DyeableClothes.clothShirt;
}

}