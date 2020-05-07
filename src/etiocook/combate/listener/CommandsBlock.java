package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandsBlock implements Listener {
    public Main pl;

    public CommandsBlock(Main pl) {
        this.pl = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);

    }

    @EventHandler
    public void block(PlayerCommandPreprocessEvent e){
        Player player = e.getPlayer();

        if(Main.getInstance().getManager().contains(player.getName())) {
            e.setCancelled(true);

            player.sendMessage("§4§lCombate: §cvocê não pode usar comandos enquanto está em combate");
        }
    }
}
