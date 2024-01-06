/* SOURCE:
 https://github.com/Alpha-s-Stuff/Nebula/blob/8fa67790b706a576bc6d687e1fc6f94a0f773d3c/src/main/java/me/alphamode/nebula/Nebula.java
*/

package net.leafenzo.ltones;

import net.minecraft.util.Identifier;

public class Super {
    public static String MOD_ID = "ltones";

    public static Identifier asResource(String path) {
        return new Identifier(MOD_ID, path.toLowerCase().replace(' ', '_')); // Silently make the path lowercase if it's not.
    }
}
