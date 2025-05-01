/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package net.leafenzo.ltones.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum CRTDisplay implements StringIdentifiable
{
    COMMANDLINE("commandline"),
    DESKTOP("desktop"),
    INFLUENCE("influence"),
    NO_SIGNAL("no_signal"),
    STATIC("static");

    private final String name;

    CRTDisplay(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}

