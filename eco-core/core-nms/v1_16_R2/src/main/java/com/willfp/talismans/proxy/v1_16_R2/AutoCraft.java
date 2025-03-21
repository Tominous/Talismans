package com.willfp.talismans.proxy.v1_16_R2;

import com.willfp.talismans.proxy.proxies.AutoCraftProxy;
import net.minecraft.server.v1_16_R2.MinecraftKey;
import net.minecraft.server.v1_16_R2.PacketPlayOutAutoRecipe;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public final class AutoCraft implements AutoCraftProxy {
    @Override
    public void modifyPacket(@NotNull final Object packet) throws NoSuchFieldException, IllegalAccessException {
        PacketPlayOutAutoRecipe recipePacket = (PacketPlayOutAutoRecipe) packet;
        Field fKey = recipePacket.getClass().getDeclaredField("b");
        fKey.setAccessible(true);
        MinecraftKey key = (MinecraftKey) fKey.get(recipePacket);
        fKey.set(recipePacket, new MinecraftKey("talismans", key.getKey() + "_displayed"));
    }
}
