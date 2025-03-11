package net.leafenzo.ltones.sound;

import net.leafenzo.ltones.Super;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent BLOCK_CAST_DOOR_OPEN = registerSoundEvent("block.cast_door.open");
    public static final SoundEvent BLOCK_CAST_DOOR_CLOSE = registerSoundEvent("block.cast_door.close");

    public static final SoundEvent BLOCK_CAST_BREAK = registerSoundEvent("block.cast.break");
    public static final SoundEvent BLOCK_CAST_STEP = registerSoundEvent("block.cast.step");
    public static final SoundEvent BLOCK_CAST_PLACE = registerSoundEvent("block.cast.place");
    public static final SoundEvent BLOCK_CAST_HIT = registerSoundEvent("block.cast.hit");
    public static final SoundEvent BLOCK_CAST_FALL = registerSoundEvent("block.cast.fall");

    public static final SoundEvent BLOCK_FOIL_BREAK = registerSoundEvent("block.foil.break");
    public static final SoundEvent BLOCK_FOIL_STEP = registerSoundEvent("block.foil.step");
    public static final SoundEvent BLOCK_FOIL_PLACE = registerSoundEvent("block.foil.place");
    public static final SoundEvent BLOCK_FOIL_HIT = registerSoundEvent("block.foil.hit");
    public static final SoundEvent BLOCK_FOIL_FALL = registerSoundEvent("block.foil.fall");

    public static final SoundEvent BLOCK_STATIC_BREAK = registerSoundEvent("block.static.break");
    public static final SoundEvent BLOCK_STATIC_STEP = registerSoundEvent("block.static.step");
    public static final SoundEvent BLOCK_STATIC_PLACE = registerSoundEvent("block.static.place");
    public static final SoundEvent BLOCK_STATIC_HIT = registerSoundEvent("block.static.hit");
    public static final SoundEvent BLOCK_STATIC_FALL = registerSoundEvent("block.static.fall");

    public static final SoundEvent BLOCK_NEON_BREAK = registerSoundEvent("block.neon.break");
    public static final SoundEvent BLOCK_NEON_STEP = registerSoundEvent("block.neon.step");
    public static final SoundEvent BLOCK_NEON_PLACE = registerSoundEvent("block.neon.place");
    public static final SoundEvent BLOCK_NEON_HIT = registerSoundEvent("block.neon.hit");
    public static final SoundEvent BLOCK_NEON_FALL = registerSoundEvent("block.neon.fall");

    public static final SoundEvent BLOCK_POLYGON_BREAK = registerSoundEvent("block.polygon.break");
    public static final SoundEvent BLOCK_POLYGON_STEP = registerSoundEvent("block.polygon.step");
    public static final SoundEvent BLOCK_POLYGON_PLACE = registerSoundEvent("block.polygon.place");
    public static final SoundEvent BLOCK_POLYGON_HIT = registerSoundEvent("block.polygon.hit");
    public static final SoundEvent BLOCK_POLYGON_FALL = registerSoundEvent("block.polygon.fall");
    public static final SoundEvent BLOCK_POLYGON_ACTIVATE = registerSoundEvent("block.polygon.activate");
    public static final SoundEvent BLOCK_POLYGON_DEACTIVATE = registerSoundEvent("block.polygon.deactivate");

    public static final SoundEvent BLOCK_EXRI_BREAK = registerSoundEvent("block.exri.break");
    public static final SoundEvent BLOCK_EXRI_STEP = registerSoundEvent("block.exri.step");
    public static final SoundEvent BLOCK_EXRI_PLACE = registerSoundEvent("block.exri.place");
    public static final SoundEvent BLOCK_EXRI_HIT = registerSoundEvent("block.exri.hit");
    public static final SoundEvent BLOCK_EXRI_FALL = registerSoundEvent("block.exri.fall");

    public static final SoundEvent BLOCK_EXRI_DOOR_OPEN = registerSoundEvent("block.exri_door.open");
    public static final SoundEvent BLOCK_EXRI_DOOR_CLOSE = registerSoundEvent("block.exri_door.close");

    public static final SoundEvent BLOCK_TONE_DOOR_OPEN = registerSoundEvent("block.tone_door.open");
    public static final SoundEvent BLOCK_TONE_DOOR_CLOSE = registerSoundEvent("block.tone_door.close");

    public static final SoundEvent BLOCK_TONE_BREAK = registerSoundEvent("block.tone.break");
    public static final SoundEvent BLOCK_TONE_STEP = registerSoundEvent("block.tone.step");
    public static final SoundEvent BLOCK_TONE_PLACE = registerSoundEvent("block.tone.place");
    public static final SoundEvent BLOCK_TONE_HIT = registerSoundEvent("block.tone.hit");
    public static final SoundEvent BLOCK_TONE_FALL = registerSoundEvent("block.tone.fall");

    public static final SoundEvent BLOCK_TONE_BRICKS_BREAK = registerSoundEvent("block.tone_bricks.break");
    public static final SoundEvent BLOCK_TONE_BRICKS_STEP = registerSoundEvent("block.tone_bricks.step");
    public static final SoundEvent BLOCK_TONE_BRICKS_PLACE = registerSoundEvent("block.tone_bricks.place");
    public static final SoundEvent BLOCK_TONE_BRICKS_HIT = registerSoundEvent("block.tone_bricks.hit");
    public static final SoundEvent BLOCK_TONE_BRICKS_FALL = registerSoundEvent("block.tone_bricks.fall");

    public static final SoundEvent BLOCK_ZTONE_BREAK = registerSoundEvent("block.ztone.break");
    public static final SoundEvent BLOCK_ZTONE_STEP = registerSoundEvent("block.ztone.step");
    public static final SoundEvent BLOCK_ZTONE_PLACE = registerSoundEvent("block.ztone.place");
    public static final SoundEvent BLOCK_ZTONE_HIT = registerSoundEvent("block.ztone.hit");
    public static final SoundEvent BLOCK_ZTONE_FALL = registerSoundEvent("block.ztone.fall");

    public static final SoundEvent BLOCK_FLEQ_BREAK = registerSoundEvent("block.fleq.break");
    public static final SoundEvent BLOCK_FLEQ_STEP = registerSoundEvent("block.fleq.step");
    public static final SoundEvent BLOCK_FLEQ_PLACE = registerSoundEvent("block.fleq.place");
    public static final SoundEvent BLOCK_FLEQ_HIT = registerSoundEvent("block.fleq.hit");
    public static final SoundEvent BLOCK_FLEQ_FALL = registerSoundEvent("block.fleq.fall");

    public static final SoundEvent BLOCK_GLAXX_BREAK = registerSoundEvent("block.glaxx.break");
    public static final SoundEvent BLOCK_GLAXX_STEP = registerSoundEvent("block.glaxx.step");
    public static final SoundEvent BLOCK_GLAXX_PLACE = registerSoundEvent("block.glaxx.place");
    public static final SoundEvent BLOCK_GLAXX_HIT = registerSoundEvent("block.glaxx.hit");
    public static final SoundEvent BLOCK_GLAXX_FALL = registerSoundEvent("block.glaxx.fall");

    public static final SoundEvent BLOCK_FORTT_DOOR_OPEN = registerSoundEvent("block.fortt_door.open");
    public static final SoundEvent BLOCK_FORTT_DOOR_CLOSE = registerSoundEvent("block.fortt_door.close");

    public static final SoundEvent BLOCK_FORTT_BREAK = registerSoundEvent("block.fortt.break");
    public static final SoundEvent BLOCK_FORTT_STEP = registerSoundEvent("block.fortt.step");
    public static final SoundEvent BLOCK_FORTT_PLACE = registerSoundEvent("block.fortt.place");
    public static final SoundEvent BLOCK_FORTT_HIT = registerSoundEvent("block.fortt.hit");
    public static final SoundEvent BLOCK_FORTT_FALL = registerSoundEvent("block.fortt.fall");

    public static final SoundEvent BLOCK_ISZM_BREAK = registerSoundEvent("block.iszm.break");
    public static final SoundEvent BLOCK_ISZM_STEP = registerSoundEvent("block.iszm.step");
    public static final SoundEvent BLOCK_ISZM_PLACE = registerSoundEvent("block.iszm.place");
    public static final SoundEvent BLOCK_ISZM_HIT = registerSoundEvent("block.iszm.hit");
    public static final SoundEvent BLOCK_ISZM_FALL = registerSoundEvent("block.iszm.fall");

    public static final SoundEvent BLOCK_ROEN_DOOR_OPEN = registerSoundEvent("block.roen_door.open");
    public static final SoundEvent BLOCK_ROEN_DOOR_CLOSE = registerSoundEvent("block.roen_door.close");

    public static final SoundEvent BLOCK_ROEN_BREAK = registerSoundEvent("block.roen.break");
    public static final SoundEvent BLOCK_ROEN_STEP = registerSoundEvent("block.roen.step");
    public static final SoundEvent BLOCK_ROEN_PLACE = registerSoundEvent("block.roen.place");
    public static final SoundEvent BLOCK_ROEN_HIT = registerSoundEvent("block.roen.hit");
    public static final SoundEvent BLOCK_ROEN_FALL = registerSoundEvent("block.roen.fall");

    public static final SoundEvent BLOCK_LAIR_DOOR_OPEN = registerSoundEvent("block.lair_door.open");
    public static final SoundEvent BLOCK_LAIR_DOOR_CLOSE = registerSoundEvent("block.lair_door.close");

    public static final SoundEvent BLOCK_LAIR_BREAK = registerSoundEvent("block.lair.break");
    public static final SoundEvent BLOCK_LAIR_STEP = registerSoundEvent("block.lair.step");
    public static final SoundEvent BLOCK_LAIR_PLACE = registerSoundEvent("block.lair.place");
    public static final SoundEvent BLOCK_LAIR_HIT = registerSoundEvent("block.lair.hit");
    public static final SoundEvent BLOCK_LAIR_FALL = registerSoundEvent("block.lair.fall");

    public static final SoundEvent BLOCK_TYEL_BREAK = registerSoundEvent("block.tyel.break");
    public static final SoundEvent BLOCK_TYEL_STEP = registerSoundEvent("block.tyel.step");
    public static final SoundEvent BLOCK_TYEL_PLACE = registerSoundEvent("block.tyel.place");
    public static final SoundEvent BLOCK_TYEL_HIT = registerSoundEvent("block.tyel.hit");
    public static final SoundEvent BLOCK_TYEL_FALL = registerSoundEvent("block.tyel.fall");

    public static final SoundEvent BLOCK_MINN_DOOR_OPEN = registerSoundEvent("block.minn_door.open");
    public static final SoundEvent BLOCK_MINN_DOOR_CLOSE = registerSoundEvent("block.minn_door.close");

    public static final SoundEvent BLOCK_MINN_BREAK = registerSoundEvent("block.minn.break");
    public static final SoundEvent BLOCK_MINN_STEP = registerSoundEvent("block.minn.step");
    public static final SoundEvent BLOCK_MINN_PLACE = registerSoundEvent("block.minn.place");
    public static final SoundEvent BLOCK_MINN_HIT = registerSoundEvent("block.minn.hit");
    public static final SoundEvent BLOCK_MINN_FALL = registerSoundEvent("block.minn.fall");

    public static final SoundEvent BLOCK_KRYP_DOOR_OPEN = registerSoundEvent("block.kryp_door.open");
    public static final SoundEvent BLOCK_KRYP_DOOR_CLOSE = registerSoundEvent("block.kryp_door.close");

    public static final SoundEvent BLOCK_KRYP_BASE_BREAK = registerSoundEvent("block.kryp_base.break");
    public static final SoundEvent BLOCK_KRYP_BASE_STEP = registerSoundEvent("block.kryp_base.step");
    public static final SoundEvent BLOCK_KRYP_BASE_PLACE = registerSoundEvent("block.kryp_base.place");
    public static final SoundEvent BLOCK_KRYP_BASE_HIT = registerSoundEvent("block.kryp_base.hit");
    public static final SoundEvent BLOCK_KRYP_BASE_FALL = registerSoundEvent("block.kryp_base.fall");

    public static final SoundEvent BLOCK_KRYP_BREAK = registerSoundEvent("block.kryp.break");
    public static final SoundEvent BLOCK_KRYP_STEP = registerSoundEvent("block.kryp.step");
    public static final SoundEvent BLOCK_KRYP_PLACE = registerSoundEvent("block.kryp.place");
    public static final SoundEvent BLOCK_KRYP_HIT = registerSoundEvent("block.kryp.hit");
    public static final SoundEvent BLOCK_KRYP_FALL = registerSoundEvent("block.kryp.fall");

    public static final SoundEvent BLOCK_KRYP_NODE_BREAK = registerSoundEvent("block.kryp_node.break");
    public static final SoundEvent BLOCK_KRYP_NODE_PLACE = registerSoundEvent("block.kryp_node.place");

    public static final SoundEvent BLOCK_LITHIUM_BREAK = registerSoundEvent("block.lithium.break");
    public static final SoundEvent BLOCK_LITHIUM_STEP = registerSoundEvent("block.lithium.step");
    public static final SoundEvent BLOCK_LITHIUM_PLACE = registerSoundEvent("block.lithium.place");
    public static final SoundEvent BLOCK_LITHIUM_HIT = registerSoundEvent("block.lithium.hit");
    public static final SoundEvent BLOCK_LITHIUM_FALL = registerSoundEvent("block.lithium.fall");
    
    public static final SoundEvent BLOCK_ZKUL_BREAK = registerSoundEvent("block.zkul.break");
    public static final SoundEvent BLOCK_ZKUL_STEP = registerSoundEvent("block.zkul.step");
    public static final SoundEvent BLOCK_ZKUL_PLACE = registerSoundEvent("block.zkul.place");
    public static final SoundEvent BLOCK_ZKUL_HIT = registerSoundEvent("block.zkul.hit");
    public static final SoundEvent BLOCK_ZKUL_FALL = registerSoundEvent("block.zkul.fall");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Super.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
