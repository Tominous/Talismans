package com.willfp.talismans.display.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.willfp.eco.util.plugin.AbstractEcoPlugin;
import com.willfp.eco.util.protocollib.AbstractPacketAdapter;
import com.willfp.talismans.display.TalismanDisplay;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PacketWindowItems extends AbstractPacketAdapter {
    /**
     * Instantiate a new listener for {@link PacketType.Play.Server#WINDOW_ITEMS}.
     *
     * @param plugin The plugin to listen through.
     */
    public PacketWindowItems(@NotNull final AbstractEcoPlugin plugin) {
        super(plugin, PacketType.Play.Server.WINDOW_ITEMS, false);
    }

    @Override
    public void onSend(@NotNull final PacketContainer packet,
                       @NotNull final Player player) {
        packet.getItemListModifier().modify(0, itemStacks -> {
            if (itemStacks == null) {
                return null;
            }
            itemStacks.forEach(TalismanDisplay::displayTalisman);
            return itemStacks;
        });
    }
}
