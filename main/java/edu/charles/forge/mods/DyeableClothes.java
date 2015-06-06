package edu.charles.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;



@Mod(modid = DyeableClothes.MODID, version = DyeableClothes.VERSION)
public class DyeableClothes {
	@SidedProxy(clientSide="edu.charles.forge.mods.ClientProxy", serverSide="edu.charles.forge.mods.ServerProxy")
	public static CommonProxy proxy;
	public static final String MODID = "dyeableclothes";
	public static final String VERSION = "1.0.1";

	public static ArmorMaterial CLOTH = EnumHelper.addArmorMaterial("CLOTH", "dyeableclothes:cloth", 0, new int[] {0, 0, 0, 0}, 0);

	public static Item clothHat;
	public static Item clothShirt;
	public static Item clothPants;
	public static Item clothBoots;

	public static CreativeTabs tabDyeableClothes = new CreativeTabsMainMod("Dyeable Clothes");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
	this.proxy.preInit(event);
	GameRegistry.registerItem(clothHat = new MyItemArmor("cloth_Hat", CLOTH, 1, 0).setCreativeTab(tabDyeableClothes), "cloth_Hat");
	GameRegistry.registerItem(clothShirt = new MyItemArmor("cloth_Shirt", CLOTH, 1, 1).setCreativeTab(tabDyeableClothes), "cloth_Shirt");
	GameRegistry.registerItem(clothPants = new MyItemArmor("cloth_Pants", CLOTH, 2, 2).setCreativeTab(tabDyeableClothes), "cloth_Pants");
	GameRegistry.registerItem(clothBoots = new MyItemArmor("cloth_Boots", CLOTH, 1, 3).setCreativeTab(tabDyeableClothes), "cloth_Boots");
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {	
		this.proxy.init(event);
		ItemRenderRegister.registerItemRenderer();
		ModCrafting.initCrafting();
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	    this.proxy.postInit(event);
	}
}