package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Teleport implements Listener {
    private final Main main;

    public Teleport(Main pl) {
        this.main = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);

    }

    @EventHandler
    public void teleport(PlayerTeleportEvent e) {
        Player player = e.getPlayer();

        if (main.getManager().contains(player.getName())) {
            e.setCancelled(true);

            player.sendMessage("§4§lCombate: §cvocê nao pode ser teleportado enquanto estiver em combate");
        }

    }
}
