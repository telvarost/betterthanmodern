package me.meta4245.betterthanmodern.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class RedstoneBlock extends TemplateBlock {
    public RedstoneBlock(Identifier identifier) {
        super(identifier, Material.METAL);
        super.setHardness(5);
        super.setResistance(6);
    }
}
