package me.meta4245.betterthanmodern.mixin;

import me.meta4245.betterthanmodern.annotation.Axe;
import me.meta4245.betterthanmodern.event.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.meta4245.betterthanmodern.ReflectionHacks.field_name;
import static me.meta4245.betterthanmodern.ReflectionHacks.getBlocks;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {
    @Shadow
    private static Block[] axeEffectiveBlocks;

    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/item/AxeItem;axeEffectiveBlocks:[Lnet/minecraft/block/Block;",
            opcode = Opcodes.PUTSTATIC,
            shift = At.Shift.AFTER))
    private static void append(CallbackInfo ci) {
        List<Class<?>> classes;
        try {
            classes = getBlocks()
                    .stream()
                    .filter(clazz -> clazz.isAnnotationPresent(Axe.class))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Block> blocks = new ArrayList<>(Arrays.asList(axeEffectiveBlocks));
        for (Class<?> c : classes) {
            Block block;
            try {
                block = (Block) BlockRegistry.class.getDeclaredField(field_name(c)).get(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            blocks.add(block);
        }

        axeEffectiveBlocks = blocks.toArray(new Block[0]);
    }
}
