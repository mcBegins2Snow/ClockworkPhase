package lumaceon.mods.clockworkphase.item.construct.abstracts;

import net.minecraft.item.ItemStack;

public interface IClockwork
{
    public void addTension(ItemStack is, int tension);

    public void removeTension(ItemStack is, int tension);
}
