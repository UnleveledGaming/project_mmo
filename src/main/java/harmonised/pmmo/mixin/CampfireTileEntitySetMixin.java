package harmonised.pmmo.mixin;

import harmonised.pmmo.events.FurnaceHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.CampfireTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin( CampfireTileEntity.class )
public class CampfireTileEntitySetMixin extends TileEntity
{
    public CampfireTileEntitySetMixin(TileEntityType<?> p_i48289_1_)
    {
        super(p_i48289_1_);
    }

    @Inject( at = @At( value = "INVOKE", target = "Lnet/minecraft/inventory/InventoryHelper;spawnItemStack(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V" ), method = "cookAndDrop", locals = LocalCapture.CAPTURE_FAILEXCEPTION )
    private void projectmmo$$handleSmeltingSet(CallbackInfo info, int i, ItemStack itemstack, int j, IInventory iInventory, ItemStack itemstack1 )
    {
        FurnaceHandler.handleSmelted( itemstack, itemstack1, this.getWorld(), 1 );
    }
}