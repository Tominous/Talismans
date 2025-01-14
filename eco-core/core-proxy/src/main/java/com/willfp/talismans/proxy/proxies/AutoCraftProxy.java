package com.willfp.talismans.proxy.proxies;

import com.willfp.eco.util.proxy.AbstractProxy;
import org.jetbrains.annotations.NotNull;

public interface AutoCraftProxy extends AbstractProxy {
    /**
     * Fix crafting inventory on auto-recipe.
     *
     * @param packet The packet to modify.
     */
    void modifyPacket(@NotNull Object packet) throws NoSuchFieldException, IllegalAccessException;
}
