package net.leafenzo.ltones.stat;

import net.leafenzo.ltones.ModInit;
import net.leafenzo.ltones.Super;
import net.leafenzo.ltones.mixin.accessor.StatsAccessor;
import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;

public class ModStats {
    public static final Identifier OPEN_CRATE = StatsAccessor.invokeRegister("open_crate", StatFormatter.DEFAULT);

    public static void registerModStats() {
        ModInit.LOGGER.debug("Registering new stats for " + Super.MOD_ID);
    }
}
