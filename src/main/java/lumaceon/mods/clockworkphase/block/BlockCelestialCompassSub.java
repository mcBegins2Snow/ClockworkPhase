package lumaceon.mods.clockworkphase.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lumaceon.mods.clockworkphase.init.ModBlocks;
import lumaceon.mods.clockworkphase.util.TextureHelper;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCelestialCompassSub extends BlockClockworkPhaseAbstract
{
    public IIcon[] icons = new IIcon[96];

    public BlockCelestialCompassSub(Material material)
    {
        super(material);
        this.setCreativeTab(null);
        this.setBlockUnbreakable();
        this.setResistance(1000000F);
        this.setLightLevel(1.0F);
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.blockIcon;
    }

    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int meta)
    {
        if(meta != 0 && meta != 1)
        {
            return this.blockIcon;
        }

        boolean flag = true;

        //Coordinates to be passed into the TextureHelper.
        int xOffset = 0;
        int zOffset = 0;

        meta = blockAccess.getBlockMetadata(x, y, z);
        ForgeDirection direction = ForgeDirection.getOrientation(meta);

        x += direction.offsetX;
        z += direction.offsetZ;

        xOffset += -direction.offsetX;
        zOffset += -direction.offsetZ;

        for(int n = 0; n < 10 && flag; n++)
        {
            if(blockAccess.getBlock(x, y, z) == null)
            {
                return getIcon(0, 0);
            }
            else if(blockAccess.getBlock(x, y, z).equals(ModBlocks.celestialCompass))
            {
                flag = false;
            }
            else
            {
                meta = blockAccess.getBlockMetadata(x, y, z);
                direction = ForgeDirection.getOrientation(meta);

                x += direction.offsetX;
                z += direction.offsetZ;

                xOffset += -direction.offsetX;
                zOffset += -direction.offsetZ;
            }
        }

        int iconIndex = TextureHelper.getCCTextureIndexFromCoordinates(xOffset, zOffset);
        if(iconIndex < 0 || iconIndex > 96)
        {
            iconIndex = 0;
        }
        return this.icons[iconIndex];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registry)
    {
        this.blockIcon = registry.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));

        for(int n = 0; n < 96; n++)
        {
            this.icons[n] = registry.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "/" + n);
        }
    }
}
