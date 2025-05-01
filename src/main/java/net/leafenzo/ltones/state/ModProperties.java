package net.leafenzo.ltones.state;

import net.leafenzo.ltones.block.enums.CRTDisplay;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;

public class ModProperties {
    public static final BooleanProperty HAS_ANTENNA = BooleanProperty.of("has_antenna");
    public static final BooleanProperty LOWER = BooleanProperty.of("lower");
    public static final EnumProperty<CRTDisplay> DISPLAY = EnumProperty.of("display", CRTDisplay.class);
}
