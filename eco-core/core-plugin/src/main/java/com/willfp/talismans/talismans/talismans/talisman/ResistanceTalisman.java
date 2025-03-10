package com.willfp.talismans.talismans.talismans.talisman;

import com.willfp.talismans.talismans.Talisman;
import com.willfp.talismans.talismans.Talismans;
import com.willfp.talismans.talismans.meta.TalismanStrength;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;

public class ResistanceTalisman extends Talisman {
    public ResistanceTalisman() {
        super("resistance_talisman", TalismanStrength.TALISMAN);
    }

    @Override
    public void onDamage(@NotNull final Player victim,
                         @NotNull final EntityDamageEvent event) {
        event.setDamage(event.getDamage() * (1 - (this.getConfig().getDouble(Talismans.CONFIG_LOCATION + "percent-less-damage")) / 100));
    }
}
