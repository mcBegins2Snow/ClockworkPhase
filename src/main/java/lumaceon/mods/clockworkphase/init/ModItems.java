package lumaceon.mods.clockworkphase.init;

import cpw.mods.fml.common.registry.GameRegistry;
import lumaceon.mods.clockworkphase.item.*;
import lumaceon.mods.clockworkphase.item.elemental.hourglass.*;
import lumaceon.mods.clockworkphase.lib.Names;
import lumaceon.mods.clockworkphase.lib.Phases;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
    public static Item bugSwatter;
    public static Item brassIngot;
    public static Item mainspring;
    public static Item handCrank;
    public static Item timeSandBucket;

    public static Item hourglass;
    public static Item[] hourglassElements = new Item[8];

    public static void init() {
        bugSwatter = new ItemBugSwatter().setUnlocalizedName(Names.BUG_SWATTER);
        GameRegistry.registerItem(bugSwatter, Names.BUG_SWATTER);

        brassIngot = new ItemBrassIngot().setUnlocalizedName(Names.BRASS_INGOT);
        GameRegistry.registerItem(brassIngot, Names.BRASS_INGOT);
        OreDictionary.registerOre("ingotBrass", brassIngot);

        mainspring = new ItemMainspring().setUnlocalizedName(Names.MAINSPRING);
        GameRegistry.registerItem(mainspring, Names.MAINSPRING);

        handCrank = new ItemHandCrank().setUnlocalizedName(Names.HAND_CRANK);
        GameRegistry.registerItem(handCrank, Names.HAND_CRANK);

        timeSandBucket = new ItemTimeSandBucket(ModBlocks.timeSand).setUnlocalizedName(Names.TIME_SAND_BUCKET).setContainerItem(Items.bucket);
        GameRegistry.registerItem(timeSandBucket, Names.TIME_SAND_BUCKET);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(ModFluids.timeSand.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(timeSandBucket), new ItemStack(Items.bucket));


        //HOURGLASS\\
        hourglass = new ItemHourglass().setUnlocalizedName(Names.HOURGLASS);
        GameRegistry.registerItem(hourglass, Names.HOURGLASS);

        hourglassElements[0] = new ItemHourglassLife().setUnlocalizedName(Names.HOURGLASS + "Life");
        GameRegistry.registerItem(hourglassElements[0], Names.HOURGLASS + "Life");

        hourglassElements[1] = new ItemHourglassLight().setUnlocalizedName(Names.HOURGLASS + "Light");
        GameRegistry.registerItem(hourglassElements[1], Names.HOURGLASS + "Light");

        hourglassElements[2] = new ItemHourglassWater().setUnlocalizedName(Names.HOURGLASS + "Water");
        GameRegistry.registerItem(hourglassElements[2], Names.HOURGLASS + "Water");

        hourglassElements[3] = new ItemHourglassEarth().setUnlocalizedName(Names.HOURGLASS + "Earth");
        GameRegistry.registerItem(hourglassElements[3], Names.HOURGLASS + "Earth");

        hourglassElements[4] = new ItemHourglassAir().setUnlocalizedName(Names.HOURGLASS + "Air");
        GameRegistry.registerItem(hourglassElements[4], Names.HOURGLASS + "Air");

        hourglassElements[5] = new ItemHourglassFire().setUnlocalizedName(Names.HOURGLASS + "Fire");
        GameRegistry.registerItem(hourglassElements[5], Names.HOURGLASS + "Fire");

        hourglassElements[6] = new ItemHourglassDark().setUnlocalizedName(Names.HOURGLASS + "Dark");
        GameRegistry.registerItem(hourglassElements[6], Names.HOURGLASS + "Dark");

        hourglassElements[7] = new ItemHourglassDeath().setUnlocalizedName(Names.HOURGLASS + "Death");
        GameRegistry.registerItem(hourglassElements[7], Names.HOURGLASS + "Death");
        //END HOURGLASS\\
    }
}