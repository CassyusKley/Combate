package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class CommandsBlock implements Listener {
    private final Main main;

    public CommandsBlock(Main pl) {
        this.main = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);

    }

    @EventHandler
    public void block(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();

        if (main.getManager().contains(player.getName())) {
            if (player.isOp()) {

                return;
            }
            e.setCancelled(true);

            player.sendMessage("§4§lCombate: §cvocê não pode usar comandos enquanto está em combate");
        }
    }
}
