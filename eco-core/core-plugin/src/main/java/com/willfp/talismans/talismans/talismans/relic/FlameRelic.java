package com.willfp.talismans.talismans.talismans.relic;

import com.willfp.talismans.talismans.Talisman;
import com.willfp.talismans.talismans.Talismans;
import com.willfp.talismans.talismans.meta.TalismanStrength;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.NotNull;

public class FlameRelic extends Talisman {
    public FlameRelic() {
        super("flame_relic", TalismanStrength.RELIC);
    }

    @Override
    public void onDamage(@NotNull final Player victim,
                         @NotNull final EntityDamageEvent event) {
        if (event.getCause() != EntityDamageEvent.DamageCause.FIRE && event.getCause() != EntityDamageEvent.DamageCause.FIRE_TICK) {
            return;
        }

        event.setDamage(event.getDamage() * this.getConfig().getDouble(Talismans.CONFIG_LOCATION + "multiplier"));
    }
}
